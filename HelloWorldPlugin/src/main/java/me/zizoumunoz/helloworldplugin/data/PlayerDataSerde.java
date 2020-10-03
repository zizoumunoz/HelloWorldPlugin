package me.zizoumunoz.helloworldplugin.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Charsets;

public class PlayerDataSerde {

	private File file;
	private Map<UUID, PlayerData> playerMap;
	private static final Yaml YAML = new Yaml();

	public PlayerDataSerde(File file) {
		this.file = file;
	}

	public void save() {
		Map<String, Object> yaml = new HashMap<>();
		for (UUID key : playerMap.keySet()) {
			yaml.put(key.toString(), playerMap.get(key).serialize());
		}
		try {
			YAML.dump(yaml, new OutputStreamWriter(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		if (file.exists()) {
			try {
				Map<String, Object> yaml = YAML.load(new InputStreamReader(new FileInputStream(file), Charsets.UTF_8));
				for (String key : yaml.keySet()) {
					playerMap.put(UUID.fromString(key), PlayerData.deserialize((Map<String, Object>) yaml.get(key)));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			playerMap = new HashMap<>();
			save();
		}
	}

	public Map<UUID, PlayerData> getPlayerMap() {
		return playerMap;
	}

}
