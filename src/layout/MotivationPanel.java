package layout;

import java.awt.Color;


import javax.swing.JLabel;
import javax.swing.JPanel;
import entity.Motivation;

@SuppressWarnings("serial")
public class MotivationPanel extends JPanel{

	private JLabel message,author;
	public MotivationPanel(Motivation m) {
		
		setBackground(Color.white);
		setLayout(null);
		
		message = new JLabel();
		message.setBounds(5,5,WidgetWindow.WINDOW_WIDTH - 30,60);
		
		author = new JLabel();
		author.setBounds(5,message.getHeight() + 5 + 5,WidgetWindow.WINDOW_WIDTH - 30,25);
		
		if(m != null) {
			message.setText("<html> <body> <p>" + m.getMotivation() + "</p></body></html>");
			author.setText("<html> <body> <p> - "+ m.getAuthor() + "</p></body></html>");
		}else {
			message.setText("<html> <body> <p>" + "No Connection, Please try again" + "</p></body></html>");
			author.setText("<html> <body> <p> - "+ "No Internet" + "</p></body></html>");
		}
		
		
		add(message);
		add(author);
		
	}

}
