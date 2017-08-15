package models;

import java.util.Date;
import java.util.List;

public class MatchResult {
	
	private List<Hero> radianHeros;
	private List<Hero> direHeros;
	private Date start_time;
	private Long match_id;
	public MatchResult(List<Hero> radianHeros, List<Hero> direHeros,Date start_time,long match_id) {
		super();
		this.radianHeros = radianHeros;
		this.direHeros = direHeros;
		this.start_time = start_time;
		this.match_id = match_id;
	}
	public List<Hero> getRadianHeros() {
		return radianHeros;
	}
	public void setRadianHeros(List<Hero> radianHeros) {
		this.radianHeros = radianHeros;
	}
	public List<Hero> getDireHeros() {
		return direHeros;
	}
	public void setDireHeros(List<Hero> direHeros) {
		this.direHeros = direHeros;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Long getMatch_id() {
		return match_id;
	}
	public void setMatch_id(Long match_id) {
		this.match_id = match_id;
	}
	
	
}
