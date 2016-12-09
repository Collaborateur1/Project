package model.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.Executable;
import model.menu.Globalmenu;
import other.SpringFactory;



@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultUser extends Globalmenu implements Serializable, Executable ,java.security.Principal {
   
    private static Logger logger = Logger.getLogger( DefaultUser.class );
    public enum Role {
        Editor, Visitor, Contributor,Connected
    };
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "dusID")
    private String dusID;
   
    @Column(name="dusName")
    private String dusName;
    
    @Column(name="dusSurname")
    private String dusSurname;
    
    @Column(name="dusAddress")
    private String dusAddress;
    
    @Column(name="dusNumber")
    private String dusNumber;
    
    @Column(name="dusEmail")
    private String dusEmail;
  
    @Column(name="dusPict")
    private String dusPict;
    @JsonIgnore
    @Column(name="dusIsAdmin")
    private boolean dusIsAdmin;
    @Transient
    @JsonIgnore
    @Column(name="dusParameters")
    StringBuffer dusParameters;
    @JsonIgnore
    @Column(name="dusMdp")
    private String dusMdp;
    

    //@Transient
    @JsonIgnore
    @Column(name="dusToken")
    private String dusToken;
   /* @Column(name = "Roles")
    @ElementCollection
    @Enumerated(EnumType.STRING)*/
    @Transient
    @JsonIgnore
    private Set<Role> dusRoles;
   
    @Transient
    @JsonIgnore
    private String dusIp;
    
    public String getDusIp() {
        return dusIp;
    }



    public void setDusIp( String dusIp ) {
        this.dusIp = dusIp;
    }



    public String getDusID() {
        return dusID;
    }



    public void setDusID( String dusID ) {
        this.dusID = dusID;
    }




    public String getDusName() {
        return dusName;
    }


    public void setDusName( String dusName ) {
        this.dusName = dusName;
    }


    public String getDusSurname() {
        return dusSurname;
    }



    public void setDusSurname( String dusSurname ) {
        this.dusSurname = dusSurname;
    }



    public String getDusAddress() {
        return dusAddress;
    }



    public void setDusAddress( String dusAddress ) {
        this.dusAddress = dusAddress;
    }



    public String getDusNumber() {
        return dusNumber;
    }


    public void setDusNumber( String dusNumber ) {
        this.dusNumber = dusNumber;
    }


    public String getDusEmail() {
        return dusEmail;
    }



    public void setDusEmail( String dusEmail ) {
        this.dusEmail = dusEmail;
    }




    public String getDusPict() {
        if(dusPict==null)
        {
           this.setDusPict("../inc/pictures/default.png");
        }
        return dusPict;
    }




    public void setDusPict( String dusPict ) {
        this.dusPict = dusPict;
    }


    public boolean isDusIsAdmin() {
        return dusIsAdmin;
    }



    public void setDusIsAdmin( boolean dusIsAdmin ) {
        this.dusIsAdmin = dusIsAdmin;
    }


    public StringBuffer getDusParameters() {
        if(dusParameters==null)
            loadDefaultMenu();
           
           return dusParameters;
    }



    public void setDusParameters( StringBuffer dusParameters ) {
        this.dusParameters = dusParameters;
    }




    public String getDusMdp() {
        return dusMdp;
    }



    public void setDusMdp( String dusMdp ) {
        this.dusMdp = dusMdp;
    }





    public String getDusToken() {
        return dusToken;
    }



    public void setDusToken( String dusToken ) {
        this.dusToken = dusToken;
    }



    public Set<Role> getDusRoles() {
        return dusRoles;
    }



    public void setDusRoles( Set<Role> dusRoles ) {
        this.dusRoles = dusRoles;
    } 
    public void addRole(Role role){
        if(this.dusRoles==null)
            this.dusRoles= new HashSet<Role>(); 
        this.dusRoles.add(role);
    }
    
        public DefaultUser() {
            super();
               
        }
       
        
     
        
       

       
        
        private void loadDefaultMenu()
        {
           /*
            FileReader fr = null;
            BufferedReader br = null;
           
            try {
                             
                Resource resource = new ClassPathResource("menu.xml");
             
                File f=resource.getFile();
                
                fr=new FileReader(f);
                br=new BufferedReader(fr);
                dusParameters=new StringBuffer();
                while(br.ready())
                {
                    dusParameters.append(br.readLine()+"\n");
                }
                
                parseMenu();
                
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
             try {
                fr.close();
                br.close();
                
            } catch ( IOException e ) {
                // TODO Auto-generated catch block
                logger.error( e.getStackTrace()[0].getMethodName(),e);
            }
            
         }*/
            
            parseJsonMenu(); 
            
        }
        
        private void parseMenu(){
            if(dusParameters!=null)
            {
                Globalmenu object =(Globalmenu) SpringFactory.getJab2Marshaller().unmarshal( new StreamSource(new StringReader(dusParameters.toString())));

            this.getMenu().addAll( object.getMenu());
            this.setDefaultpage( object.getDefaultpage() );
            this.setCurrentpage(object.getDefaultpage());
            }
        }
        private void parseJsonMenu(){
            
            ObjectMapper mapper = new ObjectMapper();
            Resource resource = new ClassPathResource("menu.json");
            File f=null;
            try {
                f=resource.getFile();
            } catch ( IOException e1 ) {
                // TODO Auto-generated catch block
                logger.error( e1.getStackTrace()[0].getMethodName(),e1);
            }
            //JSON from file to Object
            try {
                Globalmenu object = mapper.readValue(f, Globalmenu.class);
                this.getMenu().addAll( object.getMenu());
                this.setDefaultpage( object.getDefaultpage() );
                this.setCurrentpage(object.getDefaultpage());
            } catch ( JsonParseException e ) {
                // TODO Auto-generated catch block
                logger.error( e.getStackTrace()[0].getMethodName(),e);
            } catch ( JsonMappingException e ) {
                // TODO Auto-generated catch block
                logger.error( e.getStackTrace()[0].getMethodName(),e);
            } catch ( IOException e ) {
                // TODO Auto-generated catch block
                logger.error( e.getStackTrace()[0].getMethodName(),e);
            }

        
        }
        public void updateCurrentPage(String st)
        {
            this.setCurrentpage(st);
        }


        @Override
        public boolean presave( ConcurrentHashMap<String, Object> item ) {
            // TODO Auto-generated method stub
            return false;
        }


        @Override
        public boolean postsave( ConcurrentHashMap<String, Object> item ) {
            // TODO Auto-generated method stub
            return false;
        }



        @Override
        public String getName() {
            // TODO Auto-generated method stub
            return getDusName();
        }



        @Override
        public String getID() throws Exception {
            // TODO Auto-generated method stub
            return dusID;
        }



        
}
