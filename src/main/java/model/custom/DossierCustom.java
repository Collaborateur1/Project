package model.custom;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Entity;
import javax.persistence.Table;

import model.bean.DefaultDossier;
@Entity
@Table(name="Dossier")
public class DossierCustom extends DefaultDossier {

    @Override
    public boolean presave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        System.out.println( "*********************************************************************************************************************" );
        return false;
    }

    @Override
    public boolean postsave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        
        return false;
    }
}
