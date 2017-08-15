package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Hero;
import models.MatchObj;
import models.MatchResult;
import models.Player;
import play.mvc.Controller;
import util.DOTA2_API;
import util.Utility;

public class HistoryController extends Controller {

	//获取最近的比赛记录，用于获取最近的所有比赛
	public static void getHistory() {
		List<Hero> heros = Hero.findAll();
		Map<Long, Hero> heroMap = new HashMap<Long, Hero>();
		for (Hero hero : heros) {
			heroMap.put(hero.getId(), hero);
		}
		System.out.println("hero size:" + heros.size());
		List<MatchObj> matches = DOTA2_API.get_match_history(null, null, -1, 10);
		List<MatchResult> results = new ArrayList<MatchResult>();
		long last_match = 0;
		for (int i = 0; i < matches.size(); i++) {
			MatchObj match = matches.get(i);
			List<Hero> radian_heros = new ArrayList<Hero>();
			List<Hero> dire_heros = new ArrayList<Hero>();
			for (Player player : match.getPlayers()) {
				long hero_id = player.getHero_id();
				long slot = player.getPlayer_slot();

				Hero hero = heroMap.getOrDefault(hero_id, null);
				if (hero == null)
					continue;
				if (slot > 120) {
					radian_heros.add(hero);
				} else {
					dire_heros.add(hero);
				}
			}
			if (radian_heros.size() + dire_heros.size() != 10)
				continue;
			// last_match = match.match_id;
			if (last_match == 0) {
				last_match = match.match_id;
			}
			results.add(new MatchResult(radian_heros, dire_heros, Utility.get_date(match.start_time), match.match_id));
		}
		int total = results.size();
		render("matches.html", results, total, last_match);
	}

	public static void getPreHistory(String start_match_id) {
		System.out.println("start match id:" + start_match_id);
		List<Hero> heros = Hero.findAll();
		Map<Long, Hero> heroMap = new HashMap<Long, Hero>();
		for (Hero hero : heros) {
			heroMap.put(hero.getId(), hero);
		}
		System.out.println("hero size:" + heros.size());
		List<MatchObj> matches = DOTA2_API.get_match_history(null, null, Long.parseLong(start_match_id), 10);
		List<MatchResult> results = new ArrayList<MatchResult>();
		long last_match = 0;
		for (MatchObj match : matches) {
			List<Hero> radian_heros = new ArrayList<Hero>();
			List<Hero> dire_heros = new ArrayList<Hero>();
			for (Player player : match.getPlayers()) {
				long hero_id = player.getHero_id();
				long slot = player.getPlayer_slot();

				Hero hero = heroMap.getOrDefault(hero_id, null);
				if (hero == null)
					continue;
				if (slot > 120) {
					radian_heros.add(hero);
				} else {
					dire_heros.add(hero);
				}
			}
			if (radian_heros.size() + dire_heros.size() != 10)
				continue;
			// last_match = match.match_id;
			if (last_match == 0) {
				last_match = match.getMatch_id();
			}
			results.add(new MatchResult(radian_heros, dire_heros, Utility.get_date(match.start_time), match.match_id));
		}
		int total = results.size();
		render("matches.html", results, total, last_match);
	}

	public static void getHisBySeqNum() {
		List<Hero> heros = Hero.findAll();
		Map<Long, Hero> heroMap = new HashMap<Long, Hero>();
		for (Hero hero : heros) {
			heroMap.put(hero.getId(), hero);
		}
		System.out.println("hero size:" + heros.size());
		List<MatchObj> matches = DOTA2_API.get_match_history_by_seq_num( -1, 10);
		List<MatchResult> results = new ArrayList<MatchResult>();
		long last_match = 0;
		for (int i = 0; i < matches.size(); i++) {
			MatchObj match = matches.get(i);
			List<Hero> radian_heros = new ArrayList<Hero>();
			List<Hero> dire_heros = new ArrayList<Hero>();
			for (Player player : match.getPlayers()) {
				long hero_id = player.getHero_id();
				long slot = player.getPlayer_slot();

				Hero hero = heroMap.getOrDefault(hero_id, null);
				if (hero == null)
					continue;
				if (slot > 120) {
					radian_heros.add(hero);
				} else {
					dire_heros.add(hero);
				}
			}
			if (radian_heros.size() + dire_heros.size() != 10)
				continue;
			// last_match = match.match_id;
			if (last_match == 0) {
				last_match = match.match_id;
			}
			results.add(new MatchResult(radian_heros, dire_heros, Utility.get_date(match.start_time), match.match_id));
		}
		int total = results.size();
		render("matches.html", results, total, last_match);
	}

}
