//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.11 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.10.24 alle 02:44:51 PM CEST 
//


package com.blog.samples.webservices.servicedetail;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.blog.samples.webservices.servicedetail package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.blog.samples.webservices.servicedetail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceCallRequest }
     * 
     */
    public ServiceCallRequest createServiceCallRequest() {
        return new ServiceCallRequest();
    }

    /**
     * Create an instance of {@link ServiceCallResponse }
     * 
     */
    public ServiceCallResponse createServiceCallResponse() {
        return new ServiceCallResponse();
    }

}
