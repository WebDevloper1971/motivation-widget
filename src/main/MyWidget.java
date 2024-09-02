package main;

import java.awt.Color;


import api.ApiCall;
import entity.Motivation;
import layout.MotivationPanel;
import layout.WidgetWindow;



public class MyWidget {


	protected WidgetWindow window;
	protected MotivationPanel mpanel;
	private Motivation m;
	
	protected ApiCall api;
   
	public MyWidget() {
		
		api = new ApiCall();
		
		m = api.getData();
		
		mpanel = new MotivationPanel(m);
		
		window = new WidgetWindow(mpanel);
		
		if(m != null) {
			window.getContentPane().setBackground(Color.decode(m.getColor()));
		}
		
	}


	
}
