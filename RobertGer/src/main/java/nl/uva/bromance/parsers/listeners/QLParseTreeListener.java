package nl.uva.bromance.parsers.listeners;


import nl.uva.bromance.parsers.AST.*;
import nl.uva.bromance.parsers.AST.Conditionals.ElseStatement;
import nl.uva.bromance.parsers.AST.Conditionals.IfStatement;
import nl.uva.bromance.parsers.AST.Expression;
import nl.uva.bromance.parsers.AST.Range.Between;
import nl.uva.bromance.parsers.AST.Range.BiggerThan;
import nl.uva.bromance.parsers.AST.Range.SmallerThan;
import nl.uva.bromance.parsers.QLBaseListener;
import nl.uva.bromance.parsers.QLParser;

import java.util.Stack;

public class QLParseTreeListener extends QLBaseListener {

    private Stack<Node> nodeStack = new Stack();


    public void enterQuestionnaire(QLParser.QuestionnaireContext ctx) {
        nodeStack.push(new Root(ctx.name.getText()));
    }

    public void exitQuestionnaire(QLParser.QuestionnaireContext ctx){
        Root r = (Root) nodeStack.pop();
        System.out.println("--Printing AST--");
        r.printDebug();
    }

    public void enterForm(QLParser.FormContext ctx) {
        nodeStack.push(new Form(ctx.name.getText()));
    }

    public void exitForm(QLParser.FormContext ctx) {
        // Should be of type Form if stack was built correctly
        Form f = (Form) nodeStack.pop();
        nodeStack.peek().addChild(f);
    }

    public void enterQuestion(QLParser.QuestionContext ctx) {
        nodeStack.push(new Question(ctx.name.getText()));
    }

    public void exitQuestion(QLParser.QuestionContext qtx) {
        Question q = (Question) nodeStack.pop();
        nodeStack.peek().addChild(q);

    }

    public void enterQuestionText(QLParser.QuestionTextContext ctx) {
        ((Question) nodeStack.peek()).setQuestionString(ctx.text.getText());
    }

    public void enterQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx) {
        ((Question) nodeStack.peek()).setQuestionType(ctx.type.getText());
    }

    public void enterQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {
        // TODO: Dirty hack, still need to add custom type
        ((Question) nodeStack.peek()).setQuestionType("custom");
        System.err.println("Question of custom list type detected, ignored for now will be implemented later");
    }

    public void exitQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new Between(Integer.parseInt(ctx.lower.getText()), Integer.parseInt(ctx.higher.getText())));
    }

    public void exitQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new BiggerThan(Integer.parseInt(ctx.num.getText())));
    }

    public void exitQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new SmallerThan(Integer.parseInt(ctx.num.getText())));
    }
    public void enterCalculation(QLParser.CalculationContext ctx){
        nodeStack.push(new Calculation(ctx.name.getText()));
    }
    public void exitCalculation(QLParser.CalculationContext ctx){
        Calculation c = (Calculation) nodeStack.pop();
        nodeStack.peek().addChild(c);
    }

    /*
     * Expression logic
     */
    public void enterIfStatement(QLParser.IfStatementContext ctx){
        nodeStack.push(new IfStatement());
    }
    public void enterElseStatement(QLParser.ElseStatementContext ctx){
        nodeStack.push(new ElseStatement());
    }
    public void exitIfStatement(QLParser.IfStatementContext ctx){
        IfStatement ifs = (IfStatement) nodeStack.pop();
        nodeStack.peek().addChild(ifs);
    }
    public void exitElseStatement(QLParser.ElseStatementContext ctx){
        ElseStatement est = (ElseStatement) nodeStack.pop();
        nodeStack.peek().addChild(est);
    }
    public void enterExpression(QLParser.ExpressionContext ctx){
        nodeStack.push(new Expression());
    }
    public void enterId(QLParser.IdContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void exitExpression(QLParser.ExpressionContext ctx){
        Expression e = (Expression) nodeStack.pop();
        nodeStack.peek().addChild(e);
    }
    public void enterExpressionTimes(QLParser.ExpressionTimesContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionDivided(QLParser.ExpressionDividedContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionPlus(QLParser.ExpressionPlusContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionMinus(QLParser.ExpressionMinusContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionEqual(QLParser.ExpressionEqualContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionNotEqual(QLParser.ExpressionNotEqualContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionAnd(QLParser.ExpressionAndContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionOr(QLParser.ExpressionOrContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionSmallerEqual(QLParser.ExpressionSmallerEqualContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionBiggerEqual(QLParser.ExpressionBiggerEqualContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionBigger(QLParser.ExpressionBiggerContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
    public void enterExpressionSmaller(QLParser.ExpressionSmallerContext ctx){
        ((Expression) nodeStack.peek()).setText(ctx.getText());
    }
}
