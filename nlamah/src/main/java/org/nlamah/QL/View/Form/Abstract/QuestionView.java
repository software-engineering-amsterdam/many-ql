package org.nlamah.QL.View.Form.Abstract;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.View;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

@SuppressWarnings("serial")
public class QuestionView extends FormElementView 
{
	protected JLabel questionLabel;
	protected WidgetView widgetView;

	public QuestionView(FormQuestion question, WidgetView answerWidget) 
	{
		super();	

		questionLabel = new JLabel();
		questionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		questionLabel.setFont(new Font("TimesRoman", Font.ITALIC, 15));
		
		this.widgetView = answerWidget;

		answerWidget.setMinimumSize(new Dimension(QLHelper.widgetWidth(), 20));

		add(Box.createRigidArea(new Dimension(QLHelper.labelLeftMargin(), 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(QLHelper.labelRightMargin(), 0)));
		add(answerWidget);
		add(Box.createRigidArea(new Dimension(QLHelper.widgetRightMargin(), 0)));

		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		fillInQuestionString(question.questionText().toString());
	}

	private void fillInQuestionString(String questionString)
	{
		questionLabel.setText(QLHelper.surroundStringWithHtmlTags(questionString));

		View view = (View) javax.swing.plaf.basic.BasicHTML.createHTMLView(questionLabel, questionLabel.getText());
		view.setSize(QLHelper.contentWidth() - QLHelper.widgetWidth() - QLHelper.labelLeftMargin() - QLHelper.labelRightMargin(), Integer.MAX_VALUE);

		int height = (int) view.getPreferredSpan(View.Y_AXIS);

		height +=  QLHelper.labelTopMargin() + QLHelper.labelBottomMargin();

		setPreferredSize(new Dimension(QLHelper.contentWidth(), height));
		setMaximumSize(getPreferredSize()); 
		setMinimumSize(getPreferredSize());
		
		widgetView.setPreferredSize(new Dimension(QLHelper.widgetWidth(), height));
		widgetView.setMinimumSize(widgetView.getPreferredSize());
		widgetView.setMaximumSize(widgetView.getPreferredSize());
	}
	
	public void setValue(ValueExpression value)
	{
		widgetView.setValue(value);
	}

	@Override
	public void layoutView() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeComponents() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComponentsToView() 
	{
		// TODO Auto-generated method stub
		
	}
}
