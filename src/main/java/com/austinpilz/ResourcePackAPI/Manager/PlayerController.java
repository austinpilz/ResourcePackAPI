package com.austinpilz.ResourcePackAPI.Manager;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerController {

    private HashMap<Player, PlayerResourceManager> players;

    public PlayerController()
    {
        players = new HashMap<>();
    }

    /**
     * Retrieves the resource manager for the supplied player
     * @param player
     * @return
     */
    public PlayerResourceManager getPlayer(Player player)
    {
        if (!doesPlayerExist(player))
        {
            addPlayer(player);
        }

        return players.get(player);
    }

    /**
     * Returns if that player exists in the management memory
     * @param player
     * @return
     */
    private boolean doesPlayerExist(Player player)
    {
        return players.containsKey(player);
    }

    /**
     * Adds a player to the management memory
     * @param player
     */
    private void addPlayer(Player player)
    {
        if (!doesPlayerExist(player))
        {
            players.put(player, new PlayerResourceManager(player));
        }
    }

    /**
     * Removes a player from management memory
     * @param player
     */
    public void removePlayer(Player player)
    {
        players.remove(player);
    }
}
