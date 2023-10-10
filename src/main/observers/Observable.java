package main.observers;

import java.util.Collection;
import java.util.HashSet;

import main.match.Match;


/**
 * An Observable class
 * 
 * @author aymane.ismail.etu
 * @author mohammed.hachour.etu
 * PROJET COO 2022
 * 
 */
public class Observable {

	private Collection<Observer> observers = new HashSet<Observer>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void deleteObservers() {
		observers.clear();
	}
	
	public int countObservers() {
		return observers.size();
	}

	public void notifyObservers(Match match) {
		for (Observer observer : observers) {
			observer.update(this, match);
		}
	}
}
