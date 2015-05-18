package org.nlamah.QLS.Helper;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class QLSHelper 
{	
	static public List<StyledQuestion> getQuestionsWithIdentifier(List<StyledQuestion> questions, IdentifierValue identifier)
	{
		List<StyledQuestion> foundQuestions = new ArrayList<StyledQuestion>();

		for (StyledQuestion question : questions)
		{
			if (question.identifier().equals(identifier))
			{
				foundQuestions.add(question);
			}
		}

		return foundQuestions;
	}

	public static boolean questionIsStyled(FormQuestion formQuestion, List<StyledQuestion> styledQuestions) 
	{		
		for (StyledQuestion styledQuestion : styledQuestions)
		{
			if (questionsHaveTheSameIdentifier(formQuestion, styledQuestion))
			{
				return true;
			}
		}

		return false;
	}

	public static boolean doesStyledQuestionExistInForm(StyledQuestion styledQuestion, List<FormQuestion> formQuestions) 
	{
		for (FormQuestion formQuestion : formQuestions)
		{
			if (questionsHaveTheSameIdentifier(formQuestion, styledQuestion))
			{
				return true;
			}
		}

		return false;
	}

	private static boolean questionsHaveTheSameIdentifier(FormQuestion formQuestion, StyledQuestion styledQuestion) 
	{
		return formQuestion.identifier().toString().equals(styledQuestion.identifier().toString());
	}

	public static DefaultBlock findStyleDeclarationOfType(QBaseQuestionType type, List<DefaultBlock> defaultBlocks)
	{
		for (DefaultBlock defaultBlock : defaultBlocks)
		{
			if (defaultBlock.questionType() == type)
			{
				return defaultBlock;
			}
		}

		return null;
	}

	public static List<StyleDeclaration> findStyleDeclarationsOfTheSameClass(StyleDeclaration styleDeclaration, List<StyleDeclaration> styleDeclarations) 
	{		
		List<StyleDeclaration> foundDeclarations = new ArrayList<StyleDeclaration>();

		for (StyleDeclaration temporaryStyleDeclaration : styleDeclarations)
		{
			if(temporaryStyleDeclaration.getClass().equals(styleDeclaration.getClass()))
			{
				foundDeclarations.add(temporaryStyleDeclaration);
			}
		}

		return foundDeclarations;
	}

	public static QBaseQuestionType getTypeForStyledQuestion(StyledQuestion styledQuestion, List<FormQuestion> formQuestions)
	{		
		FormQuestion formQuestion = QLHelper.getQuestionWithIdentifier
				(
						formQuestions,
						new IdentifierLiteral(styledQuestion.identifier().toString())
						);

		return formQuestion.returnType();
	}

	public static String uniformHexNumberString(String hexNumberValueString) 
	{
		assert(hexNumberValueString.length() == 4 || hexNumberValueString.length() == 7);

		if (hexNumberValueString.length() == 4)
		{
			return "#" + 
					hexNumberValueString.charAt(1) + hexNumberValueString.charAt(1) + 
					hexNumberValueString.charAt(2) + hexNumberValueString.charAt(2) + 
					hexNumberValueString.charAt(3) + hexNumberValueString.charAt(3);
		}

		return hexNumberValueString;
	}

	public static int pageTitleBottomPadding() 
	{
		return 10;
	}
}