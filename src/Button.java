import java.awt.*;

public class Button {
    private int x;
    private int y;
    private String name;
    private Color color;

    public Button(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = Color.white;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
