package org.nlamah.QL;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QL.Model.Error.CyclicDependencyError;
import org.nlamah.QL.Model.Error.DoubleDeclarationError;
import org.nlamah.QL.Model.Error.EqualQuestionLabelWarning;
import org.nlamah.QL.Model.Error.ExpressionTypeMismatchError;
import org.nlamah.QL.Model.Error.IdentifierTypeMismatchError;
import org.nlamah.QL.Model.Error.OutOfScopeDeclarationError;
import org.nlamah.QL.Model.Error.UndeclaredQuestionError;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;
import org.nlamah.QL.Model.Form.Abstract.Question;

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
			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();
			IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
			IdentifierLiteral identifier2 = new IdentifierLiteral("question1");
			Question question = new ComputedQuestion(identifier1, new TextLiteral("test question"), LiteralType.BOOLEAN, identifier2);
			QBaseError error = new CyclicDependencyError(identifier1, question);
			referenceErrors.add(error);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testDoubleDeclaration() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "doubleDeclaration");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{

			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			ArrayList<Question> declaredQuestions = new ArrayList<Question>();

			IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
			Question question1 = new NumberQuestion(identifier1, new TextLiteral("test1"));
			declaredQuestions.add(question1);

			IdentifierLiteral identifier2 = new IdentifierLiteral("question1");
			Question question2 = new BooleanQuestion(identifier2, new TextLiteral("test2"));
			declaredQuestions.add(question2);

			QBaseError error = new DoubleDeclarationError(identifier1, declaredQuestions);
			referenceErrors.add(error);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}

	public void testEqualTextLabel() 
	{
		Form parsedForm = QLTest.produceFormFromSourceFile("error", "equalQuestionLabel");

		QLTypeChecker typeChecker = new QLTypeChecker();

		try 
		{
			typeChecker.check(parsedForm);
		} 
		catch (QBaseException e) 
		{

			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			ArrayList<Question> declaredQuestions = new ArrayList<Question>();

			IdentifierLiteral identifier1 = new IdentifierLiteral("question1");
			Question question1 = new NumberQuestion(identifier1, new TextLiteral("test1"));
			declaredQuestions.add(question1);

			IdentifierLiteral identifier2 = new IdentifierLiteral("question2");
			Question question2 = new BooleanQuestion(identifier2, new TextLiteral("test1"));
			declaredQuestions.add(question2);

			QBaseError error = new EqualQuestionLabelWarning(declaredQuestions);
			referenceErrors.add(error);

			assertEquals(typeChecker.warnings(), referenceErrors);
		}
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

			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();

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

			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();

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

			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();

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

			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			Question question = new NumberQuestion(new IdentifierLiteral("question2"), new TextLiteral("test2"));
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

			ArrayList<QBaseError> referenceErrors = new ArrayList<QBaseError>();

			QBaseError error1 = new UndeclaredQuestionError(new IdentifierLiteral("question1"));
			referenceErrors.add(error1);

			QBaseError error2 = new UndeclaredQuestionError(new IdentifierLiteral("question2"));
			referenceErrors.add(error2);

			assertEquals(typeChecker.errors(), referenceErrors);
		}
	}
}
