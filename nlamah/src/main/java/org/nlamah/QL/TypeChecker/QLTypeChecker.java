package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseWarning;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.Error.QLDoubleDeclarationError;
import org.nlamah.QL.Error.EqualQuestionLabelWarning;
import org.nlamah.QL.Error.TooLateDeclaredQuestionError;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Helper.QLHelper;

public class QLTypeChecker 
{
	private List<QBaseError> errors;
	private List<QBaseWarning> warnings;

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
		identifier.setCorrespondingQuestion(QLHelper.getQuestionWithIdentifier(form.declaredQuestions(), identifier));
	}

	private boolean questionIsDeclared(IdentifierLiteral identifier, Form form)
	{
		if (QLHelper.getQuestionsWithIdentifier(form.declaredQuestions(), identifier).size() == 0)
		{
			errors.add(new UndeclaredFormQuestionError(identifier));

			return false;
		}

		return true;

	}

	private boolean questionsAreNotDeclaredMoreThanOnce(Form form)
	{
		Set<FormQuestion> set = QBaseHelper.getSetWithDuplicatedObjects(form.declaredQuestions());
		
		if (set.size() > 0)
		{
			for (FormQuestion duplicateQuestion : set)
			{
				errors.add(new QLDoubleDeclarationError(duplicateQuestion.identifier(), QLHelper.getQuestionsWithIdentifier(form.declaredQuestions(), duplicateQuestion.identifier())));
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
		FormQuestion foundDeclaration = QLHelper.getQuestionWithIdentifier(form.declaredQuestions(), identifier);

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
		for (FormQuestion formQuestion : form.declaredQuestions())
		{
			formQuestion.compareOnlyQuestionText = true;
		}
		
		Set<FormQuestion> set = QBaseHelper.getSetWithDuplicatedObjects(form.declaredQuestions());
		
		if (set.size() > 0)
		{
			for (FormQuestion question : set)
			{
				warnings.add(new EqualQuestionLabelWarning(QLHelper.getQuestionsWithIdentifier(form.declaredQuestions(), question.identifier())));
			}
		}
		
		for (FormQuestion formQuestion : form.declaredQuestions())
		{
			formQuestion.compareOnlyQuestionText = false;
		}
	}
}
