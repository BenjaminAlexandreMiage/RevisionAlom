
package alom.bank.client.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeAccount.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="typeAccount"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CHEQUES"/&gt;
 *     &lt;enumeration value="LIVRET_A"/&gt;
 *     &lt;enumeration value="LIVRET_DEVELOPPEMENT_DURABLE"/&gt;
 *     &lt;enumeration value="LIVRET_JEUNE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "typeAccount")
@XmlEnum
public enum TypeAccount {

    CHEQUES,
    LIVRET_A,
    LIVRET_DEVELOPPEMENT_DURABLE,
    LIVRET_JEUNE;

    public String value() {
        return name();
    }

    public static TypeAccount fromValue(String v) {
        return valueOf(v);
    }

}
