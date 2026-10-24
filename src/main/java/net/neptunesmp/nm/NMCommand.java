package net.neptunesmp.nm;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class NMCommand implements CommandExecutor {

    private final NeptuneMessages plugin;

    public NMCommand(NeptuneMessages plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        // Nur Operatoren (Konsole zaehlt als Op).
        if (!sender.isOp()) {
            sender.sendMessage(Component.text("Dafür brauchst du Op-Rechte.", NamedTextColor.RED));
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            sender.sendMessage(Component.text("Neptune Messages: Config neu geladen.", NamedTextColor.GREEN));
            return true;
        }

        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Das Menü gibt es nur im Spiel.", NamedTextColor.RED));
            return true;
        }

        Draft draft = plugin.draft(player.getUniqueId());
        if (args.length > 0) {
            // /nm <text> setzt direkt den Text und oeffnet das Menue
            draft.text = String.join(" ", args);
        }
        new NMMenu(plugin, draft).open(player);
        return true;
    }
}
