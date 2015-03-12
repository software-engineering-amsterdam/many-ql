package edu.parser.QL.evaluator;

import edu.exceptions.EvaluationException;
import edu.gui.components.store.Store;
import edu.parser.QL.QLVisitorImpl;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.ExpressionVisitor;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kok on 23/02/2015.
 */
public class Evaluator extends QLVisitorImpl {
    private final List<Question> evaluatedQuestions = new ArrayList<>();
    private final ExpressionVisitor expressionEvaluator;
    private final ExpressionVisitor computedQuestionsRetriever;

    public Evaluator() {
        expressionEvaluator = new EvaluatorExpressionValidator(evaluatedQuestions);
        computedQuestionsRetriever = new ComputedQuestionsRetriever(evaluatedQuestions);
    }

    public List<Question> evaluate(Form form) {
        this.evaluatedQuestions.clear();
        visit(form);
        return evaluatedQuestions;
    }

    @Override
    public AbstractNode visit(Form form) {
        visitStatements(form.getElements());
        return form;
    }

    @Override
    public AbstractNode visit(IfStatement ifStatement) {
        if (isExpressionTrue(ifStatement)) {
            visitStatements(ifStatement.getStatements());
        } else {
            if (ifStatement.getElseClause().isPresent())
                visitStatements(ifStatement.getElseClause().get().getStatements());
        }
        return ifStatement;
    }

    private boolean isExpressionTrue(IfStatement ifStatement) {
        return ((edu.parser.QL.nodes.type.Boolean) ifStatement.getExpression().accept(expressionEvaluator)).isTrue();
    }

    @Override
    public AbstractNode visit(ElseClause elseClause) {
        visitStatements(elseClause.getStatements());
        return elseClause;
    }

    @Override
    public AbstractNode visit(Question question) {
        if (isComputedQuestion(question)) {
            Store computedValue = getComputedValue(question.getExpression().get());
            question.setValue(computedValue);
        }

        evaluatedQuestions.add(question);
        return super.visit(question);
    }

    private boolean isComputedQuestion(Question question) {
        return question.getExpression().isPresent();
    }

    private Store getComputedValue(Expression expression) {
        AbstractNode abstractNode = expression.accept(computedQuestionsRetriever);
        if (abstractNode instanceof Store) {
            return (Store) abstractNode;
        } else {
            throw new EvaluationException("computedQuestionsRetriever returned invalid value: " + abstractNode);
        }
    }


}
