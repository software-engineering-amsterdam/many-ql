package org.nlamah.QLS;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.QBaseTestCase;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QLS.Error.DoubleDefaultBlockError;
import org.nlamah.QLS.Error.DoublePropertyDeclarationError;
import org.nlamah.QLS.Error.FontRecognitionError;
import org.nlamah.QLS.Error.QLSDoubleDeclarationError;
import org.nlamah.QLS.Error.UnStyledFormQuestionError;
import org.nlamah.QLS.Error.WidgetTypeMismatchError;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.WidgetTypeEnum;

public class QLStylesheetErrorTest extends QBaseTestCase
{
	public void testIllegalFontName() 
	{
		try 
		{
			parsedForm = null;
			
			produceStylesheetFromSourceFileWithForm("error", "illegalfontname", parsedForm);

			assertTrue(false);			
		} 
		catch (QBaseException exception) 
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();
			QBaseError error = new FontRecognitionError("", 0, 0);
			referenceErrors.add(error);

			assertEquals(exception.errors(), referenceErrors);
		}
	}

	public void testWidgetTypeMismatch()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/error", "widgettypemismatcherror", true);
			
			produceStylesheetFromSourceFileWithForm("error", "widgettypemismatcherror", parsedForm);

			assertTrue(false);
		} 
		catch (QBaseException exception) 
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error1 = new WidgetTypeMismatchError(new WidgetDeclaration(WidgetTypeEnum.CHECKBOX, QBaseQuestionType.BOOLEAN, null), QBaseQuestionType.NUMBER);
			referenceErrors.add(error1);

			QBaseError error2 = new WidgetTypeMismatchError(new WidgetDeclaration(WidgetTypeEnum.SPINBOX, QBaseQuestionType.NUMBER, null), QBaseQuestionType.TEXT);
			referenceErrors.add(error2);

			Map<TextLiteral, TextLiteral> answers = new LinkedHashMap<TextLiteral, TextLiteral>();

			TextLiteral yesAnswer = new TextLiteral("yes");
			answers.put(yesAnswer, yesAnswer);
			TextLiteral noAnswer = new TextLiteral("no");
			answers.put(noAnswer, noAnswer);

			QBaseError error3 = new WidgetTypeMismatchError(new WidgetDeclaration(WidgetTypeEnum.RADIOBUTTON, QBaseQuestionType.TEXT, answers), QBaseQuestionType.BOOLEAN);
			referenceErrors.add(error3);

			assertEquals(exception.errors(), referenceErrors);
		}
	}

	public void testUnStyledQuestion()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/error", "unstyledquestionerror", true);
			
			produceStylesheetFromSourceFileWithForm("error", "unstyledquestionerror", parsedForm);

			assertTrue(false);
		} 
		catch (QBaseException exception) 
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error = new UnStyledFormQuestionError(new IdentifierLiteral("question2"));
			referenceErrors.add(error);

			assertEquals(exception.errors(), referenceErrors);
		}
	}

	public void testDoubleDeclaration()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/error", "doubledeclarationerror", true);
			
			produceStylesheetFromSourceFileWithForm("error", "doubledeclarationerror", parsedForm);

			assertTrue(false);
		} 
		catch (QBaseException exception) 
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<StyledQuestion> styledQuestions = new ArrayList<StyledQuestion>();
			styledQuestions.add(new StyledQuestion(new IdentifierValue("question1"), new StyleBlock(new ArrayList<StyleDeclaration>())));
			styledQuestions.add(new StyledQuestion(new IdentifierValue("question1"), new StyleBlock(new ArrayList<StyleDeclaration>())));

			QBaseError error = new QLSDoubleDeclarationError(new IdentifierValue("question1"), styledQuestions);
			referenceErrors.add(error);

			assertEquals(exception.errors(), referenceErrors);
		}
	}

	public void testDoubledefaultBlock()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/error", "doubledefaultblockerror", true);
			
			produceStylesheetFromSourceFileWithForm("error", "doubledefaultblockerror", parsedForm);

			assertTrue(false);
		} 
		catch (QBaseException exception) 
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();

			List<StyleDeclaration> styleDeclarations1 = new ArrayList<StyleDeclaration>();
			styleDeclarations1.add(new WidgetDeclaration(WidgetTypeEnum.SPINBOX, QBaseQuestionType.NUMBER, null));
			defaultBlocks.add(new DefaultBlock(QBaseQuestionType.NUMBER, styleDeclarations1));

			List<StyleDeclaration> styleDeclarations2 = new ArrayList<StyleDeclaration>();
			styleDeclarations2.add(new WidthDeclaration(200));
			defaultBlocks.add(new DefaultBlock(QBaseQuestionType.NUMBER, styleDeclarations2));

			QBaseError error = new DoubleDefaultBlockError(defaultBlocks);
			referenceErrors.add(error);

			assertEquals(exception.errors(), referenceErrors);
		}
	}


	public void testDoublePropertyDeclaration()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/error", "doublepropertydeclarationerror", true);
			
			produceStylesheetFromSourceFileWithForm("error", "doublepropertydeclarationerror", parsedForm);

			assertTrue(false);			
		} 
		catch (QBaseException exception) 
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<StyleDeclaration> styleDeclarations1 = new ArrayList<StyleDeclaration>();
			styleDeclarations1.add(new FontSizeDeclaration(12));
			styleDeclarations1.add(new FontSizeDeclaration(13));

			QBaseError error1 = new DoublePropertyDeclarationError(styleDeclarations1);
			referenceErrors.add(error1);

			List<StyleDeclaration> styleDeclarations2 = new ArrayList<StyleDeclaration>();
			styleDeclarations2.add(new WidthDeclaration(1));
			styleDeclarations2.add(new WidthDeclaration(2));

			QBaseError error2 = new DoublePropertyDeclarationError(styleDeclarations2);
			referenceErrors.add(error2);

			assertEquals(exception.errors(), referenceErrors);
		}
	}
}