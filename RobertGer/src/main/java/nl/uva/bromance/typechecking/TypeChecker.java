package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.Form;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.exceptions.TypecheckingInvalidOperandException;
import nl.uva.bromance.ast.operators.*;
import nl.uva.bromance.ast.visitors.NullQLNodeVisitor;
import nl.uva.bromance.ast.visitors.OperatorVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker extends NullQLNodeVisitor implements OperatorVisitor {
    private ReferenceMap referenceMap = new ReferenceMap();
    private List<TypeCheckingException> exceptions = new ArrayList<>();
    private Expression currentExpression;
    private String expressionPrefix;

    public List<TypeCheckingException> run(QLNode node) {
        node.accept(this);
        return exceptions;
    }

    @Override
    public void visit(Form form) {
        String identifier = form.getIdentifier();
        if (referenceMap.get(identifier) != null) {
            exceptions.add(new TypeCheckingException.AlreadyDefinedTypeCheckingException(form, identifier));
        } else {
            referenceMap.put(identifier, form);
        }
    }

    @Override
    public void visit(Question question) {
        String prefix = "TypeChecker Error @ line " + question.getLineNumber() + ": Question " + question.getIdentifier()
                + ", ";
        if (question.getQuestionString() == null) {
            exceptions.add(new TypeCheckingException(prefix + "no question asked"));
        }
        if ((question.isQuestionTypeBoolean() || question.isQuestionTypeString()) && question.getQuestionRange().isPresent()) {
            exceptions.add(new TypeCheckingException.QuestionRangeTypeCheckingException(prefix + "no range allowed for types boolean and string."));
        }
    }

    @Override
    public void visit(Expression expression) {
        expressionPrefix = "TypeChecker Error @ line " + expression.getLineNumber() + ": Expression, ";

        if (expression.getOperator().isPresent()) {
            currentExpression = expression;
            expression.getOperator().get().accept(this);
        }
    }

    public void visit(SmallerThanOperator operator) {
        performIntegerCheck();
    }

    public void visit(LargerThanOperator operator) {
        performIntegerCheck();
    }

    public void visit(EqualsOperator operator) {
        performSameTypeCheck();
    }

    public void visit(NotEqualsOperator operator) {
        performSameTypeCheck();
    }

    public void visit(LargerThanOrEqualsOperator operator) {
        performIntegerCheck();
    }

    public void visit(SmallerThanOrEqualsOperator operator) {
        performIntegerCheck();
    }

    public void visit(OrOperator operator) {
        performBooleanCheck();
    }

    public void visit(AndOperator operator) {
        performBooleanCheck();
    }

    public void visit(PlusOperator operator) {
        performIntegerCheck();
    }

    public void visit(MinusOperator operator) {
        performIntegerCheck();
    }

    public void visit(MultiplyOperator operator) {
        performIntegerCheck();
    }

    public void visit(DivideOperator operator) {
        performIntegerCheck();
    }

    private void performIntegerCheck() {
        if (!(currentExpression.getLeftHandSideResult() instanceof IntResult) ||
                !(currentExpression.getRightHandSideResult() instanceof IntResult)) {
            exceptions.add(new TypecheckingInvalidOperandException(expressionPrefix + "Can only perform operation on two integers"));
        }
    }

    private void performBooleanCheck() {
        if (!(currentExpression.getLeftHandSideResult() instanceof BooleanResult) || !(currentExpression.getRightHandSideResult() instanceof BooleanResult)) {
            exceptions.add(new TypecheckingInvalidOperandException(expressionPrefix + "Can only perform operation on two booleans"));
        }
    }

    private void performSameTypeCheck() {
        if (currentExpression.getLeftHandSideResult().getClass() != currentExpression.getRightHandSideResult().getClass()) {
            exceptions.add(new TypecheckingInvalidOperandException(expressionPrefix + "Can only perform operation on the same types"));
        }
    }
}
