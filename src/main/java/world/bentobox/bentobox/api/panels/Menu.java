package world.bentobox.bentobox.api.panels;

import org.bukkit.inventory.meta.ItemMeta;
import world.bentobox.bentobox.BentoBox;

import java.util.Arrays;

public class Menu {

    private BentoBox plugin = BentoBox.getInstance();

    private final Panel panel;

    public Menu(String file) {
        this.panel = Panel.load(file);

        // Translate the Panel title if needed
        if (!panel.getTitle().isEmpty() && panel.getTitle().charAt(0) == '*') {
            panel.setTitle(plugin.getLocalesManager().get(panel.getUser(), panel.getTitle().substring(1)));
        }

        // Translate each item's name and lore if needed
        panel.getItems().forEach(item -> {
            if (item.getItem().hasItemMeta()) {
                ItemMeta itemMeta = item.getItem().getItemMeta();

                // Translate the display name
                if (!itemMeta.getDisplayName().isEmpty() && itemMeta.getDisplayName().charAt(0) == '*') {
                    itemMeta.setDisplayName(plugin.getLocalesManager().get(panel.getUser(), itemMeta.getDisplayName().substring(1)));
                }

                // Translate the lore - it needs a bit more special handling
                String topLore = itemMeta.getLore().get(0);
                if (!topLore.isEmpty() && topLore.charAt(0) == '*') {
                    String lore = plugin.getLocalesManager().get(panel.getUser(), topLore.substring(1));
                    itemMeta.setLore(Arrays.asList(lore.split("\n")));
                }
            }
        });
    }
}
