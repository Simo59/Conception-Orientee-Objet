package main.strategy;

/**
 * Abstract class for the Design Pattern Strategy
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 *
 */

public class FirstOfEachGroupStrategyTwoPools extends FirstOfEachGroupStrategy {

	@Override
	public int getNbOfPools() {
		return 2;
	}
	
	@Override
	public int getNbOfCompetitors() {
		return 8;
	}
}
