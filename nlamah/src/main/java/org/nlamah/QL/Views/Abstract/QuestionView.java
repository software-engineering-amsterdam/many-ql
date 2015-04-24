package org.nlamah.QL.Views.Abstract;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.View;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;

@SuppressWarnings("serial")
public abstract class QuestionView extends FormElementView 
{
	protected JLabel questionLabel;
	protected JPanel answerWidget;
	
	public QuestionView(FormElementViewController viewController) 
	{
		super(viewController);	
		
		questionLabel = new JLabel();
		questionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		answerWidget = new JPanel();
		
		answerWidget.setPreferredSize(new Dimension(QLHelper.widgetWidth(), QLHelper.defaultQuestionHeight()));
		answerWidget.setMinimumSize(answerWidget.getPreferredSize());
		answerWidget.setMaximumSize(answerWidget.getPreferredSize());

		answerWidget.setBackground(Color.blue);
		
		add(Box.createRigidArea(new Dimension(QLHelper.labelLeftMargin(), 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(QLHelper.labelRightMargin(), 0)));
		add(answerWidget);
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		setPreferredSize(new Dimension(QLHelper.contentWidth(), QLHelper.defaultQuestionHeight()));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize());
	}
	
	public void fillInQuestionString(String questionString)
	{
		questionLabel.setText(QLHelper.surroundStringWithHtmlTags(questionString));
		
		 View view = (View) javax.swing.plaf.basic.BasicHTML.createHTMLView(questionLabel, questionLabel.getText());
		 view.setSize(QLHelper.contentWidth() - QLHelper.widgetWidth() - QLHelper.labelLeftMargin() - QLHelper.labelRightMargin(), Integer.MAX_VALUE);
		   int width = (int) view.getPreferredSpan(View.X_AXIS);
		   int height = (int) view.getPreferredSpan(View.Y_AXIS);
		
		
		
		System.out.println("preferredHeight: " + questionLabel.getPreferredSize().height + "," + width + "," + height);
		
		if (height > QLHelper.defaultQuestionHeight())
		{
			setPreferredSize(new Dimension(QLHelper.contentWidth(), height + 30));
			setMaximumSize(getPreferredSize()); 
	        setMinimumSize(getPreferredSize());
		}
	}
}
