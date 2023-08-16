
package com.soapwebservicejaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for score complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="score">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wins" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="losses" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ties" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "score", propOrder = {
    "wins",
    "losses",
    "ties"
})
public class Score {

    protected int wins;
    protected int losses;
    protected int ties;

    /**
     * Gets the value of the wins property.
     * 
     */
    public int getWins() {
        return wins;
    }

    /**
     * Sets the value of the wins property.
     * 
     */
    public void setWins(int value) {
        this.wins = value;
    }

    /**
     * Gets the value of the losses property.
     * 
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Sets the value of the losses property.
     * 
     */
    public void setLosses(int value) {
        this.losses = value;
    }

    /**
     * Gets the value of the ties property.
     * 
     */
    public int getTies() {
        return ties;
    }

    /**
     * Sets the value of the ties property.
     * 
     */
    public void setTies(int value) {
        this.ties = value;
    }

}
