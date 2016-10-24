//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.11 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.10.24 alle 02:44:51 PM CEST 
//


package com.blog.samples.webservices.servicedetail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.blog.samples.webservices.DetailService;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DetailService" type="{http://webservices.samples.blog.com}DetailService"/&gt;
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
    "detailService"
})
@XmlRootElement(name = "ServiceCallResponse")
public class ServiceCallResponse {

    @XmlElement(name = "DetailService", required = true)
    protected DetailService detailService;

    /**
     * Recupera il valore della proprietà detailService.
     * 
     * @return
     *     possible object is
     *     {@link DetailService }
     *     
     */
    public DetailService getDetailService() {
        return detailService;
    }

    /**
     * Imposta il valore della proprietà detailService.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailService }
     *     
     */
    public void setDetailService(DetailService value) {
        this.detailService = value;
    }

}
