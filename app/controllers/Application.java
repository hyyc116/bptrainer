package controllers;

import play.*;
import play.mvc.*;
import util.DOTA2_API;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void updateHeroes(){
    	List<Hero> existing_heroes = Hero.findAll();
    	Set<Long> existing_ids = new HashSet<Long>();
    	for(Hero hero : existing_heroes){
    		existing_ids.add(hero.getId());
    	}
    	List<Hero> heroes = DOTA2_API.update_heros_list();
    	int num_of_new = 0;
    	for(Hero hero:heroes){
    		if(!existing_ids.contains(hero.getId())){
    			hero.save();
    			num_of_new+=1;
    		}
    	}
    	render(num_of_new,"hero_item.html");
    }

}