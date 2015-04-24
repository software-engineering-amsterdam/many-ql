package org.nlamah.QL.Views.Error;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Error.Abstract.QLError;
import org.nlamah.QL.Model.Error.Abstract.QLWarning;

public class QLErrorViewController implements Runnable
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;

	private ArrayList<QLWarning> warnings;
	private ArrayList<QLError> errors;

	private JFrame frame;
	private QLErrorView errorView;

	public QLErrorViewController(ArrayList<QLError> errors, ArrayList<QLWarning> warnings)
	{
		super();

		this.errors = errors;
		this.warnings = warnings;

		loadFrame();
	}

	@Override
	public void run() 
	{
		showErrors();
	}
	
	private void showErrors()
	{
		errorView.fillInErrorString(produceErrorString());
		errorView.fillInWarningString(produceWarningString());

		frame.setVisible(true);
	}

	private void loadFrame()
	{
		frame = new JFrame();

		frame.setTitle("Errors");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		errorView = new QLErrorView();

		frame.setContentPane(errorView);
	}

	private String produceErrorString()
	{
		String errorString = "";
		if (QLHelper.arrayExistsAndHasElements(errors))
		{
			for (QLError error : errors)
			{
				errorString += "<p>" + error.description() + "</p>";
			}
		}

		return "<html>" + errorString + "</html>";

	}

	private String produceWarningString()
	{	
		String warningString = "";

		if (QLHelper.arrayExistsAndHasElements(warnings))
		{
			for (QLWarning warning : warnings)
			{
				warningString += "<p>" + warning.description() + "</p>";
			}
		}

		return "<html>" + warningString + "</html>";
	}

	
}
