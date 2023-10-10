package main.observers;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import main.competition.Competitor;
import main.match.Match;


/**
 * A class which simulate a Journalist.
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */
public class Journalist implements Observer {
	
	protected PrintStream out;
	private int compteur = 0;
	protected String name;
	
	private String[] commentary = {"%s won the match over %s%s, score was 4 - 2 ",
			"Oooh, what a sensational victory for %s ! %s%s is definitely au fond du trou !",
			"OMG ! L'equipe %s extermine son oposant %s%s ",
			"%s won the match over %s%s, score was 7 - 0 "};
	
	public Journalist(String name) {
		this.name = name;
		this.out = System.out;
	}
	
	public Journalist(PrintStream out) {
		this.out = out;
	}
	
	@Override
	public void update(Observable arg0, Match match) {
		
		Competitor lastWinner = match.getLastWinner();	
		StringBuffer sb = new StringBuffer();
		
		boolean alreadyPrintName = false;
		List<Competitor> players = match.getPlayers();
		for (int idx = 0; idx < players.size(); idx++) {
			Competitor competitor = players.get(idx);
			if (competitor != lastWinner) {
				sb.append(String.format("[Journalist (%s)] "+ commentary[compteur],name,lastWinner.getName() , alreadyPrintName?" and ":"",competitor.getName()));
				alreadyPrintName = true;
			}
		}
		compteur = (compteur + 1)%commentary.length;
		this.out.printf(sb.append("\n").toString());
		
	}

}
