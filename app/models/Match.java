package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Match extends Model{
	
	private int series_id;
	private int series_type;
	private long match_id;
	private long match_seq_num;
	private long start_time;
	private int radiant_team_id;
	private int dire_team_id;
	private int lobby_time;
	
	@OneToMany
	private List<Player> players = new ArrayList<Player>();

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
