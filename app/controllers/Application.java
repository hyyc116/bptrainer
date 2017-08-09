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
    	
    	// 更新 英雄和物品的列表
    	List<Hero> existing_heroes = Hero.findAll();
    	Set<Long> existing_ids = new HashSet<Long>();
    	for(Hero hero : existing_heroes){
    		existing_ids.add(hero.getId());
    	}
    	
    	List<Hero> heroes = DOTA2_API.update_heros_list();
    	System.out.println("number of heros:"+heroes.size());
    	int num_of_new_hero = 0;
    	for(Hero hero:heroes){
    		if(!existing_ids.contains(hero.getId())){
//    			System.out.println(hero.getLocalized_name());
    			hero.save();
    			num_of_new_hero+=1;
    		}
    	}
    	
    	int num_of_new_items=0;
    	List<Item> existing_items = Item.findAll();
    	Set<Long> item_ids = new HashSet<Long>();
    	for(Item item:existing_items){
    		item_ids.add(item.getId());
    	}
    	
    	List<Item> items = DOTA2_API.update_item_list();
    	System.out.println("Number of items:"+items.size());
    	for(Item item:items){
    		if(item_ids.contains(item.getId())) continue;
    		item.save();
    		num_of_new_items+=1;
//    		System.out.println(item.getLocalized_name());
    	}
    	List<Item> show_items = new ArrayList<Item>();
    	for(Item item:items){
    		String lname = item.getLocalized_name();
    		if(lname.contains("卷轴") || lname.contains("河水"))
    			continue;
    		show_items.add(item);
    	}
    	
    	render("hero_item.html",num_of_new_hero,num_of_new_items,heroes,show_items);
    }

}