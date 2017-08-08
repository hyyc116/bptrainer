package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.Model;
@Entity
public class Item extends Model {
	private String name;
	@Id
	public Long id;
	public int cost;
	public int secret_shop;
	public int side_shop;
	public String localized_name;
	public int recipe;
	
	public String get_img_path(){
		return "http://cdn.dota2.com/apps/dota2/images/items/"+name.replace("item_", "")+"_lg.png";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSecret_shop() {
		return secret_shop;
	}
	public void setSecret_shop(int secret_shop) {
		this.secret_shop = secret_shop;
	}
	public int getSide_shop() {
		return side_shop;
	}
	public void setSide_shop(int side_shop) {
		this.side_shop = side_shop;
	}
	public String getLocalized_name() {
		return localized_name;
	}
	public void setLocalized_name(String localized_name) {
		this.localized_name = localized_name;
	}
	public int getRecipe() {
		return recipe;
	}
	public void setRecipe(int recipe) {
		this.recipe = recipe;
	}
	
	
}
