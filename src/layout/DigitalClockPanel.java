package layout;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DigitalClockPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel hours;
	protected JLabel minutes;
	protected JLabel seconds;
	protected JLabel ampm;

	protected static final int CLOCK_WIDTH = 200;
	protected static final int CLOCK_HEIGHT = 30;


	public DigitalClockPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridLayout(1, 4, 8, 0));
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		
		hours = new JLabel("", SwingConstants.CENTER);
		minutes = new JLabel("", SwingConstants.CENTER);
		seconds = new JLabel("", SwingConstants.CENTER);
		ampm = new JLabel("", SwingConstants.CENTER);

		hours.setOpaque(true);
		hours.setBackground(Color.white);

		minutes.setOpaque(true);
		minutes.setBackground(Color.white);
		
		seconds.setOpaque(true);
		seconds.setBackground(Color.white);

		ampm.setOpaque(true);
		ampm.setBackground(Color.white);

		TimerTask task = new TimerTask() {
			public void run() {
				setTime();
			}
		};

		Timer timer = new Timer();
		timer.schedule(task,0, 1000);

		add(hours);
		add(minutes);
		add(seconds);
		add(ampm);
	}

	public String[] getTime() {

		LocalTime curernt_time = LocalTime.now();

		DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss:a");

		String reqTime = curernt_time.format(time_formatter);

		String[] time_array = reqTime.split(":");

		return time_array;

	}

	public void setTime() {

		hours.setText(getTime()[0]);
		minutes.setText(getTime()[1]);
		seconds.setText(getTime()[2]);
		ampm.setText(getTime()[3].toUpperCase());

	}

}

