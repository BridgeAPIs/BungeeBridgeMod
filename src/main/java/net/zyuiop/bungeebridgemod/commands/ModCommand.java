package net.zyuiop.bungeebridgemod.commands;

import net.bridgesapis.bungeebridge.commands.DefaultExecutor;
import net.bridgesapis.bungeebridge.BungeeBridge;
import net.zyuiop.bungeebridgemod.BungeeBridgeMod;

public abstract class ModCommand extends DefaultExecutor {

	protected final BungeeBridge bridge;

	public ModCommand(String name, BungeeBridgeMod bridge) {
		super(name);
		this.bridge = bridge.getInstance();
	}

	public ModCommand(String name, String permission, BungeeBridgeMod bridge) {
		super(name, permission);
		this.bridge = bridge.getInstance();
	}

	public ModCommand(String name, String permission, BungeeBridgeMod bridge, String... aliases) {
		super(name, permission, aliases);
		this.bridge = bridge.getInstance();
	}
}
