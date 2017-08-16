package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Utility {

	public static Date get_date(long unixtime) {
		return new Date(unixtime * 1000);
	}

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	// two dict
	public static Map<Integer, String> get_mode_dict() {
		String modes = "0 - None;1 - All Pick;2 - Captain's Mode;3 - Random Draft;4 - Single Draft;5 - All Random;6 - Intro;7 - Diretide;8 - Reverse Captain's Mode;9 - The Greeviling;10 - Tutorial;11 - Mid Only;12 - Least Played;13 - New Player Pool;14 - Compendium Matchmaking;15 - Co-op vs Bots;16 - Captains Draft;18 - Ability Draft;20 - All Random Deathmatch;21 - 1v1 Mid Only;22 - Ranked Matchmaking";
		Map<Integer, String> mode_dict = new HashMap<Integer, String>();
		for (String mode : modes.split(";")) {
			String[] mode_str = mode.split("-");
			mode_dict.put(Integer.parseInt(mode_str[0].trim()), mode_str[1].trim());
		}
		return mode_dict;
	}

	public static Map<Integer, String> get_cluster_dict() {
		String clusters = "111: US West;121: US East;122: US East;131: Europe West;132: Europe West;133: Europe West;151: Southeast Asia;152: Southeast Asia;161: China;163: China;171: Australia;181: Russia;182: Russia;191: Europe East;200: South America";
		Map<Integer, String> cluster_dict = new HashMap<Integer, String>();
		for (String cluster : clusters.split(";")) {
			String[] cluster_str = cluster.split(":");
			cluster_dict.put(Integer.parseInt(cluster_str[0].trim()), cluster_str[1].trim());
		}
		cluster_dict.put(0, "None");
		return cluster_dict;
	}

	public static String mapToStr(Map<Integer, Integer> map) {
		StringBuilder cluster_str = new StringBuilder();
		for (int key : map.keySet()) {
			cluster_str.append(key);
			cluster_str.append("-");
			cluster_str.append(map.get(key));
			cluster_str.append(";");
		}
		return cluster_str.toString();
	}

	public static Map<Integer, Integer> strToMap(String mapstr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String kv : mapstr.split(";")) {
			String[] k_v = kv.split("-");
			int key = Integer.parseInt(k_v[0]);
			int value = Integer.parseInt(k_v[1]);
			map.put(key, value);
		}
		return map;
	}
}
