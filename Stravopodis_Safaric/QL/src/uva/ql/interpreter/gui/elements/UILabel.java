package uva.ql.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import uva.ql.interpreter.gui.supporting.Size;

public class UILabel {
	
	public JLabel randerUILabel(Size size, String text){
		JLabel label = new JLabel(text);
		
		label.setMinimumSize(new Dimension(size.getWidth(),size.getHeight()));
		label.setPreferredSize(new Dimension(size.getWidth(),size.getHeight()));
		label.setPreferredSize(new Dimension(size.getWidth(),size.getHeight()));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setSize(getTextHeight(text), 200);
		
		return label;
	}

	private int getTextHeight(String text){
		
		AffineTransform transform = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(transform,true,true);
		Font font = new Font ("Helvetica", Font.PLAIN,12);
		
		int textheight = (int)(font.getStringBounds(text, frc)).getHeight();
		
		if (textheight < 50){
			return 50;
		}
		
		return textheight;
	}	
}