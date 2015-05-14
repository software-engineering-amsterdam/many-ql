package org.nlamah.QLS;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QL.QLTest;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.TypeChecker.QLTypeChecker;
import org.nlamah.QLS.Builders.RawStylesheetBuilder;
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
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidget;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidget;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidget;
import org.nlamah.QLS.TypeChecker.QLSTypeChecker;

import junit.framework.TestCase;

public class QLStylesheetErrorTest extends TestCase
{
	public void testIllegalFontName() 
	{
		ParseTree tree = QLSTest.produceParseTreeFromSourceFile("error", "illegalfontname");

		RawStylesheetBuilder stylesheetBuilder = new RawStylesheetBuilder();

		stylesheetBuilder.build(tree);

		List<QBaseError> referenceErrors = new ArrayList<QBaseError>();
		QBaseError error = new FontRecognitionError("", 0, 0);
		referenceErrors.add(error);

		assertEquals(stylesheetBuilder.errors(), referenceErrors);
	}

	public void testWidgetTypeMismatch()
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("qls/error", "widgettypemismatcherror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}

		Stylesheet parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("error", "widgettypemismatcherror");

		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();

		try
		{
			qlsTypeChecker.check(parsedForm, parsedStylesheet);

			assertTrue(false);
		}
		catch (QBaseException e)
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error1 = new WidgetTypeMismatchError(new WidgetDeclaration(new CheckBoxWidget()), QBaseQuestionType.NUMBER);
			referenceErrors.add(error1);

			QBaseError error2 = new WidgetTypeMismatchError(new WidgetDeclaration(new SpinBoxWidget()), QBaseQuestionType.TEXT);
			referenceErrors.add(error2);

			List<TextValue> answers = new ArrayList<TextValue>();
			answers.add(new TextValue("yes"));
			answers.add(new TextValue("no"));

			QBaseError error3 = new WidgetTypeMismatchError(new WidgetDeclaration(new RadioButtonWidget(answers)), QBaseQuestionType.BOOLEAN);
			referenceErrors.add(error3);

			assertEquals(qlsTypeChecker.errors(), referenceErrors);
		}
	}

	public void testUnStyledQuestion()
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("qls/error", "unstyledquestionerror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}

		Stylesheet parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("error", "unstyledquestionerror");

		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();

		try
		{
			qlsTypeChecker.check(parsedForm, parsedStylesheet);

			assertTrue(false);
		}
		catch (QBaseException e)
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error = new UnStyledFormQuestionError(new IdentifierLiteral("question2"));
			referenceErrors.add(error);

			assertEquals(qlsTypeChecker.errors(), referenceErrors);
		}
	}

	public void testDoubleDeclaration()
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("qls/error", "doubledeclarationerror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}

		Stylesheet parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("error", "doubledeclarationerror");

		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();

		try
		{
			qlsTypeChecker.check(parsedForm, parsedStylesheet);

			assertTrue(false);
		}
		catch (QBaseException e)
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<StyledQuestion> styledQuestions = new ArrayList<StyledQuestion>();
			styledQuestions.add(new StyledQuestion(new IdentifierValue("question1"), new StyleBlock(new ArrayList<StyleDeclaration>())));
			styledQuestions.add(new StyledQuestion(new IdentifierValue("question1"), new StyleBlock(new ArrayList<StyleDeclaration>())));

			QBaseError error = new QLSDoubleDeclarationError(new IdentifierValue("question1"), styledQuestions);
			referenceErrors.add(error);

			assertEquals(qlsTypeChecker.errors(), referenceErrors);
		}
	}

	public void testDoubledefaultBlock()
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("qls/error", "doubledefaultblockerror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}

		Stylesheet parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("error", "doubledefaultblockerror");

		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();

		try
		{
			qlsTypeChecker.check(parsedForm, parsedStylesheet);

			assertTrue(false);
		}
		catch (QBaseException e)
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();

			List<StyleDeclaration> styleDeclarations1 = new ArrayList<StyleDeclaration>();
			styleDeclarations1.add(new WidgetDeclaration(new SpinBoxWidget()));
			defaultBlocks.add(new DefaultBlock(QBaseQuestionType.NUMBER, styleDeclarations1));

			List<StyleDeclaration> styleDeclarations2 = new ArrayList<StyleDeclaration>();
			styleDeclarations2.add(new WidthDeclaration(new NumberValue(200)));
			defaultBlocks.add(new DefaultBlock(QBaseQuestionType.NUMBER, styleDeclarations2));

			QBaseError error = new DoubleDefaultBlockError(defaultBlocks);
			referenceErrors.add(error);

			assertEquals(qlsTypeChecker.errors(), referenceErrors);
		}
	}


	public void testDoublePropertyDeclaration()
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("qls/error", "doublepropertydeclarationerror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}

		ParseTree tree = QLSTest.produceParseTreeFromSourceFile("error", "doublepropertydeclarationerror");

		RawStylesheetBuilder stylesheetBuilder = new RawStylesheetBuilder();

		stylesheetBuilder.build(tree);
		
		List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

		List<StyleDeclaration> styleDeclarations1 = new ArrayList<StyleDeclaration>();
		styleDeclarations1.add(new FontSizeDeclaration(new NumberValue(12)));
		styleDeclarations1.add(new FontSizeDeclaration(new NumberValue(13)));

		QBaseError error1 = new DoublePropertyDeclarationError(styleDeclarations1);
		referenceErrors.add(error1);
		
		List<StyleDeclaration> styleDeclarations2 = new ArrayList<StyleDeclaration>();
		styleDeclarations2.add(new WidthDeclaration(new NumberValue(1)));
		styleDeclarations2.add(new WidthDeclaration(new NumberValue(2)));

		QBaseError error2 = new DoublePropertyDeclarationError(styleDeclarations2);
		referenceErrors.add(error2);
	
		assertEquals(stylesheetBuilder.errors(), referenceErrors);
	}
}
