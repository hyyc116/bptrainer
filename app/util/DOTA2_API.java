package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import commons.ConstantVar;
import jdk.nashorn.internal.scripts.JS;
import models.Hero;
import models.Item;
import models.League;
import models.MatchObj;
import models.MatchResponse;
import models.MatchResult;
import models.ResponseObj;

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
	public static List<MatchObj> get_match_history(String league_id,String game_mode,long start_match_id,int matches_requested){
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
		if(start_match_id!=-1){
			urlStr.append("&start_match_id=");
			urlStr.append(start_match_id);
		}
		
		if(matches_requested!=-1){
			urlStr.append("&matches_requested=");
			urlStr.append(matches_requested);
		}
		url = urlStr.toString();
		System.out.println("URL:"+url);
		String content = get_content(url);
		ResponseObj history = JSON.parseObject(content, ResponseObj.class);
		return history.getResult().getMatches();
	}
	
	public static List<MatchObj> get_match_history_by_seq_num(long start_at_match_seq_num,int matches_requested){
		String url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistoryBySequenceNum/v0001/?key="+ConstantVar.API_KEY+"&min_players=10";
		StringBuilder urlStr = new StringBuilder(url);
		
		if(start_at_match_seq_num!=-1){
			urlStr.append("&start_at_match_seq_num=");
			urlStr.append(start_at_match_seq_num);
		}
		if(matches_requested!=-1){
			urlStr.append("&matches_requested=");
			urlStr.append(matches_requested);
		}
		url = urlStr.toString();
		System.out.println("URL:"+url);
		String content = get_content(url);
		ResponseObj history = JSON.parseObject(content, ResponseObj.class);
		return history.getResult().getMatches();
	}
	
	// 获得所有的比赛名
	public static List<League> get_League_list(){
		String url = "https://api.steampowered.com/IDOTA2Match_570/GetLeagueListing/v0001/?key="+ConstantVar.API_KEY+"&language=zh_cn";
		String content = get_content(url);
		ResponseObj response = JSON.parseObject(content,ResponseObj.class);
		return response.getResult().getLeagues();
	}
	
	//获取比赛详情
	public static void get_match_detail(String match_id){
		String url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?match_id="+match_id+"&key="+ConstantVar.API_KEY;
		System.out.println(url);
		String content = get_content(url);
//		System.out.println(content);
		MatchObj match =  JSON.parseObject(content,MatchResponse.class).getResult();
		match.save();
	}
	
	public static void main(String[] args) {
		DOTA2_API api = new DOTA2_API();
		// heros
//		api.update_heros_list();

		//items
//		api.update_item_list();
		
		//match history
		long last_seq=496;
		for(int i=0;i<10;i++){
			System.out.println("======");
			for(MatchObj match : api.get_match_history_by_seq_num(last_seq,2)){
				System.out.println(match.getMatch_id());
//				session.save(match);
				last_seq = match.getMatch_seq_num();
//				match.save();
			}
		}
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		// HeroHome hh = new HeroHome();
//		Session session = sessionFactory.openSession();
//		for()
//		for(MatchObj match : api.get_match_history_by_seq_num(-1,2)){
//			System.out.println(match.getMatch_id());
////			session.save(match);
////			match.save();
//		}
//		session.getTransaction().commit();
//		session.close();
//		sessionFactory.close();
		
		// leagues
//		api.get_League_list();;
		
		// match details
//		api.get_match_detail("3368387319");
//		api.get_League_list();
		
		
	}
		
	
	

}
