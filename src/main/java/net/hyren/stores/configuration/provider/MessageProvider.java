package net.hyren.stores.configuration.provider;

import lombok.val;
import net.hyren.stores.StoresPlugin;
import net.hyren.stores.configuration.helper.ListHelper;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Map;

public class MessageProvider {
    private static final StoresPlugin PLUGIN = StoresPlugin.getInstance();

    public static void provide(CommandSender sender, String value) {
          String[] find = find(value);
        if(find == null) return;

        sender.sendMessage(find);
    }

    public static void provide(CommandSender sender, String value, Map<String, String> replace) {
          String[] find = find(value);
        if(find == null) return;

        ListHelper.replace(replace, Arrays.asList(find))
          .forEach(sender::sendMessage);
    }

    private static String[] find(String value) {
        val configuration = PLUGIN.getMessageConfiguration();
        final Map<String, String[]> cache = configuration.getCache();

        return cache.get(value);
    }
}
