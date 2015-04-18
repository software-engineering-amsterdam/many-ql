package org.nlamah.QL.Error;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class QLErrorViewController 
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;
	
	private ArrayList<QLError> errors;
	
	private JFrame frame;
	private QLErrorView errorView;
	
	public QLErrorViewController(ArrayList<QLError> errors)
	{
		super();
		
		this.errors = errors;
		
		loadFrame();
	}
	
	public void showErrors()
	{
		errorView.fillInErrorString(produceErrorString());
		
		frame.setVisible(true);
	}
	
	private void loadFrame()
	{
		frame = new JFrame();
		
		frame.setTitle("Errors");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        errorView = new QLErrorView();
        
        frame.setContentPane(errorView);
	}
	
	private String produceErrorString()
	{
		String errorString = "";
		
		for (QLError error : errors)
		{
			errorString += "<p>" + error.description() + "</p>";
		}
		
		return "<html>" + errorString + "</html>";
		
	}
}
