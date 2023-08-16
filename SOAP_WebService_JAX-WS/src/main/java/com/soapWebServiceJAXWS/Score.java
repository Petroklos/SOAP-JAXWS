package com.soapWebServiceJAXWS;

// Since the data the Score class encapsulates will be sent to SOAP web services clients in XML format, the class requires an @XMLType annotation.
// Furthermore, since the class has no getter methods, the XML engine will need to look directly at the properties of the Score class.
// So, add an @XmlAccessorType annotation that indicates field-based access.

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Score {
	private int wins, losses, ties;
	
	public Score() {
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
	}
	
	public Score(int wins, int losses, int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
	}
	
	public void setWins (int wins) { this.wins = wins; }
	public void setLosses (int losses) { this.losses = losses; }
	public void setTies (int ties) { this.ties = ties; }
	
	public int getWins () { return wins; }
	public int getLosses () { return losses; }
	public int getTies () { return ties; }
	
	public void increaseWins () { wins++; }
	public void increaseLosses () { losses++; }
	public void increaseTies () { ties++; }
	
	public void resetScores () { wins = losses = ties = 0; }
	
	public String toString() { return "Wins:" + wins +  ";Losses:" + losses + ";Ties:" + ties; }
}