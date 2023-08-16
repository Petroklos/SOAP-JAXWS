// Java SOAP WebApp Service using JAX-WS

package com.soapWebServiceJAXWS;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

// To turn the ScoreService into a SOAP web service, it needs to be decorated with two annotations:
// One to indicate the class complies with all of the semantics of a stateless Enterprise JavaBeans (EJB) architecture
// and another to indicate that the public methods in the class can be accessed through a SOAP-based service.

@Stateless
@WebService
public class ScoreService {
	private static Score score = new Score();	
	
	@WebMethod
	public String setWins (int wins) { score.setWins(wins); return "Wins set to: " + score.getWins(); }
	@WebMethod
	public String setLosses (int losses) { score.setLosses(losses); return "Losses set to: " + score.getLosses(); }
	@WebMethod
	public String setTies (int ties) { score.setTies(ties); return "Ties set to: " + score.getTies(); }

	@WebMethod
	public String getWins () { return "The current wins are: " + score.getWins(); }
	@WebMethod
	public String getLosses () { return "The current losses are: " + score.getLosses(); }
	@WebMethod
	public String getTies () { return "The current ties are: " + score.getTies(); }

	@WebMethod
	public String increaseWins () { score.increaseWins(); return "The wins have been increased to: " + score.getWins(); }
	@WebMethod
	public String increaseLosses () { score.increaseLosses(); return "The ties have been increased to: " + score.getLosses(); }
	@WebMethod
	public String increaseTies () { score.increaseTies(); return "The losses have been increased to: " + score.getTies(); }

	@WebMethod(operationName="getScores")
	public String getScores () {
		return "The current score is:\n" +
				score.getWins() + "\twins\n" +
				score.getLosses() + "\tlosses\n" +
				score.getTies() + "\tties";
	}

	@WebMethod(operationName="setScores")
	public Score setScores (int wins, int losses, int ties) {
		score.setWins(wins);
		score.setLosses(losses);
		score.setTies(ties);
		return score;
	}
	
	@WebMethod(operationName="resetScores")
	public void resetScores () { score.resetScores(); }
}