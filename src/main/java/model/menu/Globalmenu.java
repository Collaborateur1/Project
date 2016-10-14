//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.10.12 à 04:55:39 PM CST 
//


package model.menu;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="menu" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="classe" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="sousmenu" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="underclasse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="defaultpage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="currentpage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "menu"
})
@XmlRootElement(name = "globalmenu")
public class Globalmenu {

    @XmlElement(required = true)
    protected List<Globalmenu.Menu> menu;
    @XmlAttribute(name = "defaultpage")
    protected String defaultpage;
    @XmlAttribute(name = "currentpage")
    protected String currentpage;

    /**
     * Gets the value of the menu property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menu property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenu().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Globalmenu.Menu }
     * 
     * 
     */
    public List<Globalmenu.Menu> getMenu() {
        if (menu == null) {
            menu = new ArrayList<Globalmenu.Menu>();
        }
        return this.menu;
    }

    /**
     * Obtient la valeur de la propriété defaultpage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultpage() {
        return defaultpage;
    }

    /**
     * Définit la valeur de la propriété defaultpage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultpage(String value) {
        this.defaultpage = value;
    }

    /**
     * Obtient la valeur de la propriété currentpage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentpage() {
        return currentpage;
    }

    /**
     * Définit la valeur de la propriété currentpage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentpage(String value) {
        this.currentpage = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="classe" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="sousmenu" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="underclasse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "classe",
        "title",
        "sousmenu"
    })
    public static class Menu {

        @XmlElement(required = true)
        protected String classe;
        @XmlElement(required = true)
        protected String title;
        @XmlElement(required = true)
        protected List<Globalmenu.Menu.Sousmenu> sousmenu;

        /**
         * Obtient la valeur de la propriété classe.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClasse() {
            return classe;
        }

        /**
         * Définit la valeur de la propriété classe.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClasse(String value) {
            this.classe = value;
        }

        /**
         * Obtient la valeur de la propriété title.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Définit la valeur de la propriété title.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the sousmenu property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sousmenu property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSousmenu().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Globalmenu.Menu.Sousmenu }
         * 
         * 
         */
        public List<Globalmenu.Menu.Sousmenu> getSousmenu() {
            if (sousmenu == null) {
                sousmenu = new ArrayList<Globalmenu.Menu.Sousmenu>();
            }
            return this.sousmenu;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="underclasse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "template",
            "title",
            "underclasse"
        })
        public static class Sousmenu {

            @XmlElement(required = true)
            protected String template;
            @XmlElement(required = true)
            protected String title;
            @XmlElement(required = true)
            protected String underclasse;

            /**
             * Obtient la valeur de la propriété template.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTemplate() {
                return template;
            }

            /**
             * Définit la valeur de la propriété template.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTemplate(String value) {
                this.template = value;
            }

            /**
             * Obtient la valeur de la propriété title.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTitle() {
                return title;
            }

            /**
             * Définit la valeur de la propriété title.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTitle(String value) {
                this.title = value;
            }

            /**
             * Obtient la valeur de la propriété underclasse.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnderclasse() {
                return underclasse;
            }

            /**
             * Définit la valeur de la propriété underclasse.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnderclasse(String value) {
                this.underclasse = value;
            }

        }

    }

}
