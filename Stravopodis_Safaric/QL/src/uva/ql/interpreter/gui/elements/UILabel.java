package uva.ql.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UILabel extends JLabel{
	
	static final long serialVersionUID = 42L; 
	private String text;
	
	public UILabel(String _text){
		this.text=_text;
		this.setLabel();
	}

	public String getText(){
		return this.text;
	}
	
	public void setLabel(){
		
		this.setMinimumSize(new Dimension(280,50));
		this.setPreferredSize(new Dimension(280,50));
		this.setPreferredSize(new Dimension(280,50));
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setSize(getTextHeight(this.getText()), 200);
		this.setText(getText());
	}

	public static int getTextHeight(String text){
		// Function used for resizing the label size, if the text is larger than 50 in height
		
		AffineTransform transform = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(transform,true,true);
		Font font = new Font ("Helvetica", Font.PLAIN,12);
		int textheight = (int)(font.getStringBounds(text, frc)).getHeight();
		
		if (textheight < 50) return 50; 
		return textheight;
	}	
}
	
	
	

