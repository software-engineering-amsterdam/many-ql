package org.nlamah.QLS.TypeChecker;

import java.util.List;
import java.util.Set;

import org.nlamah.QBase.QBaseAbstractTypeChecker;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.TypeChecker.FormQuestionsCollector;
import org.nlamah.QLS.Error.QLSDoubleDeclarationError;
import org.nlamah.QLS.Error.UnStyledFormQuestionError;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.QLSHelper.QLSHelper;

public class QLSTypeChecker extends QBaseAbstractTypeChecker
{		
	List<StyledQuestion> styledQuestions; 
	List<FormQuestion> formQuestions;
		
	public void check(Form form, Stylesheet stylesheet) throws QBaseException
	{		
		styledQuestions = new StyledQuestionsCollector(stylesheet).questions();
		formQuestions = new FormQuestionsCollector(form).questions();
		
		areAllFormQuestionsStyled();
		
		doAllStyledQuestionsExistInTheForm(form, stylesheet);
		
		areAlQuestionsStyledOnlyOnce(form, stylesheet);
		
		areDefaultDeclarationsDefiningTheSameTypeInTheSameScope(stylesheet);
		
		areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(form, stylesheet);
		
	}
	
	

	public List<QBaseError> errors()
	{
		return errors;
	}
	
	private void areAllFormQuestionsStyled() throws QBaseException
	{		
		for (FormQuestion formQuestion : formQuestions)
		{
			if (!QLSHelper.questionIsStyled(formQuestion, styledQuestions))
			{
				errors.add(new UnStyledFormQuestionError(formQuestion.identifier()));
			}	
		}
		
		checkForErrors();
	}
	
	private void doAllStyledQuestionsExistInTheForm(Form form, Stylesheet styelsheet) throws QBaseException
	{
		for (StyledQuestion styledQuestion : styledQuestions)
		{
			if (!QLSHelper.doesStyledQuestionExistInForm(styledQuestion, formQuestions))
			{
				errors.add(new UndeclaredFormQuestionError(new IdentifierLiteral(styledQuestion.identifier().toString())));
			}
		}
		
		checkForErrors();
	}
	
	private void areAlQuestionsStyledOnlyOnce(Form form, Stylesheet stylesheet) throws QBaseException
	{
		Set<StyledQuestion> set = QBaseHelper.getSetWithDuplicatedObjects(styledQuestions);
		
		if (set.size() > 0)
		{
			for (StyledQuestion styledQuestion : set)
			{
				errors.add(new QLSDoubleDeclarationError(styledQuestion.identifier(), QLSHelper.getQuestionsWithIdentifier(styledQuestions, styledQuestion.identifier())));
			}
		}
		
		checkForErrors();
	}
	
	private void areDefaultDeclarationsDefiningTheSameTypeInTheSameScope(Stylesheet stylesheet) throws QBaseException 
	{
		errors.addAll(new DoubleDefaultDeclarationChecker(stylesheet).errors());
		
		checkForErrors();
	}
	
	private void areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(Form form, Stylesheet stylesheet) throws QBaseException
	{
		WidgetTypeChecker widgetTypeChecker = new WidgetTypeChecker(form, stylesheet);
		widgetTypeChecker.check();
		
		errors.addAll(widgetTypeChecker.errors());
		
		checkForErrors();
	}
	
	private void checkForErrors() throws QBaseException
	{
		if (errors.size() > 0)
		{
			throw new QBaseException(null, errors);
		}
	}
}
