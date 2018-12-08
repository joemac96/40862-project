import java.util.logging.ConsoleHandler;

public class Switch {
    private Button up;
    private Button down;
    private String name;

    public Switch(int x, int y, String name) {
        up = new Button(x, y, name + "U");
        down = new Button(x, y + 30,  name + "D");
        this.name = name;
    }

    public Button getUp() {
        return up;
    }

    public Button getDown() {
        return down;
    }
    public String getName() {
        return name;
    }
}
