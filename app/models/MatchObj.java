package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class MatchObj extends Model{
	
	@Column(name="sid")
	public int series_id;
	@Column(name="st")
	public int series_type;
	@Column(name="mid")
	public long match_id;
	@Column(name="msu")
	public long match_seq_num;
	@Column(name="stm")
	public long start_time;
	@Column(name="rti")
	public int radiant_team_id;
	@Column(name="dti")
	public int dire_team_id;
	@Column(name="lt")
	public int lobby_time;
	
	@ManyToMany
	public List<Player> players = new ArrayList<Player>();

	public int getSeries_id() {
		return series_id;
	}

	public void setSeries_id(int series_id) {
		this.series_id = series_id;
	}

	public int getSeries_type() {
		return series_type;
	}

	public void setSeries_type(int series_type) {
		this.series_type = series_type;
	}

	public long getMatch_id() {
		return match_id;
	}

	public void setMatch_id(long match_id) {
		this.match_id = match_id;
	}

	public long getMatch_seq_num() {
		return match_seq_num;
	}

	public void setMatch_seq_num(long match_seq_num) {
		this.match_seq_num = match_seq_num;
	}

	public long getStart_time() {
		return start_time;
	}

	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}

	public int getRadiant_team_id() {
		return radiant_team_id;
	}

	public void setRadiant_team_id(int radiant_team_id) {
		this.radiant_team_id = radiant_team_id;
	}

	public int getDire_team_id() {
		return dire_team_id;
	}

	public void setDire_team_id(int dire_team_id) {
		this.dire_team_id = dire_team_id;
	}

	public int getLobby_time() {
		return lobby_time;
	}

	public void setLobby_time(int lobby_time) {
		this.lobby_time = lobby_time;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
