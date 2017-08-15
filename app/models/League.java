package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.jtype.Generic;

import play.db.jpa.GenericModel;

@Entity
public class League extends GenericModel{

	@Id
	private long leagueid;
	private String name;
	private String description;
	private String tournament_url;
	private long itemdef;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getLeagueid() {
		return leagueid;
	}
	public void setLeagueid(long leagueid) {
		this.leagueid = leagueid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTournament_url() {
		return tournament_url;
	}
	public void setTournament_url(String tournament_url) {
		this.tournament_url = tournament_url;
	}
	public long getItemdef() {
		return itemdef;
	}
	public void setItemdef(long itemdef) {
		this.itemdef = itemdef;
	}
}
