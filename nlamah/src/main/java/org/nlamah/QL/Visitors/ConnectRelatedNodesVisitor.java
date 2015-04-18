package org.nlamah.QL.Visitors;

import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Expression.Abstract.ComposedExpression;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Binary.AddExpression;
import org.nlamah.QL.Model.Expression.Binary.AndExpression;
import org.nlamah.QL.Model.Expression.Binary.DivideExpression;
import org.nlamah.QL.Model.Expression.Binary.EqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanExpression;
import org.nlamah.QL.Model.Expression.Binary.MultiplyExpression;
import org.nlamah.QL.Model.Expression.Binary.OrExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanExpression;
import org.nlamah.QL.Model.Expression.Binary.SubtractExpression;
import org.nlamah.QL.Model.Expression.Binary.UnEqualExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Expression.Unary.MinusExpression;
import org.nlamah.QL.Model.Expression.Unary.NotExpression;
import org.nlamah.QL.Model.Expression.Unary.PlusExpression;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.ElseIfThenBlock;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public class ConnectRelatedNodesVisitor implements QLNodeVisitor 
{
	private IdentifierLiteral identifierLiteral;
	private Expression lastVisitedExpression;
	
	private ArrayList<String> errors = new ArrayList<String>();
	
	public ArrayList<String> getErrors()
	{
		return errors;
	}
	
	private Question IsIdentifierDeclaredHere(ArrayList<FormElement> childElements) 
	{	
		int numberOfDeclaredItemsWithTheSameIdentifierInTheSameScope = 0;
		Question declaredQuestion = null;
		
		if (Helper.arrayExistsAndHasElements(childElements))
		{
			for (FormElement childElement : childElements)
			{
				if (childElement.identifier() != null)
				{
					if (childElement.identifier().equals(identifierLiteral))
					{
						declaredQuestion =  (Question)childElement;
						
						//TODO if childElement isn't of class Question, then there is a mistake
						
						identifierLiteral.setCorrespondingQuestion(declaredQuestion);
						
						if (identifierLiteral.parentFormElement() != null)
						{
							if (identifierLiteral.parentFormElement() instanceof ComputedQuestion)
							{
								ComputedQuestion computedQuestion = (ComputedQuestion) identifierLiteral.parentFormElement();								
								
								if (computedQuestion.returnType() != declaredQuestion.returnType())
								{
									errors.add("1. there is a type mismatch");
								}
							}
							else if ((identifierLiteral.parentFormElement() instanceof IfThenBlock) || (identifierLiteral.parentFormElement() instanceof ElseIfThenBlock))
							{
								if (declaredQuestion.returnType() != QuestionReturnType.BOOLEAN)
								{
									errors.add("2. there is a type mismatch");
								}
							}
							else
							{
								errors.add("1. the connection between nodes made a mistake");
							}
						}
						else
						{
							if (identifierLiteral.parentNode() != null)
							{
								ComposedExpression parentExpression = (ComposedExpression)identifierLiteral.parentNode();
								
								if (!parentExpression.isSafeForType(declaredQuestion.returnType()))
								{
									errors.add("3. there is a type mismatch");
								}
							}
							else
							{
								errors.add("2. the connection between nodes made a mistake");
							}
						}
						
						
						
						
						
						numberOfDeclaredItemsWithTheSameIdentifierInTheSameScope++;
					}
				}
			}
		}
		
		if (numberOfDeclaredItemsWithTheSameIdentifierInTheSameScope > 1)
		{
			//TODO throw error;
			errors.add("multiple declaration");
		}
		
		return declaredQuestion;
	}
	
	@Override
	public QLNode visit(AddExpression addExpression) 
	{
		lastVisitedExpression = addExpression;
		
		return addExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(AndExpression andExpression) 
	{
		lastVisitedExpression = andExpression;
		
		return andExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(DivideExpression divideExpression) 
	{
		lastVisitedExpression = divideExpression;
		
		return divideExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(EqualExpression equalExpression) 
	{
		lastVisitedExpression = equalExpression;
		
		return equalExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(GreaterThanExpression greaterThanExpression) 
	{
		lastVisitedExpression = greaterThanExpression;
		
		return greaterThanExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(GreaterThanEqualExpression greaterThanEqualExpression) 
	{
		lastVisitedExpression = greaterThanEqualExpression;
		
		return greaterThanEqualExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(MultiplyExpression multiplyExpression) 
	{
		lastVisitedExpression = multiplyExpression;
		
		return multiplyExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(OrExpression orExpression) 
	{
		lastVisitedExpression = orExpression;
		
		return orExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(SmallerThanExpression smallerThanExpression) 
	{
		lastVisitedExpression = smallerThanExpression;
		
		return smallerThanExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(SmallerThanEqualExpression smallerThanEqualExpression) 
	{
		lastVisitedExpression = smallerThanEqualExpression;
		
		return smallerThanEqualExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(SubtractExpression subtractExpression) 
	{
		lastVisitedExpression = subtractExpression;
		
		return subtractExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(UnEqualExpression unEqualExpression) 
	{
		lastVisitedExpression = unEqualExpression;
		
		return unEqualExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(BooleanLiteral booleanLiteral) 
	{
		//This visitor should not call this method
		assert false;
						
		return null;
	}

	@Override
	public QLNode visit(IdentifierLiteral identifierLiteral) 
	{
		this.identifierLiteral = identifierLiteral;
		lastVisitedExpression = identifierLiteral;
		
		return identifierLiteral.parentNode().accept(this);
	}

	@Override
	public QLNode visit(NumberLiteral numberLiteral) 
	{
		//This visitor should not call this method
		assert false;
		
		return null;
	}

	@Override
	public QLNode visit(TextLiteral textLiteral) 
	{
		//This visitor should not call this method
		assert false;
				
		return null;
	}

	@Override
	public QLNode visit(MinusExpression minusExpression) 
	{
		lastVisitedExpression = minusExpression;
		
		return minusExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(NotExpression notExpression) 
	{
		lastVisitedExpression = notExpression;
		
		return notExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(PlusExpression plusExpression) 
	{
		lastVisitedExpression = plusExpression;
		
		return plusExpression.parentNode().accept(this);
	}

	@Override
	public QLNode visit(BooleanQuestion booleanQuestion) 
	{
		//This visitor should not call this method
		assert false;
						
		return null;
	}

	@Override
	public QLNode visit(ComputedQuestion computedQuestion) 
	{	
		lastVisitedExpression.setParentFormElement(computedQuestion);
		
		return computedQuestion.parentNode().accept(this);
	}

	@Override
	public QLNode visit(ConditionalBlock conditionalBlock) 
	{	
		return conditionalBlock.parentNode().accept(this);
	}

	@Override
	public QLNode visit(ElseIfThenBlock elseIfThenBlock) 
	{
		lastVisitedExpression.setParentFormElement(elseIfThenBlock);
		
		Question declaredQuestion = IsIdentifierDeclaredHere(elseIfThenBlock.childElements());
		
		if (declaredQuestion != null)
		{
			return declaredQuestion;
		}
		
		return elseIfThenBlock.parentNode().accept(this);	
	}

	@Override
	public QLNode visit(ElseThenBlock elseThenBlock) 
	{	
		Question declaredQuestion = IsIdentifierDeclaredHere(elseThenBlock.childElements());
		
		if (declaredQuestion != null)
		{
			return declaredQuestion;
		}
		
		return elseThenBlock.parentNode().accept(this);
	}

	@Override
	public QLNode visit(Form form) 
	{
		return IsIdentifierDeclaredHere(form.childElements());
	}

	@Override
	public QLNode visit(IfThenBlock ifThenBlock) 
	{
		lastVisitedExpression.setParentFormElement(ifThenBlock);
		
		Question declaredQuestion = IsIdentifierDeclaredHere(ifThenBlock.childElements());
		
		if (declaredQuestion != null)
		{	
			return declaredQuestion;
		}
		
		return ifThenBlock.parentNode().accept(this);
	}

	@Override
	public QLNode visit(NumberQuestion numberQuestion) 
	{
		//This visitor should not call this method
		assert false;
						
		return null;
	}

	@Override
	public QLNode visit(TextQuestion textQuestion) 
	{
		//This visitor should not call this method
		assert false;
						
		return null;
	}

}
