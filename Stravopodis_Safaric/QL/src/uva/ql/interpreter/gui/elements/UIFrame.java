package uva.ql.interpreter.gui.elements;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import uva.ql.interpreter.gui.supporting.Size;

public class UIFrame{
	
	public JFrame randerFrame(Size size){
		
		JFrame frame = new JFrame();
		
		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dimensions.width/2-size.getWidth()/2, dimensions.height/2-size.getHeight()/2);
		
		frame.setSize(size.getWidth(), size.getHeight());
		frame.setPreferredSize(new Dimension(size.getWidth(), size.getHeight()));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		
		return frame;
	}
}
