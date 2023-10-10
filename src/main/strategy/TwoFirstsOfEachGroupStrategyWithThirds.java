package main.strategy;

/**
 * Abstract class for the Design Pattern Strategy 
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 * 
 */
public class TwoFirstsOfEachGroupStrategyWithThirds extends TwoFirstsOfEachGroupStrategy {

	@Override
	public int getNbOfPools() {
		return 3;
	}

	@Override
	public int getNbOfCompetitors() {
		return 24;
	}

}