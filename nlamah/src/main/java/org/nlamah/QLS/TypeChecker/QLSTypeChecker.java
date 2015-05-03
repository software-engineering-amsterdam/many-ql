package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.TypeChecker.DeclaredFormQuestionsCollector;
import org.nlamah.QLS.Error.QLSDoubleDeclarationError;
import org.nlamah.QLS.Error.UnStyledFormQuestionError;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
import org.nlamah.QLS.QLSHelper.QLSHelper;

public class QLSTypeChecker 
{	
	private List<QBaseError> errors;
	
	List<StyledQuestion> styledQuestions; 
	List<FormQuestion> formQuestions;
		
	public void check(Form form, QLStylesheet stylesheet) throws QBaseException
	{
		errors = new ArrayList<QBaseError>();
		
		styledQuestions = new StyledQuestionsCollector(stylesheet).questions();
		formQuestions = new DeclaredFormQuestionsCollector(form).questions();
		
		areAllFormQuestionsStyled();
		
		if (errors.size() > 0)
		{
			//throw new QBaseException(null, errors);
		}
		
		doAllStyledQuestionsExistInTheForm(form, stylesheet);
		
		if (errors.size() > 0)
		{
			//throw new QBaseException(null, errors);
		}
		
		areAlQuestionsStyledOnlyOnce(form, stylesheet);
		
		if (errors.size() > 0)
		{
			throw new QBaseException(null, errors);
		}
		
		areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(form, stylesheet);
		
		if (errors.size() > 0)
		{
			//throw new QBaseException(null, errors);
		}
	}
	
	public List<QBaseError> errors()
	{
		return errors;
	}
	
	private boolean areAllFormQuestionsStyled()
	{		
		for (FormQuestion formQuestion : formQuestions)
		{
			if (!QLSHelper.questionIsStyled(formQuestion, styledQuestions))
			{
				errors.add(new UnStyledFormQuestionError(formQuestion.identifier()));
				
				return false;
			}	
		}
		
		return true;
	}
	
	private boolean doAllStyledQuestionsExistInTheForm(Form form, QLStylesheet styelsheet)
	{
		for (StyledQuestion styledQuestion : styledQuestions)
		{
			if (!QLSHelper.doesStyledQuestionExistInForm(styledQuestion, formQuestions))
			{
				errors.add(new UndeclaredFormQuestionError(new IdentifierLiteral(styledQuestion.identifier().toString())));
				
				return false;
			}
		}
		
		return true;
	}
	
	private boolean areAlQuestionsStyledOnlyOnce(Form form, QLStylesheet stylesheet)
	{
		Set<StyledQuestion> set = QBaseHelper.getSetWithDuplicatedObjects(styledQuestions);
		
		if (set.size() > 0)
		{
			for (StyledQuestion styledQuestion : set)
			{
				errors.add(new QLSDoubleDeclarationError(styledQuestion.identifier(), QLSHelper.getQuestionsWithIdentifier(styledQuestions, styledQuestion.identifier())));
			}
			
			return false;
		}
		
		return true;
	}
	
	private boolean areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(Form form, QLStylesheet stylesheet)
	{
		return true;
	}	
}
