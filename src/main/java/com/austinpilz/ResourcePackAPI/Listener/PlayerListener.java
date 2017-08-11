package com.austinpilz.ResourcePackAPI.Listener;

import com.austinpilz.ResourcePackAPI.ResourcePackAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class PlayerListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onResourceUpdate(PlayerResourcePackStatusEvent event)
    {
        if (ResourcePackAPI.playerController.getPlayer(event.getPlayer()).getResourcePackRequest() != null)
        {
            ResourcePackAPI.playerController.getPlayer(event.getPlayer()).getResourcePackRequest().responseReceived(event.getStatus());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        ResourcePackAPI.playerController.getPlayer(event.getPlayer()); //Add them to memory
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        ResourcePackAPI.playerController.removePlayer(event.getPlayer()); //Remove them from memory
    }
}
