package world.bentobox.bentobox.api.panels;

import com.github.stefvanschie.inventoryframework.Gui;

import world.bentobox.bentobox.BentoBox;
import world.bentobox.bentobox.api.user.User;

public class Panel extends Gui {

    private User user = null;

    public Panel(String title, int rows) {
        super(BentoBox.getInstance(), rows, title);
    }

    public Panel(String title, int rows, User user) {
        this(title, rows);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public static Panel load(String file) {
        return new Panel("title", 1);
    }
}
