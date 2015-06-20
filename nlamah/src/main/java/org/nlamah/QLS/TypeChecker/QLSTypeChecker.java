package org.nlamah.QLS.TypeChecker;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Tools.QLSTools;
import org.nlamah.QBase.TypeChecker.QBaseAbstractTypeChecker;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QLS.Error.QLSDoubleDeclarationError;
import org.nlamah.QLS.Error.UnStyledFormQuestionError;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

public class QLSTypeChecker extends QBaseAbstractTypeChecker
{		
	public void check(Form form, Stylesheet stylesheet) throws QBaseException
	{		
		areAllFormQuestionsStyled(form, stylesheet);

		doAllStyledQuestionsExistInTheForm(form, stylesheet);

		areAlQuestionsStyledOnlyOnce(form, stylesheet);

		areDefaultBlocksDefiningTheSameTypeInTheSameScope(stylesheet);

		areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(form, stylesheet);
	}

	public List<QBaseError> errors()
	{
		return errors;
	}

	private void areAllFormQuestionsStyled(Form form, Stylesheet stylesheet) throws QBaseException
	{		
		for (FormQuestion formQuestion : form.questions())
		{
			if (!QLSTools.questionIsStyled(formQuestion, stylesheet.questions()))
			{
				errors.add(new UnStyledFormQuestionError(formQuestion.identifier()));
			}	
		}

		checkForErrors();
	}

	private void doAllStyledQuestionsExistInTheForm(Form form, Stylesheet stylesheet) throws QBaseException
	{
		for (StyledQuestion styledQuestion : stylesheet.questions())
		{
			if (!QLSTools.doesStyledQuestionExistInForm(styledQuestion, form.questions()))
			{
				errors.add(new UndeclaredFormQuestionError(new IdentifierLiteral(styledQuestion.identifier().toString())));
			}
		}

		checkForErrors();
	}

	private void areAlQuestionsStyledOnlyOnce(Form form, Stylesheet stylesheet) throws QBaseException
	{
		List<StyledQuestion> list = StyledQuestion.getListWithDuplicatedQuestionIdentifiers(stylesheet.questions());

		if (list.size() > 0)
		{
			for (StyledQuestion styledQuestion : list)
			{
				errors.add(new QLSDoubleDeclarationError(styledQuestion.identifier(), QLSTools.getQuestionsWithIdentifier(stylesheet.questions(), styledQuestion.identifier())));
			}
		}

		checkForErrors();
	}

	private void areDefaultBlocksDefiningTheSameTypeInTheSameScope(Stylesheet stylesheet) throws QBaseException 
	{
		errors.addAll(new DoubleDefaultBlockChecker(stylesheet).errors());

		checkForErrors();
	}

	private void areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(Form form, Stylesheet stylesheet) throws QBaseException
	{
		WidgetTypeChecker widgetTypeChecker = new WidgetTypeChecker(form, stylesheet);
		widgetTypeChecker.check();

		errors.addAll(widgetTypeChecker.errors());

		checkForErrors();
	}
}