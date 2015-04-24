package org.nlamah.QL.Views.Form;

import java.awt.Dimension;
import javax.swing.text.View;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.ViewControllers.Form.BooleanQuestionViewController;
import org.nlamah.QL.Views.Abstract.QuestionView;

@SuppressWarnings("serial")
public class BooleanQuestionView extends QuestionView 
{	
	//private JLabel typeLabel;
	//private JLabel questionLabel;
	//private JCheckBox checkBox;
	
	public BooleanQuestionView(BooleanQuestionViewController viewController) 
	{
		super(viewController);
	}
	
	public void fillInType(String type)
	{
		//typeLabel.setText(type);
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
	
	public void fillInCheckbox(boolean isChecked)
	{
		//checkBox.setSelected(isChecked);
	}

	@Override
	public void initializeComponents()
	{
		//typeLabel = new JLabel();
		//questionLabel = new JLabel();
		//checkBox = new JCheckBox("Yes");
	//	checkBox.addItemListener((BooleanQuestionViewController) viewController);
	}
	
	@Override
	public void addComponentsToView()
	{	
		//add(Box.createRigidArea(new Dimension(10, 0)));
		//add(typeLabel);
	//	add(Box.createRigidArea(new Dimension(10, 0)));
		//add(questionLabel);
		//add(Box.createRigidArea(new Dimension(10, 0)));
		//add(checkBox);
		//add(Box.createRigidArea(new Dimension(10, 0)));
	}

	@Override
	public void layoutView() 
	{	
		//setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	//	setBackground(Color.white);
		
//		setPreferredSize(new Dimension(QLHelper.contentWidth(), 100));
//        setMaximumSize(getPreferredSize()); 
//        setMinimumSize(getPreferredSize());
	}
}
