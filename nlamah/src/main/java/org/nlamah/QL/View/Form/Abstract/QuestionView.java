package org.nlamah.QL.View.Form.Abstract;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.View;

import org.nlamah.QL.Helper.QLHelper;

@SuppressWarnings("serial")
public abstract class QuestionView extends FormElementView 
{
	protected JLabel questionLabel;
	protected JPanel answerWidget;

	public QuestionView(QuestionWidget answerWidget) 
	{
		super();	

		questionLabel = new JLabel();
		questionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		questionLabel.setFont(new Font("TimesRoman", Font.ITALIC, 15));
		

		this.answerWidget = answerWidget;

		answerWidget.setMinimumSize(new Dimension(QLHelper.widgetWidth(), 20));

		add(Box.createRigidArea(new Dimension(QLHelper.labelLeftMargin(), 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(QLHelper.labelRightMargin(), 0)));
		add(answerWidget);
		add(Box.createRigidArea(new Dimension(QLHelper.widgetRightMargin(), 0)));

		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	}

	public void fillInQuestionString(String questionString)
	{
		questionLabel.setText(QLHelper.surroundStringWithHtmlTags(questionString));

		View view = (View) javax.swing.plaf.basic.BasicHTML.createHTMLView(questionLabel, questionLabel.getText());
		view.setSize(QLHelper.contentWidth() - QLHelper.widgetWidth() - QLHelper.labelLeftMargin() - QLHelper.labelRightMargin(), Integer.MAX_VALUE);

		int height = (int) view.getPreferredSpan(View.Y_AXIS);

		height +=  QLHelper.labelTopMargin() + QLHelper.labelBottomMargin();

		setPreferredSize(new Dimension(QLHelper.contentWidth(), height));
		setMaximumSize(getPreferredSize()); 
		setMinimumSize(getPreferredSize());
		
		answerWidget.setPreferredSize(new Dimension(QLHelper.widgetWidth(), height));
		answerWidget.setMinimumSize(answerWidget.getPreferredSize());
		answerWidget.setMaximumSize(answerWidget.getPreferredSize());

	}
}
