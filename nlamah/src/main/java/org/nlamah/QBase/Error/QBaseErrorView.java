package org.nlamah.QBase.Error;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.nlamah.QBase.Constants.UIConstants;

@SuppressWarnings("serial")
public class QBaseErrorView extends JPanel
{
	private JLabel errorLabel;
	private JLabel warningLabel;

	public QBaseErrorView() 
	{
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.red);

		warningLabel = new JLabel();
		warningLabel.setForeground(Color.orange);

		add(errorLabel);
		add(warningLabel);

		layoutView();
	}

	public void fillInErrorString(String errorString)
	{
		errorLabel.setText(errorString);
	}

	public void fillInWarningString(String warningString)
	{
		warningLabel.setText(warningString);
	}

	private void layoutView()
	{
		setBackground(Color.white);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setMaximumSize(new Dimension(UIConstants.contentWidth(), 700));
		setMinimumSize(new Dimension(UIConstants.contentWidth(),700));
		setPreferredSize(new Dimension(UIConstants.contentWidth(),700));
	}
}