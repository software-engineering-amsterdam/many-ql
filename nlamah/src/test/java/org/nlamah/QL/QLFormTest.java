package org.nlamah.QL;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Model.Expression.Binary.AndExpression;
import org.nlamah.QL.Model.Expression.Binary.EqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanExpression;
import org.nlamah.QL.Model.Expression.Binary.OrExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.UnEqualExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;

import junit.framework.TestCase;

public class QLFormTest extends TestCase 
{
	private Form parsedForm;
	private Form referenceForm;

	public void testEmptyForm() 
	{	
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("form", "emptyform", false);
			
			referenceForm = new Form("test", new ArrayList<FormElement>());

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		} 
	}

	public void testOneQuestion() 
	{
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("form", "onequestion", false);

			InputQuestion question = new InputQuestion(new IdentifierLiteral("hasSoldHouse"), new TextLiteral("Did you sell a house in 2010?"), QBaseQuestionType.BOOLEAN);
			List<FormElement> questions = new ArrayList<FormElement>();
			questions.add(question);

			referenceForm = new Form("test", questions);

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		} 
	}

	public void testTwoQuestions() 
	{
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("form", "twoquestions", false);

			InputQuestion question1 = new InputQuestion(new IdentifierLiteral("hasSoldHouse"), new TextLiteral("Did you sell a house in 2010?"), QBaseQuestionType.BOOLEAN);
			InputQuestion question2 = new InputQuestion(new IdentifierLiteral("hasMaintLoan"), new TextLiteral("Did you enter a loan for maintenance/reconstruction?"), QBaseQuestionType.BOOLEAN);

			List<FormElement> questions = new ArrayList<FormElement>();
			questions.add(question1);
			questions.add(question2);

			Form referenceForm = new Form("test", questions);

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testSimpleIfStatement() 
	{
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("form", "simpleifstatement", false);

			NumberLiteral leftHandLiteral = new NumberLiteral(1);
			NumberLiteral rightHandLiteral = new NumberLiteral(2);

			SmallerThanEqualExpression smallerThanEqualExpression = new SmallerThanEqualExpression(leftHandLiteral, rightHandLiteral);

			IfThenBlock ifThenBlock = new IfThenBlock(smallerThanEqualExpression, new ArrayList<FormElement>());

			ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenBlock, new ArrayList<ElseIfThenBlock>(), null);

			List<FormElement> conditionalBlocks = new ArrayList<FormElement>();

			conditionalBlocks.add(conditionalBlock);

			referenceForm = new Form("test", conditionalBlocks);

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testSimpleIfElseStatement() 
	{
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("form", "simpleifelsestatement", false);

			NumberLiteral leftHandLiteral = new NumberLiteral(1);
			NumberLiteral rightHandLiteral = new NumberLiteral(2);

			SmallerThanEqualExpression smallerThanEqualExpression = new SmallerThanEqualExpression(leftHandLiteral, rightHandLiteral);

			IfThenBlock ifThenBlock = new IfThenBlock(smallerThanEqualExpression, new ArrayList<FormElement>());
			ElseThenBlock elseThenBlock = new ElseThenBlock(new ArrayList<FormElement>());

			ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenBlock, new ArrayList<ElseIfThenBlock>(), elseThenBlock);
			List<FormElement> formElements = new ArrayList<FormElement>();
			formElements.add(conditionalBlock);

			referenceForm = new Form("test", formElements);

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testSimpleIfElsifElseStatement() 
	{
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("form", "simpleifelsifelsestatement", false);

			NumberLiteral numberLiteral1 = new NumberLiteral(1);
			NumberLiteral numberLiteral2 = new NumberLiteral(2);

			SmallerThanEqualExpression smallerThanEqualExpression = new SmallerThanEqualExpression(numberLiteral1, numberLiteral2);

			IfThenBlock ifThenBlock = new IfThenBlock(smallerThanEqualExpression, new ArrayList<FormElement>());


			NumberLiteral numberLiteral3 = new NumberLiteral(1);
			NumberLiteral numberLiteral4 = new NumberLiteral(2);

			EqualExpression equalExpression = new EqualExpression(numberLiteral3, numberLiteral4);

			ElseIfThenBlock elseIfThen1 = new ElseIfThenBlock(equalExpression, new ArrayList<FormElement>());


			NumberLiteral numberLiteral5 = new NumberLiteral(1);
			NumberLiteral numberLiteral6 = new NumberLiteral(2);

			GreaterThanExpression greaterThanExpression = new GreaterThanExpression(numberLiteral5, numberLiteral6);


			ElseIfThenBlock elseIfThen2 = new ElseIfThenBlock(greaterThanExpression, new ArrayList<FormElement>());

			List<ElseIfThenBlock> elseIfThenBlocks = new ArrayList<ElseIfThenBlock>();
			elseIfThenBlocks.add(elseIfThen1);
			elseIfThenBlocks.add(elseIfThen2);

			ElseThenBlock elseThenBlock = new ElseThenBlock(new ArrayList<FormElement>());

			ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenBlock, elseIfThenBlocks, elseThenBlock);

			List<FormElement> formElements = new ArrayList<FormElement>(1);
			formElements.add(conditionalBlock);

			referenceForm = new Form("test", formElements);

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testNestedIfElsifElseStatement() 
	{
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("form", "nestedifelsestatement", false);

			BooleanLiteral booleanLiteral1 = new BooleanLiteral(true);
			BooleanLiteral booleanLiteral2 = new BooleanLiteral(false);
			OrExpression orExpression = new OrExpression(booleanLiteral1, booleanLiteral2);

			IfThenBlock ifThenBlock = new IfThenBlock(orExpression, new ArrayList<FormElement>());


			NumberLiteral numberLiteral1 = new NumberLiteral(1);
			NumberLiteral numberLiteral2 = new NumberLiteral(2);
			UnEqualExpression unEqualExpression = new UnEqualExpression(numberLiteral1, numberLiteral2);


			IfThenBlock nestedIfThenBlock = new IfThenBlock(unEqualExpression, new ArrayList<FormElement>());
			ElseThenBlock nestedElseThenBlock = new ElseThenBlock(new ArrayList<FormElement>());

			ConditionalBlock nestedConditionBlock = new ConditionalBlock(nestedIfThenBlock, new ArrayList<ElseIfThenBlock>(), nestedElseThenBlock);

			List<FormElement>nestedFormElements = new ArrayList<FormElement>();
			nestedFormElements.add(nestedConditionBlock);


			BooleanLiteral booleanLiteral3 = new BooleanLiteral(false);
			BooleanLiteral booleanLiteral4 = new BooleanLiteral(true);
			AndExpression andExpression = new AndExpression(booleanLiteral3, booleanLiteral4);

			ElseIfThenBlock elseIfThen1 = new ElseIfThenBlock(andExpression, nestedFormElements);

			NumberLiteral numberLiteral3 = new NumberLiteral(3);
			NumberLiteral numberLiteral4 = new NumberLiteral(4);
			EqualExpression equalExpression = new EqualExpression(numberLiteral3, numberLiteral4);

			ElseIfThenBlock elseIfThen2 = new ElseIfThenBlock(equalExpression, new ArrayList<FormElement>());

			List<ElseIfThenBlock> elseIfThenBlocks = new ArrayList<ElseIfThenBlock>();
			elseIfThenBlocks.add(elseIfThen1);
			elseIfThenBlocks.add(elseIfThen2);


			ElseThenBlock elseThenBlock = new ElseThenBlock(new ArrayList<FormElement>());

			ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenBlock, elseIfThenBlocks, elseThenBlock);

			List<FormElement> formElements = new ArrayList<FormElement>();
			formElements.add(conditionalBlock);

			referenceForm = new Form("test", formElements);

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}
}