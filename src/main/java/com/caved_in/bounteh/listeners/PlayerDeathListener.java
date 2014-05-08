package com.caved_in.bounteh.listeners;

import com.caved_in.bounteh.bounties.BountyManager;
import com.caved_in.commons.item.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class PlayerDeathListener implements Listener {
	@EventHandler
	public void onEvent(PlayerDeathEvent event) {
		Player player = event.getEntity();
		UUID playerId = player.getUniqueId();
		//If the player doesn't have a bounty, then cancel execution
		if (!BountyManager.playerHasActiveBounty(playerId)) {
			return;
		}

		String playerName = player.getName();
		//Make the players head to be added to the drops
		ItemStack playerHead = Items.getSkull(playerName);
		event.getDrops().add(playerHead);
	}
}
