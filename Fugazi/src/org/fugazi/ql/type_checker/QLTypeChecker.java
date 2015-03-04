package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.ql.type_checker.visitor.QLTypeCheckerVisitor;

import java.util.*;


public class QLTypeChecker {
    private final QLTypeCheckerVisitor visitor;
    private final ASTIssueHandler astIssueHandler;

    private QLFormDataStorage formData;

    public QLTypeChecker() {
        this.visitor = new QLTypeCheckerVisitor();
        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =====================
     * Private check methods
     * =====================
     */

    private void checkDuplicateLabels() {
        List<Question> questions = this.formData.getQuestions();
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
        return;
    }

    private void checkQuestionTypes() {
        List<Question> questions = this.formData.getQuestions();
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
            boolean conditionIsBool = this.checkIfExpressionIsBool(expression);
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
            boolean typesEqual = this.checkIfTypesEqual(type, computed.getReturnedType());
            if (!typesEqual) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.ERROR.TYPE_MISMATCH, question,
                        "Attempted to assign type " + computed.getReturnedType()
                                + " to variable of type " + type.getClass() + "."
                );
            }
        }
    }



//    private void checkCyclicDependencies() {
//        List<Question> computedQuestions = this.formData.getComputedQuestions();
//
//    }

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

    private boolean checkIfExpressionIsBool(Expression expression) {
        return this.checkIfExpressionIsOfType(expression, new BoolType());
    }

    private boolean checkIfExpressionIsOfType(Expression expression, Type type) {
        return this.checkIfTypesEqual(expression.getReturnedType(), type);
    }

    private boolean checkIfTypesEqual(Type type1, Type type2) {
        return type1.equals(type2);
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    public boolean checkForm(Form form, QLFormDataStorage formData) {
        this.formData = formData;

        // perform all checks that require storage
        this.checkDuplicateLabels();
        this.checkQuestionTypes();
        this.checkIfStatementConditionTypes();
        this.checkAssignmentTypes();
//        this.checkCyclicDependencies();

        // perform all the checks that can be done on the fly
        form.accept(this.visitor);

        return this.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return (!this.astIssueHandler.hasErrors() && this.visitor.isFormCorrect());
    }

    public List<ASTNodeIssue> getErrors() {
        List<ASTNodeIssue> errors = this.astIssueHandler.getErrors();
        errors.addAll(this.visitor.getErrors());

        return errors;
    }

    public List<ASTNodeIssue> getWarnings() {
        List<ASTNodeIssue> warnings = this.astIssueHandler.getWarnings();
        warnings.addAll(this.visitor.getWarnings());

        return warnings;
    }
}
