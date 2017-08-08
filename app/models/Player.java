package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Player extends Model{
	
	public long account_id;
	public int player_slot;
	public int hero_id;
	
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public int getPlayer_slot() {
		return player_slot;
	}
	public void setPlayer_slot(int player_slot) {
		this.player_slot = player_slot;
	}
	public int getHero_id() {
		return hero_id;
	}
	public void setHero_id(int hero_id) {
		this.hero_id = hero_id;
	}
	
	

}
