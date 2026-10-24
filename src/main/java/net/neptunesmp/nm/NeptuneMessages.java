package net.neptunesmp.nm;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class NeptuneMessages extends JavaPlugin {

    private final Map<UUID, Draft> drafts = new ConcurrentHashMap<>();
    private MessageFormatter formatter;
    private MessageSender sender;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.formatter = new MessageFormatter(this);
        this.sender = new MessageSender(this);

        PluginCommand command = getCommand("nm");
        if (command != null) {
            NMCommand handler = new NMCommand(this);
            command.setExecutor(handler);
        }
        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
        getLogger().info("Neptune Messages aktiv. Benutzung: /nm (nur Operatoren)");
    }

    public Draft draft(UUID player) {
        return drafts.computeIfAbsent(player, id -> new Draft());
    }

    public MessageFormatter formatter() {
        return formatter;
    }

    public MessageSender sender() {
        return sender;
    }
}
