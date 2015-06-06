package org.nlamah.QBase;

import java.util.List;

import javax.swing.JFrame;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseErrorView;
import org.nlamah.QBase.Error.QBaseWarning;
import org.nlamah.QBase.Tools.ArrayTools;
import org.nlamah.QBase.Tools.StringTools;

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
		if (ArrayTools.arrayExistsAndHasElements(errors))
		{
			for (QBaseError error : errors)
			{
				errorString += "<p>" + error.description() + "</p>";
			}
		}

		return StringTools.surroundStringWithHtmlTags(errorString);

	}

	private String produceWarningString()
	{	
		String warningString = "";

		if (ArrayTools.arrayExistsAndHasElements(warnings))
		{
			for (QBaseWarning warning : warnings)
			{
				warningString += "<p>" + warning.description() + "</p>";
			}
		}

		return StringTools.surroundStringWithHtmlTags(warningString);
	}
}