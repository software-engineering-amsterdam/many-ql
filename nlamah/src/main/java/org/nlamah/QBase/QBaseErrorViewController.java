package org.nlamah.QBase;

import java.util.List;

import javax.swing.JFrame;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Helper.QLHelper;

public class QBaseErrorViewController implements Runnable
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;

	private List<QBaseWarning> warnings;
	private List<? extends QBaseError> errors;

	private JFrame frame;
	private QBaseErrorView errorView;

	public QBaseErrorViewController( List<QBaseWarning> warnings, List<QBaseError> errors)
	{
		super();
		
		this.warnings = warnings;
		this.errors = errors;
	
		loadFrame();
	}

	@Override
	public void run() 
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

		errorView = new QBaseErrorView();

		frame.setContentPane(errorView);
	}

	private String produceErrorString()
	{
		String errorString = "";
		if (QBaseHelper.arrayExistsAndHasElements(errors))
		{
			for (QBaseError error : errors)
			{
				errorString += "<p>" + error.description() + "</p>";
			}
		}

		return QLHelper.surroundStringWithHtmlTags(errorString);

	}

	private String produceWarningString()
	{	
		String warningString = "";

		if (QBaseHelper.arrayExistsAndHasElements(warnings))
		{
			for (QBaseWarning warning : warnings)
			{
				warningString += "<p>" + warning.description() + "</p>";
			}
		}

		return QLHelper.surroundStringWithHtmlTags(warningString);
	}
}
