import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;


public class Serial implements SerialPortEventListener, Commons {
    private SerialPort serialPort;
    private Joystick joystick;
    private Board board;
    /**
     * The port we're normally going to use.
     */
    private static final String PORT_NAMES[] = {"/dev/tty.usbserial-A9007UX1", // Mac OS X
            "/dev/ttyUSB0", // Linux
            "COM5", // Windows
    };
    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;

    public Serial(Joystick joystick, Board board) {
        this.joystick = joystick;
        this.board = board;
        System.out.println("Serial Constructed...");
    }
    public void initialize() {
        System.out.println("Serial initializing...");
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = null;
                String[] pots;
                int pot1Val;
                int pot2Val;
                if (input.ready()) {
                    inputLine = input.readLine();
                    pots = inputLine.split(",");
                    pot1Val = Integer.parseInt(pots[0].split(" ")[1]);
                    pot2Val = Integer.parseInt(pots[1].split(" ")[1]);
                    System.out.println(pot1Val + "|" + pot2Val);
                    joystick.setJoyX(joystick.getBaseX() + (JOY_BASE_WIDTH / 2) + (int)(pot1Val * 0.5) - JOY_STICK_WIDTH / 2);
                    joystick.setJoyY(joystick.getBaseY() + (JOY_BASE_HEIGHT / 2) + (int)(pot2Val  * 0.5) - JOY_STICK_HEIGHT / 2);
                    board.repaint();
                }

            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }
}
