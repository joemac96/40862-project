import javax.swing.*;
import java.awt.*;

public class Game extends JFrame implements Commons {

    public Game() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setTitle("ButtonJoy");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Game ex = new Game();
            ex.setVisible(true);
        });
    }
}
