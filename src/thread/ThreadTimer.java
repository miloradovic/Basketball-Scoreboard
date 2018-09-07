package thread;

import java.text.SimpleDateFormat;
import javax.swing.JLabel;

/**
 *
 * @author Darko
 */
public class ThreadTimer extends Thread {

    boolean run;
    JLabel lblTimer;
    long milliseconds;
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

    public ThreadTimer(JLabel lblTimer, boolean run) {
        this.lblTimer = lblTimer;
        this.run = run;
        milliseconds  = 600000;
    }

    @Override
    public void run() {
        while (run) {
            if (milliseconds == 0) {
                return;
            }
            milliseconds -= 1000;
            lblTimer.setText(sdf.format(milliseconds));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Not working: " + ex);
            }
        }
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

}
