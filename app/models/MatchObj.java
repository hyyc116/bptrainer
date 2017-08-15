package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.GenericModel;



@Entity
public class MatchObj extends GenericModel{
	
	public int series_id;
	public int series_type;
	@Id
	public long match_id;
	public long match_seq_num;
	public long start_time;
	public int radiant_team_id;
	public int dire_team_id;
	public int lobby_type;
	public boolean radiant_win;
	public long duration;
	public int tower_status_radiant;
	public int tower_status_dire;
	public int barracks_status_radiant;
	public int barracks_status_dire;
	public int cluster;
	public long first_blood_time;
	public int human_players;
	public int leagueid;
	public int positive_votes;
	public int negative_votes;
	public int game_mode;
	public int flags;
	public int engine;
	public int radiant_score;
	public int dire_score;
	
	
	@OneToMany(mappedBy="match")
	public List<Player> players;

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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getLobby_type() {
		return lobby_type;
	}

	public void setLobby_type(int lobby_type) {
		this.lobby_type = lobby_type;
	}

	public boolean isRadiant_win() {
		return radiant_win;
	}

	public void setRadiant_win(boolean radiant_win) {
		this.radiant_win = radiant_win;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getTower_status_radiant() {
		return tower_status_radiant;
	}

	public void setTower_status_radiant(int tower_status_radiant) {
		this.tower_status_radiant = tower_status_radiant;
	}

	public int getTower_status_dire() {
		return tower_status_dire;
	}

	public void setTower_status_dire(int tower_status_dire) {
		this.tower_status_dire = tower_status_dire;
	}

	public int getBarracks_status_radiant() {
		return barracks_status_radiant;
	}

	public void setBarracks_status_radiant(int barracks_status_radiant) {
		this.barracks_status_radiant = barracks_status_radiant;
	}

	public int getBarracks_status_dire() {
		return barracks_status_dire;
	}

	public void setBarracks_status_dire(int barracks_status_dire) {
		this.barracks_status_dire = barracks_status_dire;
	}

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	public long getFirst_blood_time() {
		return first_blood_time;
	}

	public void setFirst_blood_time(long first_blood_time) {
		this.first_blood_time = first_blood_time;
	}

	public int getHuman_players() {
		return human_players;
	}

	public void setHuman_players(int human_players) {
		this.human_players = human_players;
	}

	public int getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(int leagueid) {
		this.leagueid = leagueid;
	}

	public int getPositive_votes() {
		return positive_votes;
	}

	public void setPositive_votes(int positive_votes) {
		this.positive_votes = positive_votes;
	}

	public int getNegative_votes() {
		return negative_votes;
	}

	public void setNegative_votes(int negative_votes) {
		this.negative_votes = negative_votes;
	}

	public int getGame_mode() {
		return game_mode;
	}

	public void setGame_mode(int game_mode) {
		this.game_mode = game_mode;
	}

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public int getRadiant_score() {
		return radiant_score;
	}

	public void setRadiant_score(int radiant_score) {
		this.radiant_score = radiant_score;
	}

	public int getDire_score() {
		return dire_score;
	}

	public void setDire_score(int dire_score) {
		this.dire_score = dire_score;
	}
	
	
	
	
}
