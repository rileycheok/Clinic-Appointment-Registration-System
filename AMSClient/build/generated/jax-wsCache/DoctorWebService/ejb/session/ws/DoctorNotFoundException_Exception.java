
package ejb.session.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DoctorNotFoundException", targetNamespace = "http://ws.session.ejb/")
public class DoctorNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DoctorNotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DoctorNotFoundException_Exception(String message, DoctorNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DoctorNotFoundException_Exception(String message, DoctorNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ejb.session.ws.DoctorNotFoundException
     */
    public DoctorNotFoundException getFaultInfo() {
        return faultInfo;
    }

}
