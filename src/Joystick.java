public class Joystick implements Commons{
    private int baseX;
    private int baseY;
    private int joyDX;
    private int joyDY;
    private int joyX;
    private int joyY;

    public Joystick() {
        this.baseX = (BOARD_WIDTH / 2) + (BOARD_WIDTH / 4) - (JOY_BASE_WIDTH / 2);
        this.baseY = (BOARD_HEIGHT / 2) - (JOY_BASE_HEIGHT / 2);
        this.joyX = (BOARD_WIDTH / 2) + (BOARD_WIDTH / 4) - (JOY_STICK_WIDTH / 2);
        this.joyY = (BOARD_HEIGHT / 2) - (JOY_STICK_HEIGHT / 2);
        this.joyDX = 0;
        this.joyDY = 0;
    }

    public int getBaseX() {
        return baseX;
    }

    public int getBaseY() {
        return baseY;
    }

    public int getJoyDX() {
        return joyDX;
    }

    public int getJoyDY() {
        return joyDY;
    }

    public int getJoyX() {
        return joyX;
    }

    public int getJoyY() {
        return joyY;
    }

    public void setJoyDX(int joyDX) {
        this.joyDX = joyDX;
    }

    public void setJoyDY(int joyDY) {
        this.joyDY = joyDY;
    }

    public void move() {
        joyX += joyDX;
        joyY += joyDY;
        if (joyX + JOY_STICK_WIDTH >= (baseX + JOY_BASE_WIDTH)) {
            joyDX = 0;
            joyX = baseX + JOY_BASE_WIDTH - JOY_STICK_WIDTH;
        }
        if (joyX <= baseX) {
            joyDX = 0;
            joyX = baseX;
        }
        if (joyY + JOY_STICK_HEIGHT >= baseY + JOY_BASE_HEIGHT) {
            joyDY = 0;
            joyY = baseY + JOY_BASE_HEIGHT - JOY_STICK_HEIGHT;
        }
        if (joyY <= baseY) {
            joyDY = 0;
            joyY = baseY;
        }
    }

}