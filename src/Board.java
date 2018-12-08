import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel implements Commons, Runnable {

    private ArrayList<Button> buttons;
    private ArrayList<Switch> switches;
    private Joystick joystick;
    private boolean buttonPressed = false;
    private Dimension d;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
        initButtons();
        initSwitches();
    }

    private void initButtons() {
        int spacing = BOARD_WIDTH / 10;
        buttons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            buttons.add(new Button((spacing - 25) + (i * spacing), (BOARD_HEIGHT / 3) - 50, Integer.toString(i)));
        }
    }

    private void initSwitches() {
        int spacing = BOARD_WIDTH / 10;
        switches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            switches.add(new Switch((spacing - 25) + (i * spacing), 2 * (BOARD_HEIGHT / 3) - 50, Integer.toString(i)));
        }
    }

    private void drawObjects(Graphics g) {
        drawButtons(g);
        drawSwitches(g);
    }
    private void drawButtons(Graphics g) {
        for (Button button : buttons) {
            g.setColor(button.getColor());
            g.fillOval(button.getX(), button.getY(), BUTTON_WIDTH,BUTTON_HEIGHT);
        }
    }

    private void drawSwitches(Graphics g) {
        for (Switch sw : switches) {
            Button up = sw.getUp();
            Button down = sw.getDown();
            g.setColor(up.getColor());
            g.fillRect(up.getX(), up.getY(), SWITCH_WIDTH, SWITCH_HEIGHT);
            g.setColor(down.getColor());
            g.fillRect(down.getX(), down.getY(), SWITCH_WIDTH, SWITCH_HEIGHT);
        }
    }

    private void updateButton(int id, boolean io) {
        Button button = buttons.get(id);
        if (io) {
            button.setColor(Color.red);
        }
        else {
            button.setColor(Color.white);
        }
        repaint();
    }

    private void updateSwitch(int id, char button, boolean io) {
        Button btn;
        if (button == 'U') {
            btn = switches.get(id).getUp();
            if (io) {
                btn.setColor(Color.red);
            }
            else {
                btn.setColor(Color.white);
            }
        }
        else if (button == 'D') {
            btn = switches.get(id).getDown();
            if (io) {
                btn.setColor(Color.red);
            }
            else {
                btn.setColor(Color.white);
            }
        }
        repaint();
    }

    @Override
    public void run() {

        while(true) {
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);

        drawObjects(g);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_9:
                    updateButton(0, true);
                    break;
                case KeyEvent.VK_A:
                    updateButton(1, true);
                    break;
                case KeyEvent.VK_B:
                    updateButton(2, true);
                    break;
                case KeyEvent.VK_C:
                    updateButton(3, true);
                    break;
                case KeyEvent.VK_1:
                    updateSwitch(0, 'U', true);
                    break;
                case KeyEvent.VK_2:
                    updateSwitch(0, 'D', true);
                    break;
                case KeyEvent.VK_3:
                    updateSwitch(1, 'U', true);
                    break;
                case KeyEvent.VK_4:
                    updateSwitch(1, 'D', true);
                    break;
                case KeyEvent.VK_5:
                    updateSwitch(2, 'U', true);
                    break;
                case KeyEvent.VK_6:
                    updateSwitch(2, 'D', true);
                    break;
                case KeyEvent.VK_7:
                    updateSwitch(3, 'U', true);
                    break;
                case KeyEvent.VK_8:
                    updateSwitch(3, 'D', true);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_9:
                    updateButton(0, false);
                    break;
                case KeyEvent.VK_A:
                    updateButton(1, false);
                    break;
                case KeyEvent.VK_B:
                    updateButton(2, false);
                    break;
                case KeyEvent.VK_C:
                    updateButton(3, false);
                    break;
                case KeyEvent.VK_1:
                    updateSwitch(0, 'U', false);
                    break;
                case KeyEvent.VK_2:
                    updateSwitch(0, 'D', false);
                    break;
                case KeyEvent.VK_3:
                    updateSwitch(1, 'U', false);
                    break;
                case KeyEvent.VK_4:
                    updateSwitch(1, 'D', false);
                    break;
                case KeyEvent.VK_5:
                    updateSwitch(2, 'U', false);
                    break;
                case KeyEvent.VK_6:
                    updateSwitch(2, 'D', false);
                    break;
                case KeyEvent.VK_7:
                    updateSwitch(3, 'U', false);
                    break;
                case KeyEvent.VK_8:
                    updateSwitch(3, 'D', false);
                    break;
            }
        }
    }
}
