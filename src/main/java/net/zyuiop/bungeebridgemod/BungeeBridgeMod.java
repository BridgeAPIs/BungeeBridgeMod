package net.zyuiop.bungeebridgemod;

import net.bridgesapis.bungeebridge.BungeeBridge;
import net.bridgesapis.bungeebridge.core.database.DatabaseConnector;
import net.bridgesapis.bungeebridge.services.IChatListener;
import net.bridgesapis.bungeebridge.services.ServiceManager;
import net.md_5.bungee.api.plugin.Plugin;
import net.zyuiop.bungeebridgemod.commands.*;
import net.zyuiop.bungeebridgemod.moderation.ModMessageHandler;

/**
 * @author zyuiop
 */
public class BungeeBridgeMod extends Plugin {
    private final ChatListener chatListener = new ChatListener(BungeeBridge.getInstance());
    private final BungeeBridge instance = BungeeBridge.getInstance();

    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new CommandBan(this));
        getProxy().getPluginManager().registerCommand(this, new CommandBTP(this));
        getProxy().getPluginManager().registerCommand(this, new CommandKick(this));
        getProxy().getPluginManager().registerCommand(this, new CommandMod(this));
        getProxy().getPluginManager().registerCommand(this, new CommandMute(this));
        getProxy().getPluginManager().registerCommand(this, new CommandModpass());
        getProxy().getPluginManager().registerCommand(this, new CommandPardon(this));
        getProxy().getPluginManager().registerCommand(this, new CommandSTP(this));

        DatabaseConnector connector = instance.getConnector();
        connector.subscribe("moderationchan", new ModMessageHandler());
        connector.psubscribe("mute.*", chatListener);

        getProxy().getPluginManager().registerListener(this, chatListener);

        ServiceManager.registerService(IChatListener.class, chatListener);
    }

    public BungeeBridge getInstance() {
        return instance;
    }

    public ChatListener getChatListener() {
        return chatListener;
    }
}
