package main.competition;


/**
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 */

public class Competitor {

	private String name;
	private int nbWin;
	
	/**
	 * @param name of competitor
	 * Constructor
	 */
	public Competitor(String name) {
		this.name = name;
		nbWin = 0;
	}
	
	// Getters and setters

	public String getName() {
		return name;
	}


	public int getNbWin() {
		return nbWin;
	}

	
	public void increaseNbWin() {
		nbWin++;
	}

	
	public void increaseNbWinBy(int n) {
		nbWin += n;
	}
	
}
