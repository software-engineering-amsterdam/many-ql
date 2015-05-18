package org.nlamah.QL.View.Form.Abstract;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.View;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

@SuppressWarnings("serial")
public class QuestionView extends FormElementView 
{
	protected JLabel questionLabel;
	protected WidgetView widgetView;
	protected int viewWidth;

	public QuestionView(FormQuestion question, WidgetView widgetView) 
	{
		super(question);	

		this.widgetView = widgetView;

		initializeComponents();
		addComponentsToView();
		layoutView();

		fillInQuestionString(question.questionText().toString());
	}

	public FormQuestion question()
	{
		return (FormQuestion) modelElement;
	}

	public WidgetView widgetView()
	{
		return widgetView;
	}

	private void fillInQuestionString(String questionString)
	{
		questionLabel.setText(QLHelper.surroundStringWithHtmlTags(questionString));

		layoutView();
	}

	@Override
	public void layoutView() 
	{
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		View view = (View) javax.swing.plaf.basic.BasicHTML.createHTMLView(questionLabel, questionLabel.getText());
		view.setSize(viewWidth - QLHelper.widgetWidth() - QLHelper.widgetRightMargin() - QLHelper.labelLeftMargin() - QLHelper.labelRightMargin(), Integer.MAX_VALUE);

		int height = (int) view.getPreferredSpan(View.Y_AXIS);

		height +=  QLHelper.labelTopMargin() + QLHelper.labelBottomMargin();

		widgetView.layoutView();

		height = Math.max(height, widgetView.getPreferredSize().height);

		setPreferredSize(new Dimension(viewWidth, height));
		setMaximumSize(getPreferredSize()); 
		setMinimumSize(getPreferredSize());

		widgetView.setPreferredSize(new Dimension(QLHelper.widgetWidth(), height));
		widgetView.setMinimumSize(widgetView.getPreferredSize());
		widgetView.setMaximumSize(widgetView.getPreferredSize());

	}

	@Override
	public void initializeComponents() 
	{
		questionLabel = new JLabel();
		questionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		questionLabel.setFont(new Font("TimesRoman", Font.ITALIC, 15));

		viewWidth = QLHelper.contentWidth();
	}

	@Override
	public void addComponentsToView() 
	{
		add(Box.createRigidArea(new Dimension(QLHelper.labelLeftMargin(), 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(QLHelper.labelRightMargin(), 0)));
		add(widgetView);
		add(Box.createRigidArea(new Dimension(QLHelper.widgetRightMargin(), 0)));
	}
}