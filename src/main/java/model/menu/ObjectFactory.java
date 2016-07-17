//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.06.27 à 02:14:57 PM CST 
//


package model.menu;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Globalmenu }
     * 
     */
    public Globalmenu createGlobalmenu() {
        return new Globalmenu();
    }

    /**
     * Create an instance of {@link Globalmenu.Section }
     * 
     */
    public Globalmenu.Section createGlobalmenuSection() {
        return new Globalmenu.Section();
    }

    /**
     * Create an instance of {@link Globalmenu.Section.Menu }
     * 
     */
    public Globalmenu.Section.Menu createGlobalmenuSectionMenu() {
        return new Globalmenu.Section.Menu();
    }

    /**
     * Create an instance of {@link Globalmenu.Section.Menu.Sousmenu }
     * 
     */
    public Globalmenu.Section.Menu.Sousmenu createGlobalmenuSectionMenuSousmenu() {
        return new Globalmenu.Section.Menu.Sousmenu();
    }

}
