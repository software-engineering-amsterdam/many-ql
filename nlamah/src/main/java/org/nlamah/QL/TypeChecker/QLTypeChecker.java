package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.Error.QLDoubleDeclarationError;
import org.nlamah.QL.Error.DoubleQuestionLabelWarning;
import org.nlamah.QL.Error.TooLateDeclaredQuestionError;
import org.nlamah.QL.Error.UndeclaredFormQuestionError;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Tools.QLTools;
import org.nlamah.QBase.TypeChecker.QBaseAbstractTypeChecker;

public class QLTypeChecker extends QBaseAbstractTypeChecker 
{
	public void check(Form form) throws QBaseException
	{
		checkIfQuestionsAreDeclaredOnlyOnce(form);
		
		checkIfReferenceQuestionsAreDeclaredAtAll(form);
		checkIfReferencedQuestionsAreDeclaredBeforeReferral(form);
				
		questionsAreDeclaredInRightScopeWithNoCyclicDependency(form);

		interconnectReferencesWithDeclarations(form);
		
		checkForTypeMismatchErrors(form);

		checkForDuplicateQuestionLabels(form);
	}
	
	private void checkIfQuestionsAreDeclaredOnlyOnce(Form form) throws QBaseException
	{	
		List<FormQuestion> list = FormQuestion.getListWithDuplicatedQuestionIdentifiers(form.questions());

		if (list.size() > 0)
		{
			for (FormQuestion duplicateQuestion : list)
			{
				errors.add(new QLDoubleDeclarationError(duplicateQuestion.identifier(), QLTools.getQuestionsWithIdentifier(form.questions(), duplicateQuestion.identifier())));
			}
		}
		
		checkForErrors();
	}
	
	private void checkIfReferenceQuestionsAreDeclaredAtAll(Form form) throws QBaseException
	{
		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			if (QLTools.getQuestionsWithIdentifier(form.questions(), identifier).size() == 0)
			{
				errors.add(new UndeclaredFormQuestionError(identifier));
			}
		}
		
		checkForErrors();
	}
		
	private void checkIfReferencedQuestionsAreDeclaredBeforeReferral(Form form) throws QBaseException
	{
		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			questionIsDeclaredBeforeReferredTo(identifier, form);
		}
		
		checkForErrors();
	}
	
	private void questionIsDeclaredBeforeReferredTo(IdentifierLiteral identifier, Form form) throws QBaseException
	{
		FormQuestion foundDeclaration = QLTools.getQuestionWithIdentifier(form.questions(), identifier);

		if (identifier.startsOnLine < foundDeclaration.startsOnLine)
		{
			errors.add(new TooLateDeclaredQuestionError(identifier, foundDeclaration));
		}
		else if (identifier.startsOnLine == foundDeclaration.startsOnLine)
		{
			if (identifier.startsAtCharacterPosition < foundDeclaration.startsAtCharacterPosition)
			{
				errors.add(new TooLateDeclaredQuestionError(identifier, foundDeclaration));
			}
		}
		
		checkForErrors();
	}
	
	private void questionsAreDeclaredInRightScopeWithNoCyclicDependency(Form form) throws QBaseException
	{
		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			OutOfScopeDeclarationChecker outOfScopeChecker = new OutOfScopeDeclarationChecker(identifier);

			errors.addAll(outOfScopeChecker.errors());
		}
		
		checkForErrors();
	}
	

	private void interconnectReferencesWithDeclarations(Form form)
	{
		for (IdentifierLiteral identifier : form.referencedQuestions())
		{
			identifier.setCorrespondingQuestion(QLTools.getQuestionWithIdentifier(form.questions(), identifier));
		}
	}

	private void checkForTypeMismatchErrors(Form form) throws QBaseException
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
		
		checkForErrors();
	}

	private void checkForDuplicateQuestionLabels(Form form)
	{
		List<FormQuestion> list = FormQuestion.getListWithDuplicatedQuestionTexts(form.questions());

		if (list.size() > 0)
		{
			for (FormQuestion question : list)
			{
				warnings.add(new DoubleQuestionLabelWarning(QLTools.getQuestionsWithQuestionText(form.questions(), question.questionText())));
			}
		}
	}
}