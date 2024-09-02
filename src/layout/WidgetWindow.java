package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;

import main.MyWidget;

public class WidgetWindow extends JWindow {
	
	private static final long serialVersionUID = 1L;

	JButton close,refresh;
	int btnwidth = 30;
	int btnheight = 30;
	private JLabel title;
	String MAIN_TITLE = "Daily Motivation";
	
	protected static final int WINDOW_WIDTH = 300;
	protected static final int WINDOW_HEIGHT = 200;
	protected final Dimension size = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

	protected static String BG_COLOR = "#BBE456";
	private DigitalClockPanel clock;

	protected final Rectangle SCREENSIZE = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getMaximumWindowBounds();
	
	public WidgetWindow(MotivationPanel mpanel) {
		
		getContentPane().setBackground(Color.decode(BG_COLOR));
		
		title = new JLabel();
		title.setText(MAIN_TITLE);
		title.setFont(new Font("Verdana", Font.BOLD, 16));
		title.setBounds(10, 10, 200, 30);
		
		
		clock = new DigitalClockPanel();
		clock.setBounds(10, title.getHeight() + 20, DigitalClockPanel.CLOCK_WIDTH,
				DigitalClockPanel.CLOCK_HEIGHT);

		mpanel.setBounds(10, clock.getHeight() + 30 + 30, WINDOW_WIDTH - 20, WINDOW_HEIGHT - 20 - 30 - 30 - 20);

		
		
		
		
		
		addMouseMotionListener(new MouseMotionListener() {
            private int mx, my;

            @Override
            public void mouseMoved(MouseEvent e) {
                mx = e.getXOnScreen();
                my = e.getYOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                p.x += e.getXOnScreen() - mx;
                p.y += e.getYOnScreen() - my;
                mx = e.getXOnScreen();
                my = e.getYOnScreen();
                if (p.y <= 0) {
                    p.y = 0;
                }

                if (p.x <= 0) {
                    p.x = 0;
                }

                if (p.y >= SCREENSIZE.height - WINDOW_HEIGHT) {
                    p.y = SCREENSIZE.height - WINDOW_HEIGHT;
                }

                if (p.x >= SCREENSIZE.width - WINDOW_WIDTH) {
                    p.x = SCREENSIZE.width - WINDOW_WIDTH;
                }

                setLocation(p);
            }
        });
		
		close = new CustomButton("/Vector.png");
		close.addActionListener(e -> {
			setVisible(false);
			dispose();
			System.exit(0);
		});
		close.setBounds(WINDOW_WIDTH - btnwidth - 10, 10, btnwidth, btnheight);

		refresh = new CustomButton("/Group.png");
		refresh.addActionListener(e -> {
			dispose();
			new MyWidget();
		});
			
		refresh.setBounds(close.getBounds().x - btnwidth - 10, 10, btnwidth, btnheight);
        
		
		
		
		
		
		
		
		add(close);
		add(refresh);
		add(title);
		add(clock);
		add(mpanel);
		
		setLayout(null);
		setSize(size);
		setAlwaysOnTop(true);
		setLocation(SCREENSIZE.width - WINDOW_WIDTH, 0);
		setVisible(true);
	}


}
