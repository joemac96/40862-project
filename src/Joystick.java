public class Joystick implements Commons{
    private int baseX;
    private int baseY;
    private int joyX;
    private int joyY;
    private Board board;

    public Joystick(Board board) {
        this.baseX = (BOARD_WIDTH / 2) + (BOARD_WIDTH / 4) - (JOY_BASE_WIDTH / 2);
        this.baseY = (BOARD_HEIGHT / 2) - (JOY_BASE_HEIGHT / 2);
        this.joyX = (BOARD_WIDTH / 2) + (BOARD_WIDTH / 4) - (JOY_STICK_WIDTH / 2);
        this.joyY = (BOARD_HEIGHT / 2) - (JOY_STICK_HEIGHT / 2);
        this.board = board;
        initSerial();
    }

    private void initSerial() {
        Serial serial = new Serial(this, board);
        serial.initialize();
    }

    public int getBaseX() {
        return baseX;
    }

    public int getBaseY() {
        return baseY;
    }

    public int getJoyX() {
        return joyX;
    }

    public int getJoyY() {
        return joyY;
    }

    public void setJoyX(int x) {
        joyX = x;
    }

    public void setJoyY(int y) {
        joyY = y;
    }

}