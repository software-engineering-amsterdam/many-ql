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
import org.nlamah.QLS.Error.FontRecognitionError;
import org.nlamah.QLS.Error.QLSDoubleDeclarationError;
import org.nlamah.QLS.Error.UnStyledFormQuestionError;
import org.nlamah.QLS.Error.WidgetTypeMismatchError;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;
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
		Form parsedForm = QLTest.produceFormFromSourceFile("qls", "widgettypemismatcherror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}
		
		QLStylesheet parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("error", "widgettypemismatcherror");
		
		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();
		
		try
		{
			qlsTypeChecker.check(parsedForm, parsedStylesheet);
		}
		catch (QBaseException e)
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error1 = new WidgetTypeMismatchError(new WidgetDeclaration(new CheckBoxWidgetType()), QBaseQuestionType.NUMBER);
			referenceErrors.add(error1);
			
			QBaseError error2 = new WidgetTypeMismatchError(new WidgetDeclaration(new SpinBoxWidgetType()), QBaseQuestionType.TEXT);
			referenceErrors.add(error2);
			
			List<TextValue> answers = new ArrayList<TextValue>();
			answers.add(new TextValue("yes"));
			answers.add(new TextValue("no"));
			
			QBaseError error3 = new WidgetTypeMismatchError(new WidgetDeclaration(new RadioButtonWidgetType(answers)), QBaseQuestionType.BOOLEAN);
			referenceErrors.add(error3);
			
			assertEquals(qlsTypeChecker.errors(), referenceErrors);
		}
	}
	
	public void testUnStyledQuestion()
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("qls", "unstyledquestionerror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}
		
		QLStylesheet parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("error", "unstyledquestionerror");
		
		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();
		
		try
		{
			qlsTypeChecker.check(parsedForm, parsedStylesheet);
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
		Form parsedForm = QLTest.produceFormFromSourceFile("qls", "doubledeclarationerror");

		QLTypeChecker qlTypeChecker = new QLTypeChecker();

		try 
		{
			qlTypeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}
		
		QLStylesheet parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("error", "doubledeclarationerror");
		
		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();
		
		try
		{
			qlsTypeChecker.check(parsedForm, parsedStylesheet);
		}
		catch (QBaseException e)
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<StyledQuestion> styledQuestions = new ArrayList<StyledQuestion>();
			styledQuestions.add(new StyledQuestion(new IdentifierValue("question1"), null));
			styledQuestions.add(new StyledQuestion(new IdentifierValue("question1"), null));
			
			QBaseError error = new QLSDoubleDeclarationError(new IdentifierValue("question1"), styledQuestions);
			referenceErrors.add(error);
			
			assertEquals(qlsTypeChecker.errors(), referenceErrors);
		}
	}
}
