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
    private Long id;
   
    @Column(name="User_Nom")
    private String nom;
    
    @Column(name="User_Prenom")
    private String prenom;
    
    @Column(name="User_Adress")
    private String adress;
    
    @Column(name="User_Tel")
    private String tel;
    
    @Column(name="User_Email")
    private String email;
  
    @Column(name="User_Pict")
    private String urlPict;
    
    @Column(name="User_IsAdmin")
    private boolean isAdmin;
    
    @Column(name="User_parameters")
    StringBuffer parameters;
    
    
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable( name = "User_Dossier", joinColumns = {
            @JoinColumn( name = "id", nullable = false, updatable = false ) }, inverseJoinColumns = {
                    @JoinColumn( name = "dossierId", nullable = false, updatable = false ) })
    private List<DossierCustom> userDossier;
    
    
   


    //@Transient
    @Column(name="UserToken")
    private String token;
   /* @Column(name = "Roles")
    @ElementCollection
    @Enumerated(EnumType.STRING)*/
    @Transient
    private Set<Role> roles;
   
    
    public boolean isAdmin() {
        return isAdmin;
    }


    public void setAdmin( boolean isAdmin ) {
        this.isAdmin = isAdmin;
    }


    private byte[] mdp;
    
    
        public DefaultUser() {
            super();
          
        }
       
        
        public Long getId() {
            return id;
        }

        public void setId( Long id ) {
            this.id = id;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom( String prenom ) {
            //org.directwebremoting.WebContextFactory test; 
            
            this.prenom = prenom;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress( String adress ) {
            this.adress = adress;
        }

        public String getTel() {
            return tel;
        }

        public void setTel( String tel ) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail( String email ) {
            this.email = email;
        }

        public String getNom() {
            return nom;
        }

        public void setNom( String nom ) {
            this.nom = nom;
        }

        public String getUrlPict() {
            
            if(urlPict==null)
            {
               this.setUrlPict("/puls/inc/pictures/default.png");
            }
            return urlPict;
        }

        public void setUrlPict( String urlPict ) {
            this.urlPict = urlPict;
        }


        public byte[] getMdp() {
            return mdp;
        }


        public void setMdp( byte[] bs ) {
            this.mdp = bs;
        }


        public Set<Role> getRoles() {
            return roles;
        }

       
        public void setRoles( Set<Role> roles ) {
            this.roles = roles;
        }
        public void addRole( Role role ) {
            if(this.roles==null)
                this.roles= new HashSet<Role>(); 
            this.roles.add(role);
        }


        @Override
        public String getName() {
            // TODO Auto-generated method stub
            return null;
        }


        public String getToken() {
            return token;
        }


        public void setToken( String token ) {
            this.token = token;
        }


        public StringBuffer getParameters() {
            if(parameters==null)
             loadDefaultMenu();
            
            return parameters;
        }


        public void setParameters( StringBuffer parameters ) {
            this.parameters = parameters;
            parseMenu();
        }

        public List<DossierCustom> getUserDossier() {
            return userDossier;
        }


        public void setUserDossier( List<DossierCustom> userDossier ) {
            this.userDossier = userDossier;
        }
   
        public Globalmenu getMenu(){
            return this;
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
                parameters=new StringBuffer();
                while(br.ready())
                {
                    parameters.append(br.readLine()+"\n");
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
            if(parameters!=null)
            {
                Globalmenu object =(Globalmenu) SpringFactory.getJab2Marshaller().unmarshal( new StreamSource(new StringReader(parameters.toString())));

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
        public long getID() throws Exception {
            // TODO Auto-generated method stub
            return id;
        }
}
