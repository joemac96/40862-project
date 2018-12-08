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
        this.joyX = baseX;
        this.joyY = baseY;
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

    public void setJoyDX(int joyDX) {
        this.joyDX = joyDX;
    }

    public void setJoyDY(int joyDY) {
        this.joyDY = joyDY;
    }

}