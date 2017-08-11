package com.austinpilz.ResourcePackAPI.Manager;

import com.austinpilz.ResourcePackAPI.Components.ResourcePackRequest;
import org.bukkit.entity.Player;

public class PlayerResourceManager {

    private Player player;
    private ResourcePackRequest resourcePackRequest;

    public PlayerResourceManager(Player player)
    {
        this.player = player;
    }

    public ResourcePackRequest getResourcePackRequest() {
        return resourcePackRequest;
    }

    public void newResourcePackRequest(ResourcePackRequest request)
    {
        resourcePackRequest = request;
    }
}
