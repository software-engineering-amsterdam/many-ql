package org.nlamah.QBase;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.nlamah.QL.Helper.QLHelper;

@SuppressWarnings("serial")
public class QBaseErrorView extends JPanel
{
	private JLabel errorLabel;
	private JLabel warningLabel;

	public QBaseErrorView() 
	{
		super();

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

		setMaximumSize(new Dimension(QLHelper.contentWidth(), 700));
		setMinimumSize(new Dimension(QLHelper.contentWidth(),700));
		setPreferredSize(new Dimension(QLHelper.contentWidth(),700));
	}
}
