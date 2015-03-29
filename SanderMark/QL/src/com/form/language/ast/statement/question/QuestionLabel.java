package com.form.language.ast.statement.question;

import com.form.language.issue.QLToken;
import com.form.language.issue.Warning;
import com.form.language.memory.Context;

public class QuestionLabel {
	private String label;
	
	public QuestionLabel(String label)
	{
		this.label = label;
	}
	
	protected void checkExistingLabels(Context context,QLToken tokenInfo) {
		if (context.containsLabel(label)) {
			context.addWarning(new Warning(tokenInfo, "A question labeled \" + questionLabel + \" already exists"));
		}
	}

	public String getValue() 
	{
		return label;
	}
}
