package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.MatchObj;
import models.Stats;
import play.mvc.Controller;
import util.Utility;

public class MatchController extends Controller {
	
	/**
	 * 对现已抓取的比赛数据进行统计
	 */
	public static void matches() {
		Map<Integer, String> mode_dict = Utility.get_mode_dict();
		Map<Integer, String> cluster_dict = Utility.get_cluster_dict();
		
		/*** 获取比赛的统计数据 ***/
		long stats_id = 10086;
		Stats stats = Stats.findById(stats_id);
		// 获取比赛的数量
		long numberOfMatch = stats.getTotalcount();
		String start_date = "0";
		String end_date = "0";
		if (numberOfMatch > 0) {
			start_date = Utility.formatDate(stats.getStart_time());
			end_date = Utility.formatDate(stats.getLast_time());
		}
		// 对现有模式
		Map<Integer, Integer> cmap = Utility.strToMap(stats.getCluster_dict());
		Map<Integer, Integer> gmap = Utility.strToMap(stats.getGm_dict());
		
		String update_date = Utility.formatDate(stats.getUpdatetime());
		
//		MatchObj.
		// 区域统计
		render("all_matches.html", numberOfMatch, start_date, end_date, cmap, gmap,mode_dict,cluster_dict,update_date);
	}

}
