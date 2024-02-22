import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;

    private Heart heart;

    private Timer timer;

    private final int TIMER_DELAY;

    private int ticksFromStart = 0;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(TIMER_DELAY, this);
        timer.start();

        this.heart = new Heart(PANEL_WIDTH / 2, PANEL_HEIGHT / 3, new Color(150, 0, 100), 50);
    }

    public void paint(final Graphics gr) {
        super.paint(gr);
        if (ticksFromStart % 5 == 0) {
            heart.setSizeCoeff(100);
        } else {
            heart.setSizeCoeff(50);
        }
        heart.draw(gr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}
