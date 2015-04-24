package org.nlamah.QL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.nlamah.QL.Model.Error.DoubleDeclarationError;
import org.nlamah.QL.Model.Error.EqualQuestionLabelWarning;
import org.nlamah.QL.Model.Error.QLException;
import org.nlamah.QL.Model.Error.TooLateDeclaredQuestionError;
import org.nlamah.QL.Model.Error.UndeclaredQuestionError;
import org.nlamah.QL.Model.Error.Abstract.QLError;
import org.nlamah.QL.Model.Error.Abstract.QLWarning;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.TypeChecker.ExpressionTypeChecker;
import org.nlamah.QL.TypeChecker.IdentifierTypeChecker;
import org.nlamah.QL.TypeChecker.OutOfScopeDeclarationChecker;
import org.nlamah.QL.Helper.QLHelper;

public class QLTypeChecker 
{
	private ArrayList<QLError> errors;
	private ArrayList<QLWarning> warnings;

	private Form form;

	private Map<IdentifierLiteral, ArrayList<Question>> doubleDeclaratedQuestions;

	public QLTypeChecker()
	{
		errors = new ArrayList<QLError>();
		warnings = new ArrayList<QLWarning>();
	}

	public void check(Form form) throws QLException
	{		
		this.form = form;

		checkQuestionDeclaration(form);
		
		if (errors.size() == 0)
		{
			checkForTypeMismatchErrors(form);
		}

		checkForDuplicateQuestionLabels(form);
		
		if (errors.size() > 0)
		{
			throw new QLException(errors);
		}
	}

	
	public ArrayList<QLError> errors()
	{
		return this.errors;
	}
	
	public ArrayList<QLWarning> warnings()
	{
		return warnings;
	}

	private void checkQuestionDeclaration(Form form)
	{
		createDoubleDeclaredList();

		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			if (questionIsDeclared(identifier) && questionIsDeclaredOnlyOnce(identifier) && questionIsDeclaredBeforeReferedTo(identifier))
			{
				if (questionIsDeclaredInRightScopeWithNoCyclicDependency(identifier))
				{
					interconnectReferenceWithDeclaration(identifier);
				}
			};
		}
	}
	
	private void interconnectReferenceWithDeclaration(IdentifierLiteral identifier)
	{
		identifier.setCorrespondingQuestion(QLHelper.getQuestionWithIdentifier(form.declaredQuestions(), identifier));
	}

	private boolean questionIsDeclared(IdentifierLiteral identifier)
	{
		if (QLHelper.getQuestionsWithIdentifier(form.declaredQuestions(), identifier).size() == 0)
		{
			errors.add(new UndeclaredQuestionError(identifier));

			return false;
		}

		return true;

	}

	private boolean questionIsDeclaredOnlyOnce(IdentifierLiteral identifier)
	{
		ArrayList<Question> questions = doubleDeclaratedQuestions.get(identifier.toString());
		
		if (QLHelper.arrayExistsAndHasElements(questions))
		{
			return questions.size() > 1;
		}

		return true;
	}

	private void createDoubleDeclaredList()
	{
		doubleDeclaratedQuestions = new HashMap<IdentifierLiteral, ArrayList<Question>>();

		for (Question question : form.declaredQuestions())
		{
			IdentifierLiteral key = question.identifier();

			ArrayList<Question> questionsWithTheSameIdentifier = doubleDeclaratedQuestions.get(key);

			if (!QLHelper.arrayExistsAndHasElements(questionsWithTheSameIdentifier))
			{
				questionsWithTheSameIdentifier = new ArrayList<Question>();
			}

			questionsWithTheSameIdentifier.add(question);

			doubleDeclaratedQuestions.put(key, questionsWithTheSameIdentifier);

		}

		if (doubleDeclaratedQuestions.size() < form.declaredQuestions().size())
		{
			for (IdentifierLiteral key : doubleDeclaratedQuestions.keySet())
			{
				ArrayList<Question> questionsWithTheSameIdentifier = doubleDeclaratedQuestions.get(key);

				if (questionsWithTheSameIdentifier.size() > 1)
				{
					errors.add(new DoubleDeclarationError(key, questionsWithTheSameIdentifier));
				}
			}
		}
	}

	private boolean questionIsDeclaredInRightScopeWithNoCyclicDependency(IdentifierLiteral identifier)
	{
		OutOfScopeDeclarationChecker outOfScopeChecker = new OutOfScopeDeclarationChecker(identifier);

		errors.addAll(outOfScopeChecker.errors());
		
		return !QLHelper.arrayExistsAndHasElements(outOfScopeChecker.errors());
	}

	private boolean questionIsDeclaredBeforeReferedTo(IdentifierLiteral identifier)
	{
		Question foundDeclaration = QLHelper.getQuestionWithIdentifier(this.form.declaredQuestions(), identifier);

		if (identifier.startsOnLine < foundDeclaration.startsOnLine)
		{
			errors.add(new TooLateDeclaredQuestionError(identifier, foundDeclaration));

			return false;
		}
		else if (identifier.startsOnLine == foundDeclaration.startsOnLine)
		{
			if (identifier.startsAtCharacterPosition < foundDeclaration.startsAtCharacterPosition)
			{
				errors.add(new TooLateDeclaredQuestionError(identifier, foundDeclaration));

				return false;
			}
		}

		return true;
	}


	private void checkForTypeMismatchErrors(Form form)
	{
		ArrayList<QLError> identifierErrors = new ArrayList<QLError>();
		
		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			IdentifierTypeChecker identifierChecker = new IdentifierTypeChecker(identifier);

			identifierErrors.addAll(identifierChecker.errors());
		}
		
		errors.addAll(identifierErrors);
		
		if (identifierErrors.size() == 0)
		{
			ExpressionTypeChecker expressionChecker = new ExpressionTypeChecker(form);
			
			errors.addAll(expressionChecker.errors());
		}
	}

	private void checkForDuplicateQuestionLabels(Form form)
	{
		Map<String, ArrayList<Question>> questionLabels = new HashMap<String, ArrayList<Question>>();

		for (Question question : form.declaredQuestions())
		{
			String labelKey = question.questionText().toString();

			ArrayList<Question> questionsWithTheSameLabel = questionLabels.get(labelKey);

			if (!QLHelper.arrayExistsAndHasElements(questionsWithTheSameLabel))
			{
				questionsWithTheSameLabel = new ArrayList<Question>();
			}

			questionsWithTheSameLabel.add(question);

			questionLabels.put(labelKey, questionsWithTheSameLabel);

		}

		if (questionLabels.size() < form.declaredQuestions().size())
		{
			for (String labelKey : questionLabels.keySet())
			{
				ArrayList<Question> questionsWithTheSameLabel = questionLabels.get(labelKey);

				if (questionsWithTheSameLabel.size() > 1)
				{
					warnings.add(new EqualQuestionLabelWarning(questionsWithTheSameLabel));
				}
			}
		}
	}
}
