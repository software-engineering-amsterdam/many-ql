package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.ql.type_checker.visitor.CyclicDependenciesVisitor;
import org.fugazi.ql.type_checker.visitor.TypeMismatchVisitor;
import org.fugazi.ql.type_checker.visitor.UndefinedQuestionsVisitor;

import java.util.*;


public class QLTypeChecker {
    private final CyclicDependenciesVisitor cyclicDependenciesVisitor;
    private final UndefinedQuestionsVisitor undefinedQuestionsVisitor;
    private final TypeMismatchVisitor typeMismatchVisitor;

    private final ASTIssueHandler astIssueHandler;

    private final Form form;
    private final QLFormDataStorage formData;

    public QLTypeChecker(Form _form, QLFormDataStorage _formData) {
        this.form = _form;
        this.formData = _formData;

        this.cyclicDependenciesVisitor = new CyclicDependenciesVisitor(this.formData);
        this.undefinedQuestionsVisitor = new UndefinedQuestionsVisitor(this.formData);
        this.typeMismatchVisitor = new TypeMismatchVisitor(this.formData);

        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =====================
     * Private check methods
     * =====================
     */

    private void checkDuplicateLabels() {
        List<Question> questions = this.formData.getAllQuestions();
        List<String> labels = new ArrayList<>();

        for (Question question : questions) {
            String label = question.getLabel();

            if (labels.contains(label)) {
                this.astIssueHandler.registerNewWarning(question,
                        "Label defined multiple times! Possible confusion."
                );
            } else {
                labels.add(label);
            }
        }
    }

    private void checkQuestionTypes() {
        List<Question> questions = this.formData.getQuestions();
        // this.formData.getAllQuestionTypes() cannot be reused since
        // duplicate keys are simply overwritten there. The place to detect them
        // is here.
        Map<String, Type> questionTypes = new HashMap<>();

        for (Question question : questions) {
            if (this.wasQuestionDefinedWithDifferentType(questionTypes, question)) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.ERROR.DUPLICATE,
                        question, "Question already defined with different type."
                );
            } else {
                ID questionId = question.getIdentifier();
                questionTypes.put(questionId.getName(), question.getType());
            }
        }
    }

    private void checkIfStatementConditionTypes() {
        List<IfStatement> statements = this.formData.getIfStatements();

        for (IfStatement ifStatement : statements) {
            Expression expression = ifStatement.getCondition();

            // check if condition of type bool
            boolean conditionIsBool = expression.isExpressionOfTypeBool(this.formData);
            if (!conditionIsBool) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.ERROR.NON_BOOL_CONDITION, ifStatement,
                        "Expression in if statement not of type bool."
                );
            }
        }
    }

    private void checkAssignmentTypes() {
        List<ComputedQuestion> questions = this.formData.getComputedQuestions();

        for (ComputedQuestion question : questions) {
            Type type = question.getType();
            Expression computed = question.getComputedExpression();

            // check if assigned types equal
            boolean typesEqual = (type.equals(computed.getReturnedType(this.formData)));
            if (!typesEqual) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.ERROR.TYPE_MISMATCH, question,
                        "Attempted to assign type " + computed.getReturnedType(this.formData)
                                + " to variable of type " + type.getClass() + "."
                );
            }
        }
    }

    private void checkForUndefinedQuestions(Form _form) {
        this.undefinedQuestionsVisitor.visitForm(_form);
    }

    private void checkForTypeMismatches(Form _form) {
        this.typeMismatchVisitor.visitForm(_form);
    }

    private void checkForCyclicDependencies(Form _form) {
        this.cyclicDependenciesVisitor.visitForm(_form);
    }

    /**
     * =====================
     * Helper check methods
     * =====================
     */

    private boolean wasQuestionDefinedWithDifferentType(
            Map<String, Type> questionTypes, Question question
    ) {
        ID questionId = question.getIdentifier();
        Type earlierQuestionType = questionTypes.get(questionId.getName());
        if ((earlierQuestionType != null)
                && (!earlierQuestionType.equals(question.getType()))) {
            return true;
        }
        return false;
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    public boolean checkForm() {

        // clear errors and warnings
        // (so that multiple checks can be performed on one instance)
        this.clearErrorsAndWarnings();

        // perform all checks that require storage
        this.checkDuplicateLabels();
        this.checkQuestionTypes();
        this.checkIfStatementConditionTypes();
        this.checkAssignmentTypes();

        // perform all the checks that are done on the fly
        this.checkForUndefinedQuestions(this.form);
        this.checkForTypeMismatches(this.form);
        this.checkForCyclicDependencies(this.form);

        return this.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return !this.hasErrors();
    }

    public boolean hasErrors() {
        return (this.astIssueHandler.hasErrors()
                || this.undefinedQuestionsVisitor.hasErrors()
                || this.typeMismatchVisitor.hasErrors()
                || this.cyclicDependenciesVisitor.hasErrors());
    }

    public List<ASTNodeIssue> getErrors() {
        List<ASTNodeIssue> errors = this.astIssueHandler.getErrors();
        errors.addAll(this.undefinedQuestionsVisitor.getErrors());
        errors.addAll(this.typeMismatchVisitor.getErrors());
        errors.addAll(this.cyclicDependenciesVisitor.getErrors());

        return errors;
    }

    public List<ASTNodeIssue> getWarnings() {
        List<ASTNodeIssue> warnings = this.astIssueHandler.getWarnings();
        return warnings;
    }

    public void clearErrorsAndWarnings() {
        this.astIssueHandler.clearErrorsAndWarnings();
        this.undefinedQuestionsVisitor.clearErrorsAndWarnings();
        this.typeMismatchVisitor.clearErrorsAndWarnings();
        this.cyclicDependenciesVisitor.clearErrorsAndWarnings();
    }
}
