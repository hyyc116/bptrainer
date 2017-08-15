package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Player extends Model{
	
	public long account_id;
	public int player_slot;
	public Long hero_id;
	public int item_0;
	public int item_1;
	public int item_2;
	public int item_3;
	public int item_4;
	public int item_5;
	public int backpack_0;
	public int backpack_1;
	public int backpack_2;
	public int kills;
	public int deaths;
	public int assists;
	public int leaver_status;
	public int last_hits;
	public int denies;
	public int gold_per_min;
	public int xp_per_min;
	public int level;
	public int hero_damage;
	public int tower_damage;
	public int hero_healing;
	public int gold;
	public int gold_spent;
	public int scaled_hero_damage;
	public int scaled_tower_damage;
	public int scaled_hero_healing; 
	
	@ManyToOne
	@JoinColumn(name="match_id")
	public MatchObj match;
	
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

	public Long getHero_id() {
		return hero_id;
	}

	public void setHero_id(Long hero_id) {
		this.hero_id = hero_id;
	}

	public int getItem_0() {
		return item_0;
	}

	public void setItem_0(int item_0) {
		this.item_0 = item_0;
	}

	public int getItem_1() {
		return item_1;
	}

	public void setItem_1(int item_1) {
		this.item_1 = item_1;
	}

	public int getItem_2() {
		return item_2;
	}

	public void setItem_2(int item_2) {
		this.item_2 = item_2;
	}

	public int getItem_3() {
		return item_3;
	}

	public void setItem_3(int item_3) {
		this.item_3 = item_3;
	}

	public int getItem_4() {
		return item_4;
	}

	public void setItem_4(int item_4) {
		this.item_4 = item_4;
	}

	public int getItem_5() {
		return item_5;
	}

	public void setItem_5(int item_5) {
		this.item_5 = item_5;
	}

	public int getBackpack_0() {
		return backpack_0;
	}

	public void setBackpack_0(int backpack_0) {
		this.backpack_0 = backpack_0;
	}

	public int getBackpack_1() {
		return backpack_1;
	}

	public void setBackpack_1(int backpack_1) {
		this.backpack_1 = backpack_1;
	}

	public int getBackpack_2() {
		return backpack_2;
	}

	public void setBackpack_2(int backpack_2) {
		this.backpack_2 = backpack_2;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getLeaver_status() {
		return leaver_status;
	}

	public void setLeaver_status(int leaver_status) {
		this.leaver_status = leaver_status;
	}

	public int getLast_hits() {
		return last_hits;
	}

	public void setLast_hits(int last_hits) {
		this.last_hits = last_hits;
	}

	public int getDenies() {
		return denies;
	}

	public void setDenies(int denies) {
		this.denies = denies;
	}

	public int getGold_per_min() {
		return gold_per_min;
	}

	public void setGold_per_min(int gold_per_min) {
		this.gold_per_min = gold_per_min;
	}

	public int getXp_per_min() {
		return xp_per_min;
	}

	public void setXp_per_min(int xp_per_min) {
		this.xp_per_min = xp_per_min;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHero_damage() {
		return hero_damage;
	}

	public void setHero_damage(int hero_damage) {
		this.hero_damage = hero_damage;
	}

	public int getTower_damage() {
		return tower_damage;
	}

	public void setTower_damage(int tower_damage) {
		this.tower_damage = tower_damage;
	}

	public int getHero_healing() {
		return hero_healing;
	}

	public void setHero_healing(int hero_healing) {
		this.hero_healing = hero_healing;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold_spent() {
		return gold_spent;
	}

	public void setGold_spent(int gold_spent) {
		this.gold_spent = gold_spent;
	}

	public int getScaled_hero_damage() {
		return scaled_hero_damage;
	}

	public void setScaled_hero_damage(int scaled_hero_damage) {
		this.scaled_hero_damage = scaled_hero_damage;
	}

	public int getScaled_tower_damage() {
		return scaled_tower_damage;
	}

	public void setScaled_tower_damage(int scaled_tower_damage) {
		this.scaled_tower_damage = scaled_tower_damage;
	}

	public int getScaled_hero_healing() {
		return scaled_hero_healing;
	}

	public void setScaled_hero_healing(int scaled_hero_healing) {
		this.scaled_hero_healing = scaled_hero_healing;
	}
	
}
