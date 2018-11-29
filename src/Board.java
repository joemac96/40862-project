import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements GLOBALS{
    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        //initRoad();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    // turn left
                    break;
                case KeyEvent.VK_RIGHT:
                    // turn right
                    break;
                case KeyEvent.VK_UP:
                    // forward
                    break;
                case KeyEvent.VK_DOWN:
                    // reverse
                    break;
                case KeyEvent.VK_1:
                    // honk
                    break;
                case KeyEvent.VK_2:
                    // signal left
                    break;
                case KeyEvent.VK_3:
                    // signal right
                    break;
                case KeyEvent.VK_4:
                    // cruise control on/off
                    break;
                case KeyEvent.VK_5:
                    // cruise control speed up
                    break;
                case KeyEvent.VK_6:
                    // cruise control speed down
                    break;
                default:
                    break;
            }
        }
    }
}
