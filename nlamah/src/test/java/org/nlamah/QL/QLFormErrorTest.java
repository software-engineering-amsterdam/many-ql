package org.nlamah.QL;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Error.CyclicDependencyError;
import org.nlamah.QL.Error.QLDoubleDeclarationError;
import org.nlamah.QL.Error.EqualQuestionLabelWarning;
import org.nlamah.QL.Error.ExpressionTypeMismatchError;
import org.nlamah.QL.Error.IdentifierTypeMismatchError;
import org.nlamah.QL.Error.OutOfScopeDeclarationError;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QL.Model.Expression.Binary.AddExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
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
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions1 = new ArrayList<FormQuestion>();

			IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
			FormQuestion question1 = new BooleanQuestion(identifier1, new TextLiteral("test1"));
			declaredQuestions1.add(question1);

			IdentifierLiteral identifier2 = new IdentifierLiteral("question1");
			FormQuestion question2 = new BooleanQuestion(identifier2, new TextLiteral("test2"));
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
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions2 = new ArrayList<FormQuestion>();
			
			IdentifierLiteral identifier3 = new IdentifierLiteral("question2");
			FormQuestion question3 = new TextQuestion(identifier3, new TextLiteral("test3"));
			declaredQuestions2.add(question3);

			IdentifierLiteral identifier4 = new IdentifierLiteral("question2");
			FormQuestion question4 = new TextQuestion(identifier4, new TextLiteral("test4"));
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
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions3 = new ArrayList<FormQuestion>();
			
			IdentifierLiteral identifier5 = new IdentifierLiteral("question3");
			FormQuestion question5 = new NumberQuestion(identifier5, new TextLiteral("test5"));
			declaredQuestions3.add(question5);

			IdentifierLiteral identifier6 = new IdentifierLiteral("question3");
			FormQuestion question6 = new NumberQuestion(identifier6, new TextLiteral("test6"));
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
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();
			
			List<FormQuestion> declaredQuestions4 = new ArrayList<FormQuestion>();
			
			IdentifierLiteral identifier7 = new IdentifierLiteral("question4");
			AddExpression addExpression1 = new AddExpression(new IdentifierLiteral("question3"), new NumberLiteral("1"));
			
			FormQuestion question7 = new ComputedQuestion(identifier7, new TextLiteral("test7"), QBaseQuestionType.NUMBER, addExpression1);
			declaredQuestions4.add(question7);

			IdentifierLiteral identifier8 = new IdentifierLiteral("question4");
			
			AddExpression addExpression2 = new AddExpression(new IdentifierLiteral("question3"), new NumberLiteral("2"));
			
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
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			List<FormQuestion> declaredQuestions = new ArrayList<FormQuestion>();

			IdentifierLiteral identifier1 = new IdentifierLiteral("question5");
			FormQuestion question1 = new NumberQuestion(identifier1, new TextLiteral("test1"));
			declaredQuestions.add(question1);

			IdentifierLiteral identifier2 = new IdentifierLiteral("question5");
			FormQuestion question2 = new BooleanQuestion(identifier2, new TextLiteral("test2"));
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
		}
		
		List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

		List<FormQuestion> declaredQuestions = new ArrayList<FormQuestion>();

		IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
		FormQuestion question1 = new NumberQuestion(identifier1, new TextLiteral("test1"));
		declaredQuestions.add(question1);

		IdentifierLiteral identifier2 = new IdentifierLiteral("question2");
		FormQuestion question2 = new BooleanQuestion(identifier2, new TextLiteral("test1"));
		declaredQuestions.add(question2);

		QBaseError error = new EqualQuestionLabelWarning(declaredQuestions);
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
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error = new ExpressionTypeMismatchError(new BooleanLiteral("yes"));
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
		} 
		catch (QBaseException e) 
		{

			List<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			FormQuestion question = new NumberQuestion(new IdentifierLiteral("question2"), new TextLiteral("test2"));
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
