package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.MatchObj;
import play.mvc.Controller;
import util.Utility;

public class MatchController extends Controller {
	
	/**
	 * 对现已抓取的比赛数据进行统计
	 */
	public static void matches() {
		Map<Integer, String> mode_dict = Utility.get_mode_dict();
		Map<Integer, String> cluster_dict = Utility.get_cluster_dict();
		
		// 获取比赛的数量
		long numberOfMatch = MatchObj.count();
		List<MatchObj> matches = MatchObj.find("order by start_time asc").fetch();
		String start_date = "0";
		String end_date = "0";
		if (matches.size() > 0) {
			start_date = Utility.formatDate(Utility.get_date(matches.get(0).getStart_time()));
			end_date = Utility.formatDate(Utility.get_date(matches.get(matches.size() - 1).getStart_time()));
		}
		// 对现有模式
		Map<String, Integer> zone_map = new HashMap<String, Integer>();
		Map<String, Integer> gm_map = new HashMap<String, Integer>();
		for (MatchObj match : matches) {
			String cluster_key = cluster_dict.get((int)match.getCluster());
			zone_map.put(cluster_key, zone_map.getOrDefault(cluster_key, 0) + 1);
			String mode_key = mode_dict.get((int)match.getGame_mode());
			gm_map.put(mode_key, gm_map.getOrDefault(mode_key, 0) + 1);
		}
		
//		MatchObj.
		// 区域统计
		render("all_matches.html", numberOfMatch, start_date, end_date, zone_map, gm_map);
	}

}
