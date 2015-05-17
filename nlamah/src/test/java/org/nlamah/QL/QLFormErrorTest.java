package org.nlamah.QL;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QL.Error.CyclicDependencyError;
import org.nlamah.QL.Error.QLDoubleDeclarationError;
import org.nlamah.QL.Error.DoubleQuestionLabelWarning;
import org.nlamah.QL.Error.ExpressionTypeMismatchError;
import org.nlamah.QL.Error.IdentifierTypeMismatchError;
import org.nlamah.QL.Error.OutOfScopeDeclarationError;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QL.Model.Expression.Binary.AddExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.TypeChecker.QLTypeChecker;

public class QLFormErrorTest extends TestCase
{
	public void testCyclicDependency() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "cyclicDependency");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{
			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();
			IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
			IdentifierLiteral identifier2 = new IdentifierLiteral("question1");
			FormQuestion question = new ComputedQuestion(identifier1, new TextLiteral("test question"), QBaseQuestionType.BOOLEAN, identifier2);
			QBaseError error = new CyclicDependencyError(identifier1, question);
			referenceErrors.add(error);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testDoubleDeclaration1() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "doubleDeclaration1");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions1 = new ArrayList<FormQuestion>();

			IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
			FormQuestion question1 = new InputQuestion(identifier1, new TextLiteral("test1"), QBaseQuestionType.BOOLEAN);
			declaredQuestions1.add(question1);

			IdentifierLiteral identifier2 = new IdentifierLiteral("question1");
			FormQuestion question2 = new InputQuestion(identifier2, new TextLiteral("test2"), QBaseQuestionType.BOOLEAN);
			declaredQuestions1.add(question2);

			QBaseError error1 = new QLDoubleDeclarationError(identifier1, declaredQuestions1);
			referenceErrors.add(error1);			

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}


	public void testDoubleDeclaration2() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "doubleDeclaration2");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions2 = new ArrayList<FormQuestion>();

			IdentifierLiteral identifier3 = new IdentifierLiteral("question2");
			FormQuestion question3 = new InputQuestion(identifier3, new TextLiteral("test3"), QBaseQuestionType.TEXT);
			declaredQuestions2.add(question3);

			IdentifierLiteral identifier4 = new IdentifierLiteral("question2");
			FormQuestion question4 = new InputQuestion(identifier4, new TextLiteral("test4"), QBaseQuestionType.TEXT);
			declaredQuestions2.add(question4);

			QBaseError error2 = new QLDoubleDeclarationError(identifier3, declaredQuestions2);
			referenceErrors.add(error2);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testDoubleDeclaration3() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "doubleDeclaration3");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions3 = new ArrayList<FormQuestion>();

			IdentifierLiteral identifier5 = new IdentifierLiteral("question3");
			FormQuestion question5 = new InputQuestion(identifier5, new TextLiteral("test5"), QBaseQuestionType.NUMBER);
			declaredQuestions3.add(question5);

			IdentifierLiteral identifier6 = new IdentifierLiteral("question3");
			FormQuestion question6 = new InputQuestion(identifier6, new TextLiteral("test6"), QBaseQuestionType.NUMBER);
			declaredQuestions3.add(question6);

			QBaseError error3 = new QLDoubleDeclarationError(identifier5, declaredQuestions3);
			referenceErrors.add(error3);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testDoubleDeclaration4() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "doubleDeclaration4");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions4 = new ArrayList<FormQuestion>();

			IdentifierLiteral identifier7 = new IdentifierLiteral("question4");
			AddExpression addExpression1 = new AddExpression(new IdentifierLiteral("question3"), new NumberLiteral(1));

			FormQuestion question7 = new ComputedQuestion(identifier7, new TextLiteral("test7"), QBaseQuestionType.NUMBER, addExpression1);
			declaredQuestions4.add(question7);

			IdentifierLiteral identifier8 = new IdentifierLiteral("question4");

			AddExpression addExpression2 = new AddExpression(new IdentifierLiteral("question3"), new NumberLiteral(2));

			FormQuestion question8 = new ComputedQuestion(identifier8, new TextLiteral("test8"), QBaseQuestionType.NUMBER, addExpression2);
			declaredQuestions4.add(question8);

			QBaseError error4 = new QLDoubleDeclarationError(identifier7, declaredQuestions4);
			referenceErrors.add(error4);


			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testDoubleDeclaration5() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "doubleDeclaration5");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions = new ArrayList<FormQuestion>();

			IdentifierLiteral identifier1 = new IdentifierLiteral("question5");
			FormQuestion question1 = new InputQuestion(identifier1, new TextLiteral("test1"), QBaseQuestionType.NUMBER);
			declaredQuestions.add(question1);

			IdentifierLiteral identifier2 = new IdentifierLiteral("question5");
			FormQuestion question2 = new InputQuestion(identifier2, new TextLiteral("test2"), QBaseQuestionType.BOOLEAN);
			declaredQuestions.add(question2);

			QBaseError error = new QLDoubleDeclarationError(identifier1, declaredQuestions);
			referenceErrors.add(error);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testEqualTextLabel() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "doubleQuestionText");
		
		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{
			assertTrue(false);
		}

		List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

		List<FormQuestion> declaredQuestions = new ArrayList<FormQuestion>();

		IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
		FormQuestion question1 = new InputQuestion(identifier1, new TextLiteral("test1"), QBaseQuestionType.NUMBER);
		declaredQuestions.add(question1);

		IdentifierLiteral identifier2 = new IdentifierLiteral("question2");
		FormQuestion question2 = new InputQuestion(identifier2, new TextLiteral("test1"), QBaseQuestionType.BOOLEAN);
		declaredQuestions.add(question2);

		QBaseError error = new DoubleQuestionLabelWarning(declaredQuestions);
		referenceErrors.add(error);

		assertEquals(typeChecker.warnings(), referenceErrors);
	}

	public void testExpressionTypeMismatch() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "expressionTypeMismatch");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error = new ExpressionTypeMismatchError(new BooleanLiteral(true));
			referenceErrors.add(error);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testIdentifierTypeMismatch1() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "identifierTypeMismatch1");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error1 = new IdentifierTypeMismatchError(new IdentifierLiteral("question1"));
			referenceErrors.add(error1);
			QBaseError error2 = new IdentifierTypeMismatchError(new IdentifierLiteral("question2"));
			referenceErrors.add(error2);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testIdentifierTypeMismatch2() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "identifierAndExpressionTypeMismatch");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error = new IdentifierTypeMismatchError(new IdentifierLiteral("question1"));
			referenceErrors.add(error);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testOutOfScopeDeclaration() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "outOfScopeDeclaration");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			FormQuestion question = new InputQuestion(new IdentifierLiteral("question2"), new TextLiteral("test2"), QBaseQuestionType.NUMBER);
			QBaseError error = new OutOfScopeDeclarationError(new IdentifierLiteral("question2"), question);
			referenceErrors.add(error);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testUndeclaredQuestion() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "undeclaredQuestion");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
			
			assertTrue(false);
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error1 = new UndeclaredFormQuestionError(new IdentifierLiteral("question1"));
			referenceErrors.add(error1);

			QBaseError error2 = new UndeclaredFormQuestionError(new IdentifierLiteral("question2"));
			referenceErrors.add(error2);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}
}
