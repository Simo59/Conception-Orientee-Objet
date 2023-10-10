package main.observers;

import main.match.Match;

/**
 * An Observer class
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */
public interface Observer {

	public void update(Observable arg, Match match);
	
}