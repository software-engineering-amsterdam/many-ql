package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;
import org.nlamah.QBase.QBaseAbstractTypeChecker;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.Error.QLDoubleDeclarationError;
import org.nlamah.QL.Error.DoubleQuestionLabelWarning;
import org.nlamah.QL.Error.TooLateDeclaredQuestionError;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QL.Helper.QLHelper;

public class QLTypeChecker extends QBaseAbstractTypeChecker 
{
	private List<QBaseWarning> warnings;

	public QLTypeChecker()
	{
		warnings = new ArrayList<QBaseWarning>();
	}

	public void check(Form form) throws QBaseException
	{		
		checkValidityStyledQuestions(form);

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

	private void checkValidityStyledQuestions(Form form) throws QBaseException
	{
		questionsAreNotDeclaredMoreThanOnce(form);

		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			if (questionIsDeclared(identifier, form) && questionIsDeclaredBeforeReferredTo(identifier, form))
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
		identifier.setCorrespondingQuestion(QLHelper.getQuestionWithIdentifier(form.questions(), identifier));
	}

	private boolean questionIsDeclared(IdentifierLiteral identifier, Form form)
	{
		if (QLHelper.getQuestionsWithIdentifier(form.questions(), identifier).size() == 0)
		{
			errors.add(new UndeclaredFormQuestionError(identifier));

			return false;
		}

		return true;
	}

	private boolean questionsAreNotDeclaredMoreThanOnce(Form form)
	{	
		Set<FormQuestion> set = QBaseHelper.getSetWithDuplicatedObjects(form.questions(), QBaseEqualityState.IDENTIFIER_ONLY);

		if (set.size() > 0)
		{
			for (FormQuestion duplicateQuestion : set)
			{
				errors.add(new QLDoubleDeclarationError(duplicateQuestion.identifier(), QLHelper.getQuestionsWithIdentifier(form.questions(), duplicateQuestion.identifier())));
			}

			return false;
		}

		return true;
	}

	private boolean questionIsDeclaredInRightScopeWithNoCyclicDependency(IdentifierLiteral identifier)
	{
		OutOfScopeDeclarationChecker outOfScopeChecker = new OutOfScopeDeclarationChecker(identifier);

		errors.addAll(outOfScopeChecker.errors());

		return !QBaseHelper.arrayExistsAndHasElements(outOfScopeChecker.errors());
	}

	private boolean questionIsDeclaredBeforeReferredTo(IdentifierLiteral identifier, Form form)
	{
		FormQuestion foundDeclaration = QLHelper.getQuestionWithIdentifier(form.questions(), identifier);

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
		Set<FormQuestion> set = QBaseHelper.getSetWithDuplicatedObjects(form.questions(), QBaseEqualityState.QUESTIONTEXT_ONLY);

		if (set.size() > 0)
		{
			for (FormQuestion question : set)
			{
				warnings.add(new DoubleQuestionLabelWarning(QLHelper.getQuestionsWithQuestionText(form.questions(), question.questionText())));
			}
		}
	}
}
