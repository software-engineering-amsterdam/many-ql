package nl.uva.bromance.QL.ast;

import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.binary.arithmetic.*;
import nl.uva.bromance.QL.expressions.binary.logicalexpressions.*;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.primitives.StringPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.expressions.unary.Variable;
import nl.uva.bromance.grammar.QL.QLBaseListener;
import nl.uva.bromance.grammar.QL.QLParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QLParseTreeListener extends QLBaseListener {


    private Stack<QLNode> nodeStack = new Stack<>();
    private Stack<String> identifiersStack = new Stack<>();
    private Stack<Evaluable> expressions = new Stack<>();
    private Map<String, Primitive> identifiers = new HashMap<>();

    // Here to differentiate on where to add labelText
    private boolean isQuestion;

    private AST<QLNode> ast = null;

    public AST<QLNode> getAST(){
        return ast;
}

    @Override
    public void enterQuestionnaire(QLParser.QuestionnaireContext ctx) {
        String identifier = ctx.identifier.toString().replace("\"","");
        Questionnaire questionnaire =  new Questionnaire(identifier,ctx.start.getLine());
        nodeStack.push(questionnaire);
    }

    @Override
    public void exitQuestionnaire(QLParser.QuestionnaireContext ctx) {
        ast = new AST(nodeStack.pop(), identifiers);
    }

    @Override
    public void enterForm(QLParser.FormContext ctx) {
        String identifier = ctx.identifier.getText().replace("\"", "");
        Form form =  new Form(identifier, ctx.start.getLine());
        nodeStack.push(form);
    }

    @Override
    public void exitForm(QLParser.FormContext ctx) {
        Form f = (Form) nodeStack.pop();
        nodeStack.peek().addChild(f);
    }

    @Override
    public void enterQuestion(QLParser.QuestionContext ctx) {
        String identifier = ctx.identifier.getText().replace("\"","");
        identifiersStack.push(identifier);
        Question question =  new Question(identifier, ctx.start.getLine());
        nodeStack.push(question);
        isQuestion = true;
    }

    @Override
    public void exitQuestion(QLParser.QuestionContext ctx) {
        Question q = (Question) nodeStack.pop();
        q.setType(identifiers.get(q.getIdentifier()));
        nodeStack.peek().addChild(q);
        isQuestion = false;
    }

    @Override
    public void enterCalculation(QLParser.CalculationContext ctx) {

    }

    @Override
    public void exitCalculation(QLParser.CalculationContext ctx) {

    }

    @Override
    public void enterLabel(QLParser.LabelContext ctx) {

    }

    @Override
    public void exitLabel(QLParser.LabelContext ctx) {

    }

    @Override
    public void enterTextLabel(QLParser.TextLabelContext ctx) {
        if (isQuestion){
            Question q = (Question) nodeStack.peek();
            q.setText(ctx.identifier.getText().replace("\"",""));
        }
    }

    @Override
    public void exitTextLabel(QLParser.TextLabelContext ctx) {
    }

    @Override
    public void enterInput(QLParser.InputContext ctx) {

    }

    @Override
    public void exitInput(QLParser.InputContext ctx) {

    }

    @Override
    public void enterIfSequence(QLParser.IfSequenceContext ctx) {

    }

    @Override
    public void exitIfSequence(QLParser.IfSequenceContext ctx) {

    }

    @Override
    public void enterIfStatement(QLParser.IfStatementContext ctx) {

    }

    @Override
    public void exitIfStatement(QLParser.IfStatementContext ctx) {

    }

    @Override
    public void enterElseStatement(QLParser.ElseStatementContext ctx) {

    }

    @Override
    public void exitElseStatement(QLParser.ElseStatementContext ctx) {

    }

    @Override
    public void enterElseIfStatement(QLParser.ElseIfStatementContext ctx) {

    }

    @Override
    public void exitElseIfStatement(QLParser.ElseIfStatementContext ctx) {

    }

    @Override
    public void enterQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx) {
        String identifier = identifiersStack.pop();
        switch(ctx.type.toString())
        {
            case "integer":
                identifiers.put(identifier,  new NumberPrimitive(0));
                break;
            case "string":
                identifiers.put(identifier,  new StringPrimitive(""));
                break;
            case "boolean":
                identifiers.put(identifier, new BooleanPrimitive(false));
                break;
            default:
                break;
        }

    }

    @Override
    public void enterQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {
        String identifier = identifiersStack.pop();
        Primitive primitive = new StringPrimitive("");
        identifiers.put(identifier, primitive);
    }

    @Override
    public void exitQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {

    }

    @Override
    public void enterQuestionRange(QLParser.QuestionRangeContext ctx) {

    }

    @Override
    public void exitQuestionRange(QLParser.QuestionRangeContext ctx) {

    }

    @Override
    public void enterQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {

    }

    @Override
    public void exitQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {

    }

    @Override
    public void enterQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {

    }

    @Override
    public void exitQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {

    }

    @Override
    public void enterQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {

    }

    @Override
    public void exitQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {

    }

    @Override
    public void enterQuestionAllowedTypes(QLParser.QuestionAllowedTypesContext ctx) {

    }

    @Override
    public void exitQuestionAllowedTypes(QLParser.QuestionAllowedTypesContext ctx) {

    }

    @Override
    public void exitVariable(QLParser.VariableContext ctx) {
        /*
        String identifier = ctx.identifier.toString().replace("\"","");
        nodeStack.push(new Variable(identifier, ctx.start.getLine()));
        */
    }

    @Override
    public void exitPrimitive(QLParser.PrimitiveContext ctx) {
        /*
        switch(ctx.value.getType()){
            case QLParser.STRING:
                expressions.push(new StringPrimitive(ctx.value.toString().replace("\"","")));
                break;
            case QLParser.NUMBER:
                expressions.push(new NumberPrimitive(Integer.parseInt(ctx.value.toString())));
                break;
        }
        */
    }

    @Override
    public void exitArithmeticExpression(QLParser.ArithmeticExpressionContext ctx) {
        /*
        if(ctx.operator != null) {
            BinaryExpression expression = null;
            Evaluable right = expressions.pop();
            Evaluable left = expressions.pop();

            switch (ctx.operator.getType()) {
                case QLParser.ADDITION:
                    expression = new Addition(left, right);
                    break;
                case QLParser.SUBTRACTION:
                    expression = new Subtraction(left, right);
                    break;
                case QLParser.MULTIPLICATION:
                    expression = new Multiplication(left, right);
                    break;
                case QLParser.DIVISION:
                    expression = new Division(left, right);
                    break;
            }
            this.expressions.push(expression);
        }*/
    }

    @Override
    public void exitLogicalExpression(QLParser.LogicalExpressionContext ctx) {
        /*
        if(ctx.operator != null)
        {
            BinaryExpression expression = null;
            Evaluable right = expressions.pop();
            Evaluable left = expressions.pop();

            switch(ctx.operator.getType()){
                case QLParser.AND:
                    expression = new And(left,right);
                    break;
                case QLParser.OR:
                    expression = new Or(left,right);
                    break;
                case QLParser.EQUALTO:
                    expression = new EqualTo(left,right);
                    break;
                case QLParser.NOTEQUALTO:
                    expression = new NotEqualTo(left,right);
                    break;
                case QLParser.BIGGERTHANOREQUAL:
                    expression = new BiggerThanOrEqual(left,right);
                    break;
                case QLParser.BIGGERTHAN:
                    expression = new BiggerThan(left,right);
                    break;
                case QLParser.SMALLERTHANOREQUAL:
                    expression = new SmallerThanOrEqual(left,right);
                    break;
                case QLParser.SMALLERTHAN:
                    expression = new SmallerThan(left,right);
                    break;
            }
            this.expressions.push(expression);
        }
         */
    }
}
