package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.Error.DoubleDeclarationError;
import org.nlamah.QL.Error.EqualQuestionLabelWarning;
import org.nlamah.QL.Error.TooLateDeclaredQuestionError;
import org.nlamah.QL.Error.UndeclaredQuestionError;
import org.nlamah.QL.Helper.QLHelper;

public class QLTypeChecker 
{
	private List<QBaseError> errors;
	private List<QBaseWarning> warnings;

	private Map<IdentifierLiteral, List<Question>> doubleDeclaratedQuestions;

	public QLTypeChecker()
	{
		errors = new ArrayList<QBaseError>();
		warnings = new ArrayList<QBaseWarning>();
	}

	public void check(Form form) throws QBaseException
	{		
		checkValidityQuestionDeclarations(form);
		
		if (errors.size() == 0)
		{
			checkForTypeMismatchErrors(form);
		}

		checkForDuplicateQuestionLabels(form);
		
		if (errors.size() > 0)
		{
			throw new QBaseException(warnings, errors);
		}
	}

	
	public List<QBaseError> errors()
	{
		return errors;
	}
	
	public List<QBaseWarning> warnings()
	{
		return warnings;
	}

	private void checkValidityQuestionDeclarations(Form form)
	{
		createDoubleDeclaredQuestionList(form);

		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			if (questionIsDeclared(identifier, form) && questionIsDeclaredOnlyOnce(identifier) && questionIsDeclaredBeforeReferredTo(identifier, form))
			{
				if (questionIsDeclaredInRightScopeWithNoCyclicDependency(identifier))
				{
					interconnectReferenceWithDeclaration(identifier, form);
				}
			};
		}
	}
	
	private void interconnectReferenceWithDeclaration(IdentifierLiteral identifier, Form form)
	{
		identifier.setCorrespondingQuestion(QLHelper.getQuestionWithIdentifier(form.declaredQuestions(), identifier));
	}

	private boolean questionIsDeclared(IdentifierLiteral identifier, Form form)
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
		List<Question> questions = doubleDeclaratedQuestions.get(identifier.toString());
		
		if (QLHelper.arrayExistsAndHasElements(questions))
		{
			return questions.size() > 1;
		}

		return true;
	}

	private void createDoubleDeclaredQuestionList(Form form)
	{
		doubleDeclaratedQuestions = new HashMap<IdentifierLiteral, List<Question>>();

		for (Question question : form.declaredQuestions())
		{
			IdentifierLiteral key = question.identifier();

			List<Question> questionsWithTheSameIdentifier = doubleDeclaratedQuestions.get(key);

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
				List<Question> questionsWithTheSameIdentifier = doubleDeclaratedQuestions.get(key);

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

	private boolean questionIsDeclaredBeforeReferredTo(IdentifierLiteral identifier, Form form)
	{
		Question foundDeclaration = QLHelper.getQuestionWithIdentifier(form.declaredQuestions(), identifier);

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
		List<QBaseError> identifierErrors = new ArrayList<QBaseError>();
		
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
		Map<String, List<Question>> questionLabels = new HashMap<String, List<Question>>();

		for (Question question : form.declaredQuestions())
		{
			String labelKey = question.questionText().toString();

			List<Question> questionsWithTheSameLabel = questionLabels.get(labelKey);

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
				List<Question> questionsWithTheSameLabel = questionLabels.get(labelKey);

				if (questionsWithTheSameLabel.size() > 1)
				{
					warnings.add(new EqualQuestionLabelWarning(questionsWithTheSameLabel));
				}
			}
		}
	}
}
