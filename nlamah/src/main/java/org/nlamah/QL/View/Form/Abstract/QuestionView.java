package org.nlamah.QL.View.Form.Abstract;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.View;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QBase.Tools.StringTools;
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
		questionLabel.setText(StringTools.surroundStringWithHtmlTags(questionString));

		layoutView();
	}

	@Override
	public void layoutView() 
	{
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		View view = (View) javax.swing.plaf.basic.BasicHTML.createHTMLView(questionLabel, questionLabel.getText());
		view.setSize(viewWidth - UIConstants.widgetWidth() - UIConstants.widgetRightMargin() - UIConstants.labelLeftMargin() - UIConstants.labelRightMargin(), Integer.MAX_VALUE);

		int height = (int) view.getPreferredSpan(View.Y_AXIS);

		height +=  UIConstants.labelTopMargin() + UIConstants.labelBottomMargin();

		widgetView.layoutView();

		height = Math.max(height, widgetView.getPreferredSize().height);

		setPreferredSize(new Dimension(viewWidth, height));
		setMaximumSize(getPreferredSize()); 
		setMinimumSize(getPreferredSize());

		widgetView.setPreferredSize(new Dimension(UIConstants.widgetWidth(), height));
		widgetView.setMinimumSize(widgetView.getPreferredSize());
		widgetView.setMaximumSize(widgetView.getPreferredSize());

	}

	@Override
	public void initializeComponents() 
	{
		questionLabel = new JLabel();
		questionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		questionLabel.setFont(new Font("TimesRoman", Font.ITALIC, 15));

		viewWidth = UIConstants.contentWidth();
	}

	@Override
	public void addComponentsToView() 
	{
		add(Box.createRigidArea(new Dimension(UIConstants.labelLeftMargin(), 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(UIConstants.labelRightMargin(), 0)));
		add(widgetView);
		add(Box.createRigidArea(new Dimension(UIConstants.widgetRightMargin(), 0)));
	}
}