package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import commons.ConstantVar;
import models.Hero;
import models.ResponseObj;
import models.Item;
import models.MatchObj;

public class DOTA2_API {
	
	public static Crawler crawler = Crawler.getInstance();
	
	
	public static String get_content(String url){
		try {
			crawler.crawl(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crawler.getContent();
	}
	
	public static String get_json(String url){
		String json_str = get_content(url);
		System.out.println(json_str);
		return json_str;
	}
	
	//Get Hero List
	public static List<Hero> update_heros_list(){
		String url = String.format("https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?key=%s&language=zh_cn",ConstantVar.API_KEY);
		String content = get_content(url);
		List<Hero> heroes = new ArrayList<Hero>();
		ResponseObj response = JSON.parseObject(content,ResponseObj.class);
//		for(Hero hero : response.getResult().getHeroes()){
//			System.out.println(hero.getLocalized_name()+"\t"+hero.get_full_img());
//		}
		heroes = response.getResult().getHeroes();
		return heroes;
	}
	
	// get item List
	public static List<Item> update_item_list(){
		String url = "https://api.steampowered.com/IEconDOTA2_570/GetGameItems/V001/?key="+ConstantVar.API_KEY+"&language=zh_cn";
		url = String.format(url,ConstantVar.API_KEY);
		String content = get_content(url);
		List<Item> items = JSON.parseObject(content,ResponseObj.class).getResult().getItems();
//		for(Item item:items){
//			System.out.println(item.getLocalized_name()+"\t"+item.getSecret_shop()+"\t"+item.getSide_shop()+"\t"+item.get_img_path());
//		}
		return items;
	}
	
	// 获取比赛记录
	public static void get_match_history(String league_id,String game_mode){
		String url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v0001/?key="+ConstantVar.API_KEY+"&min_players=10";
		StringBuilder urlStr = new StringBuilder(url);
		if(league_id!=null){
			urlStr.append("&league_id=");
			urlStr.append(league_id);
		}
		if(game_mode!=null){
			urlStr.append("&game_mode=");
			urlStr.append(game_mode);
		}
		url = urlStr.toString();
		System.out.println("URL:"+url);
		String content = get_content(url);
		ResponseObj history = JSON.parseObject(content, ResponseObj.class);
		List<MatchObj> matches = history.getResult().getMatches();
		System.out.println("Size of Result:"+matches.size());
		for(MatchObj match: matches){
			System.out.println(match.getMatch_id()+"\t"+match.getStart_time()+"\t"+Utility.get_date(match.getStart_time()));
		}
	}
	
	public static void get_match_history_by_seq_num(String league_id,String game_mode,long start_match_id){
		String url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistoryBySequenceNum/v0001/?key="+ConstantVar.API_KEY+"&min_players=10";
		StringBuilder urlStr = new StringBuilder(url);
		if(league_id!=null){
			urlStr.append("&league_id=");
			urlStr.append(league_id);
		}
		if(game_mode!=null){
			urlStr.append("&game_mode=");
			urlStr.append(game_mode);
		}
		if(start_match_id!=-1){
			urlStr.append("&start_match_id=");
			urlStr.append(start_match_id);
		}
		url = urlStr.toString();
		System.out.println("URL:"+url);
		String content = get_content(url);
		ResponseObj history = JSON.parseObject(content, ResponseObj.class);
		List<MatchObj> matches = history.getResult().getMatches();
		System.out.println("Size of Result:"+matches.size());
		System.out.println("Total Result:"+history.getResult().getTotal_results());
		for(MatchObj match: matches){
			System.out.println(match.getMatch_id()+"\t"+match.getStart_time()+"\t"+Utility.get_date(match.getStart_time()));
		}
	}
	
	
	
	// 获得所有的比赛名
	public static void get_League_list(){
		String url = "https://api.steampowered.com/IDOTA2Match_570/GetLeagueListing/v0001/?key="+ConstantVar.API_KEY;
		System.out.println(url);
	}
	
	//获取比赛详情
	public static void get_match_detail(String match_id){
		String url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?match_id="+match_id+"&key="+ConstantVar.API_KEY;
		System.out.println(url);
	}
	
	public static void main(String[] args) {
		DOTA2_API api = new DOTA2_API();
		// heros
//		api.update_heros_list();

		//items
		api.update_item_list();
		
		//match history
//		api.get_match_history(null,null);
//		api.get_match_history_by_seq_num(null, null,-1);
		
		// leagues
//		api.get_League_list();;
		
		// match details
//		api.get_match_detail("3361918709");
		
	}
		
	
	

}
