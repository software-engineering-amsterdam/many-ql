package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;
import nl.uva.bromance.ast.questiontypes.BooleanType;
import nl.uva.bromance.ast.questiontypes.CustomType;
import nl.uva.bromance.ast.questiontypes.IntegerType;
import nl.uva.bromance.ast.questiontypes.StringType;

import java.util.HashMap;
import java.util.Map;

public class QLInitializer extends NullQLNodeVisitor implements QuestionTypeVisitor {

    private Map<String, Result> answerMap = new HashMap<>();
    private Question currentQuestion;

    public QLInitializer(QLNode node) {
        node.accept(this);
    }

    @Override
    public void visit(Question question) {
        currentQuestion = question;
        question.getQuestionType().accept(this);

    }

    @Override
    public void visit(BooleanType booleanType) {
        answerMap.put(currentQuestion.getIdentifier(), new BooleanResult(false));
    }

    @Override
    public void visit(StringType stringType) {
        answerMap.put(currentQuestion.getIdentifier(), new StringResult(""));
    }

    @Override
    public void visit(IntegerType integerType) {
        answerMap.put(currentQuestion.getIdentifier(), new IntResult(0));
    }

    @Override
    public void visit(CustomType customType) {
        answerMap.put(currentQuestion.getIdentifier(), new StringResult(""));
    }

    public Map<String, Result> getAnswerMap() {
        return answerMap;
    }
}
