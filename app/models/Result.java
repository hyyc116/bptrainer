package models;

import java.util.ArrayList;
import java.util.List;

public class Result {
	
	private int status;
	private int num_results;
	private int total_results;
	private int results_remaining;
	private List<Match> matches  = new ArrayList<Match>();
	private List<Hero> heroes = new ArrayList<Hero>();
	private List<Item> Items = new ArrayList<Item>();
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNum_results() {
		return num_results;
	}
	public void setNum_results(int num_results) {
		this.num_results = num_results;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	public int getResults_remaining() {
		return results_remaining;
	}
	public void setResults_remaining(int results_remaining) {
		this.results_remaining = results_remaining;
	}
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	public List<Hero> getHeroes() {
		return heroes;
	}
	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}
	public List<Item> getItems() {
		return Items;
	}
	public void setItems(List<Item> items) {
		Items = items;
	}
	
}
