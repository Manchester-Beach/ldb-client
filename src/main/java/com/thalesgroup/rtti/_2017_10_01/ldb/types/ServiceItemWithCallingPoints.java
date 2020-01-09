
package com.thalesgroup.rtti._2017_10_01.ldb.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * An individual service's summary details with calling points for display on a "WithDetails" departure board.
 * 
 * <p>Java class for ServiceItemWithCallingPoints complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceItemWithCallingPoints"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://thalesgroup.com/RTTI/2017-10-01/ldb/types}ServiceItem"&gt;
 *       &lt;group ref="{http://thalesgroup.com/RTTI/2017-10-01/ldb/types}CallingListProperties"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceItemWithCallingPoints", propOrder = {
    "previousCallingPoints",
    "subsequentCallingPoints"
})
public class ServiceItemWithCallingPoints
    extends ServiceItem
{

    protected ArrayOfArrayOfCallingPoints previousCallingPoints;
    protected ArrayOfArrayOfCallingPoints subsequentCallingPoints;

    /**
     * Gets the value of the previousCallingPoints property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfCallingPoints }
     *     
     */
    public ArrayOfArrayOfCallingPoints getPreviousCallingPoints() {
        return previousCallingPoints;
    }

    /**
     * Sets the value of the previousCallingPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfCallingPoints }
     *     
     */
    public void setPreviousCallingPoints(ArrayOfArrayOfCallingPoints value) {
        this.previousCallingPoints = value;
    }

    /**
     * Gets the value of the subsequentCallingPoints property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfCallingPoints }
     *     
     */
    public ArrayOfArrayOfCallingPoints getSubsequentCallingPoints() {
        return subsequentCallingPoints;
    }

    /**
     * Sets the value of the subsequentCallingPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfCallingPoints }
     *     
     */
    public void setSubsequentCallingPoints(ArrayOfArrayOfCallingPoints value) {
        this.subsequentCallingPoints = value;
    }

}
