package typeChecker;

import exceptions.TypeCheckException;
import parser.Visitor;
import parser.nodes.Form;
import parser.nodes.expression.*;
import parser.nodes.question.Label;
import parser.nodes.question.Question;
import parser.nodes.question.QuestionType;
import parser.nodes.statement.IfStatement;
import parser.nodes.statement.Statement;
import parser.nodes.type.Number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class TypeChecker implements Visitor {

    public static final String ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE = "Question identifier: [%s] was already declared with type: [%s].";
    public static final String ALREADY_DECLARED_QUESTION = "Duplicate question declaration. Identifier: [%s] Type: [%s].";
    private final Map<Identifier, QuestionType> questions;

    public TypeChecker() {
        this.questions = new HashMap<>();
    }

    @Override
    public void visit(Form form) {
        visitStatement(form.getElements());
    }

    private void visitStatement(List<Statement> statements) {
        if (statements != null && !statements.isEmpty()) {
            statements
                    .stream()
                    .forEach(this::visitStatement);
        }
    }

    private void visitStatement(Statement statement) {
        if (statement instanceof IfStatement) {
            visit((IfStatement) statement);
        } else if (statement instanceof Question) {
            visit((Question) statement);
        } else {
            visit(statement);
        }
    }

    @Override
    public void visit(IfStatement ifStatement) {
        visitStatement(ifStatement.getStatements());
    }

    @Override
    public void visit(Statement statement) {
    }

    @Override
    public void visit(Question question) {
        if (questionAlreadyFound(question)) {
            if (foundQuestionHasSameType(question)) {
                throw new TypeCheckException(
                        String.format(ALREADY_DECLARED_QUESTION,
                                question.getIdentifier().getIdentifier(), question.getQuestionType().name()));
            } else {
                throw new TypeCheckException(
                        String.format(ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE,
                                question.getIdentifier().getIdentifier(), questions.get(question.getIdentifier()).name()));
            }
        } else {
            questions.put(question.getIdentifier(), question.getQuestionType());
        }
    }

    private boolean questionAlreadyFound(Question question) {
        return questions.containsKey(question.getIdentifier());
    }

    private boolean foundQuestionHasSameType(Question question) {
        QuestionType questionType = questions.get(question.getIdentifier());
        return questionType.equals(question.getQuestionType());
    }

    @Override
    public void visit(Addition addition) {

    }

    @Override
    public void visit(And and) {

    }

    @Override
    public void visit(Equal equal) {

    }

    @Override
    public void visit(GreaterOrEqual greaterOrEqual) {

    }

    @Override
    public void visit(GreaterThan greaterThan) {

    }

    @Override
    public void visit(Identifier identifier) {
        int i = 0;
    }

    @Override
    public void visit(LessOrEqual lessOrEqual) {

    }

    @Override
    public void visit(LessThan lessThan) {

    }

    @Override
    public void visit(Multiplication multiplication) {

    }

    @Override
    public void visit(Not not) {

    }

    @Override
    public void visit(NotEqual notEqual) {

    }

    @Override
    public void visit(Or or) {

    }

    @Override
    public void visit(parser.nodes.type.Boolean aBoolean) {

    }

    @Override
    public void visit(Number number) {

    }

    @Override
    public void visit(QuestionType questionType) {

    }

    @Override
    public void visit(Label label) {

    }
}
