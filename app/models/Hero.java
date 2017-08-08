package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.Model;

@Entity
public class Hero extends Model {
	@Id
	private long id;
	private String name;
	private String localized_name;
	
	public String get_sb_img(){
		String img_path = "http://cdn.dota2.com/apps/dota2/images/heroes/"+this.name.replace("npc_dota_hero_", "");
		return img_path+"_sb.png";
	}
	
	public String get_lg_img(){
		String img_path = "http://cdn.dota2.com/apps/dota2/images/heroes/"+this.name.replace("npc_dota_hero_", "");
		return img_path+"_lg.png";
	}
	
	public String get_full_img(){
		String img_path = "http://cdn.dota2.com/apps/dota2/images/heroes/"+this.name.replace("npc_dota_hero_", "");
		return img_path+"_full.png";
	}
	
	public String get_vert_img(){
		String img_path = "http://cdn.dota2.com/apps/dota2/images/heroes/"+this.name.replace("npc_dota_hero_", "");
		return img_path+"_vert.jpg";
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalized_name() {
		return localized_name;
	}

	public void setLocalized_name(String localized_name) {
		this.localized_name = localized_name;
	}

}
