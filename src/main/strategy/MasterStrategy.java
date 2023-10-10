package main.strategy;

import java.util.List;

import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.League;
import main.competition.Tournament;

/**
 * Interface for the Design Pattern Strategy for Masters
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 * 
 */

public interface MasterStrategy {

	/**
	 * @param pools League[]
	 * @return Tournament with all qualified Competitors
	 */
	public Tournament selectionPhaseFinal(League[] pools);
	
	/**
	 * @param competitors c
	 * @return league list
	 */
	public League[] remplissagePoule(List<Competitor> competitors);
	
	
	/**
	 * @param size int
	 * @throws NumberOfTwoCompetitorsSizeException e
	 */
	public void checkCorrectNumberOfCompetitor(int size) throws NumberOfTwoCompetitorsSizeException;

	public int getNbOfPools();
	
	public int getNbOfCompetitors();
	
	public int getNbOfQualifiquations();

	public int getNbOfRetrivials();
	
}