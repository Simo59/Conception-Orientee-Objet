package main.observers;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.competition.Competitor;
import main.match.Match;

/**
 * Bookmaker Class
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 * 
 */

public class Bookmaker extends Journalist {
	
	private static String name;
	private String bookMakerName;
	private Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
	
	public Bookmaker(String name) {
		super(name);
		this.bookMakerName = name;
	}
	
	public Bookmaker(PrintStream out) {
		super(out);
	}
	
	@Override
	public void update(Observable arg0, Match match) {
		
		Competitor lastWinner = match.getLastWinner();
		
		Integer integer = cotes.compute(lastWinner, (k, v) -> (v==null?1:v));
				
		StringBuffer sb = new StringBuffer(String.format("[Bookmaker (%s)] %s (cote %d -> %d) win versus ", bookMakerName, lastWinner.getName(), integer, ((integer==1?integer:integer-1))));
		
		integer = removeCoteToCompetitor(lastWinner);

		boolean alreadyPrintName = false;
		List<Competitor> players = match.getPlayers();
		for (int idx = 0; idx < players.size(); idx++) {
			Competitor competitor = players.get(idx);
			if (competitor != lastWinner) {
				Integer integer2 = addCoteToCompetitor(competitor);

				sb.append(String.format("%s%s (cote %d -> %d)", alreadyPrintName?" and ":"", competitor.getName(), integer2-1, integer2));
				alreadyPrintName = true;
			}
		}
		
		this.out.printf(sb.append("\n").toString());
		
	}
	
	private Integer addCoteToCompetitor(Competitor competitor) {
		return cotes.compute(competitor, (k, v) -> (v==null?1:v)+1);
	}
	
	private Integer removeCoteToCompetitor(Competitor competitor) {
		return cotes.compute(competitor, (k, v) -> (v==null?1:(v>1?v-1:v)));
	}
	
	public Map<Competitor, Integer> getCotes() {
		return cotes;
	}

}