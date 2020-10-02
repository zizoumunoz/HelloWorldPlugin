package me.zizoumunoz.helloworldplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class TestListener implements Listener {

	@EventHandler
	public void onFillBucket(PlayerBucketFillEvent fillBucket) {
		fillBucket.getPlayer().setExp(1000000);
	}

}
