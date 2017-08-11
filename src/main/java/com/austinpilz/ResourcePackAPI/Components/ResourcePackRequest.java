package com.austinpilz.ResourcePackAPI.Components;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ResourcePackRequest {

    private Player player;
    private String name;
    private String resourcePackURL;

    private String successMessage;
    private String failureMessage;
    private boolean kickOnFailure;

    private boolean success;

    public ResourcePackRequest(String name, Player p, String url, String successMessage, String failMessage, boolean kick)
    {
        this.player = p;
        this.name = name;
        this.resourcePackURL = url;
        this.successMessage = successMessage;
        this.failureMessage = failMessage;
        this.kickOnFailure = kick;
        this.success = false;
    }

    public void sendRequest()
    {
        player.setResourcePack(resourcePackURL);
    }

    public void responseReceived(PlayerResourcePackStatusEvent.Status status)
    {
        if (status.equals(PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED))
        {
            if (!successMessage.isEmpty())
            {
                player.sendMessage(successMessage);
            }

            success = true;
        }
        else if (status.equals(PlayerResourcePackStatusEvent.Status.DECLINED) || status.equals(PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD))
        {
            //The resource pack is not installed
            if (kickOnFailure)
            {
                if (!failureMessage.isEmpty())
                {
                    player.kickPlayer(failureMessage);
                }
                else
                {
                    player.kickPlayer("Resource pack required.");
                }
            }
        }
    }

    public String getName()
    {
        return name;
    }

    public boolean didSucceed()
    {
        return success;
    }

}
