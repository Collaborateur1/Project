package model.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import model.custom.DossierCustom;
import model.dao.Executable;
import model.menu.Globalmenu;
import other.SpringFactory;



@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultUser extends Globalmenu implements Serializable, Executable ,java.security.Principal {
   
    
    public enum Role {
        Editor, Visitor, Contributor,Connected
    };
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long dusID;
   
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
    
    //@BatchSize(size=10)
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
    @JoinTable( name = "User_Dossier", joinColumns = {
            @JoinColumn( name = "id", nullable = false, updatable = false ) }, inverseJoinColumns = {
                    @JoinColumn( name = "dosID", nullable = false, updatable = false ) })
    @JsonManagedReference
    private List<DossierCustom> dusDossier;

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



    public Long getDusID() {
        return dusID;
    }



    public void setDusID( Long dusID ) {
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
           this.setDusPict("/puls/inc/pictures/default.png");
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



    public List<DossierCustom> getDusDossier() {
        return dusDossier;
    }



    public void setDusDossier( List<DossierCustom> dusDossier ) {
        this.dusDossier = dusDossier;
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
           
            FileReader fr = null;
            BufferedReader br = null;
            try {
                /*DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document= builder.parse(new File("C:\\fichiers\\menu.xml")); 
                String st =document.getChildNodes().toString();
            
        
                System.out.println( st );*/
                
                File f=new File("C:\\fichiers\\menu.xml");
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
                e.printStackTrace();
            }
            
         }
            
            
            
        }
        
        private void parseMenu(){
            if(dusParameters!=null)
            {
                Globalmenu object =(Globalmenu) SpringFactory.getJab2Marshaller().unmarshal( new StreamSource(new StringReader(dusParameters.toString())));

            this.getSection().addAll( object.getSection());
            this.setDefaultpage( object.getDefaultpage() );
            this.setCurrentpage(object.getDefaultpage());
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
        public long getID() throws Exception {
            // TODO Auto-generated method stub
            return getDusID();
        }


        
}
