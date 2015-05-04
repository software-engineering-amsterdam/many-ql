package org.nlamah.QL.View.Form.Abstract;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class QuestionWidget extends JPanel
{
	public QuestionWidget()
	{
		super();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
}
