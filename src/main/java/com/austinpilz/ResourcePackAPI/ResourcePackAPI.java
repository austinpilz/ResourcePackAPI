package com.austinpilz.ResourcePackAPI;

import com.austinpilz.ResourcePackAPI.Listener.PlayerListener;
import com.austinpilz.ResourcePackAPI.Manager.PlayerController;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class ResourcePackAPI extends JavaPlugin {

    public static final String consolePrefix = "[ResourcePackAPI] ";

    public static ResourcePackAPI instance;
    public static final Logger log = Logger.getLogger("Minecraft");

    public static PlayerController playerController;

    @Override
    public void onEnable()
    {
        instance = this;
        playerController = new PlayerController();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

    }
}
