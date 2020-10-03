package me.zizoumunoz.helloworldplugin.data;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.util.NumberConversions;

public class PlayerData {

	private int points;

	public static PlayerData deserialize(Map<String, Object> yaml) {

		PlayerData playerData = new PlayerData();
		playerData.points = NumberConversions.toInt(yaml.get("points"));
		return playerData;

	}

	public Map<String, Object> serialize() {
		Map<String, Object> yaml = new HashMap<>();
		yaml.put("points", points);
		return yaml;
	}

}
