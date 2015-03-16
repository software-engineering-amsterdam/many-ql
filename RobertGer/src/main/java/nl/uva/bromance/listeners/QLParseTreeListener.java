package nl.uva.bromance.listeners;


import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.*;
import nl.uva.bromance.ast.range.Between;
import nl.uva.bromance.ast.range.BiggerThan;
import nl.uva.bromance.ast.range.SmallerThan;
import nl.uva.bromance.parsers.QLBaseListener;
import nl.uva.bromance.parsers.QLParser;

import java.util.Optional;
import java.util.Stack;

//TODO: Use Optional to make it obvious that the value can be null. Makes the code prettier as well.
public class QLParseTreeListener extends QLBaseListener {

    private Stack<Node> nodeStack = new Stack<>();
    private AST ast = null;

    public AST getAst() {
        return ast;
    }

    @Override
    public void enterQuestionnaire(QLParser.QuestionnaireContext ctx) {
        nodeStack.push(new Questionnaire(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitQuestionnaire(QLParser.QuestionnaireContext ctx) {
        ast = new AST(nodeStack.pop());
        System.out.println("--Printing ast--");
        ast.printDebug();
    }

    @Override
    public void enterForm(QLParser.FormContext ctx) {
        nodeStack.push(new Form(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitForm(QLParser.FormContext ctx) {
        Form f = (Form) nodeStack.pop();
        nodeStack.peek().addChild(f);
    }

    @Override
    public void enterQuestion(QLParser.QuestionContext ctx) {
        nodeStack.push(new Question(ctx.start.getLine(), new Identifier(ctx.name.getText())));
    }

    @Override
    public void exitQuestion(QLParser.QuestionContext qtx) {
        Question q = (Question) nodeStack.pop();
        nodeStack.peek().addChild(q);

    }

    @Override
    public void enterQuestionText(QLParser.QuestionTextContext ctx) {
        ((Question) nodeStack.peek()).setQuestionString(ctx.text.getText());
    }

    @Override
    public void enterQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx) {
        ((Question) nodeStack.peek()).setQuestionType(ctx.type.getText());
    }

    @Override
    public void enterQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {
        // TODO: Maybe make this prettier somehow?
        Question peek = (Question) nodeStack.peek();
        peek.setQuestionType("custom");
        peek.setMultipleChoiceOptions(ctx.STRING());
    }

    @Override
    public void exitQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new Between(Integer.parseInt(ctx.lower.getText()), Integer.parseInt(ctx.higher.getText())));
    }

    @Override
    public void exitQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new BiggerThan(Integer.parseInt(ctx.num.getText())));
    }

    @Override
    public void exitQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new SmallerThan(Integer.parseInt(ctx.num.getText())));
    }

    @Override
    public void enterCalculation(QLParser.CalculationContext ctx) {
        nodeStack.push(new Calculation(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitCalculation(QLParser.CalculationContext ctx) {
        Calculation c = (Calculation) nodeStack.pop();
        nodeStack.peek().addChild(c);
    }

    @Override
    public void enterLabel(QLParser.LabelContext ctx) {
        nodeStack.push(new Label(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitLabel(QLParser.LabelContext ctx) {
        Label l = (Label) nodeStack.pop();
        nodeStack.peek().addChild(l);
    }

    @Override
    public void exitLabelText(QLParser.LabelTextContext ctx) {
        nodeStack.peek().addChild(new LabelText(ctx.start.getLine(), ctx.text.getText()));
    }

    @Override
    public void enterInput(QLParser.InputContext ctx) {
        nodeStack.push(new Input(ctx.start.getLine()));
    }

    @Override
    public void exitInput(QLParser.InputContext ctx) {
        Input in = (Input) nodeStack.pop();
        nodeStack.peek().addChild(in);
    }

    /*
     * Expression logic
     */
    @Override
    public void enterIfStatement(QLParser.IfStatementContext ctx) {
        nodeStack.push(new IfStatement(ctx.start.getLine()));
    }

    @Override
    public void enterElseStatement(QLParser.ElseStatementContext ctx) {
        nodeStack.push(new ElseStatement(ctx.start.getLine()));
    }

    //TODO: Create test with multiple elseifStatements
    @Override
    public void enterElseIfStatement(QLParser.ElseIfStatementContext ctx) {
        nodeStack.push(new ElseIfStatement(ctx.start.getLine()));
    }

    //TODO: Not happy with this solution. Maybe think of something that doesn't put the statements into the Node twice.
    @Override
    public void exitIfStatement(QLParser.IfStatementContext ctx) {
        IfStatement ifs = (IfStatement) nodeStack.pop();
        Node peek = nodeStack.peek();
        peek.addChild(ifs);
        if (peek instanceof CanContainConditionals) {
            ((CanContainConditionals) peek).setIfStatement(ifs);
        }
    }

    @Override
    public void exitElseStatement(QLParser.ElseStatementContext ctx) {
        ElseStatement est = (ElseStatement) nodeStack.pop();
        Node peek = nodeStack.peek();
        peek.addChild(est);
        if (peek instanceof CanContainConditionals) {
            ((CanContainConditionals) peek).setElseStatement(est);
        }
    }

    @Override
    public void exitElseIfStatement(QLParser.ElseIfStatementContext ctx) {
        ElseIfStatement eis = (ElseIfStatement) nodeStack.pop();
        Node peek = nodeStack.peek();
        peek.addChild(eis);
        if (peek instanceof CanContainConditionals) {
            ((CanContainConditionals) peek).setElseIfStatement(eis);
        }
    }

    @Override
    public void enterExpression(QLParser.ExpressionContext ctx) {

        nodeStack.push(new Expression(ctx.start.getLine(), Optional.ofNullable(ctx.operator)));
    }

    @Override
    public void exitExpression(QLParser.ExpressionContext ctx) {
        Expression e = (Expression) nodeStack.pop();
        Node peek = nodeStack.peek();
        if (peek instanceof ContainsExpression) {
            ((ContainsExpression) peek).setExpression(e);
        }
        peek.addChild(e);
    }

    //TODO: this is actually not an id these are terminals that can appear in a expression.
    @Override
    public void enterId(QLParser.IdContext ctx) {
        ((Expression) nodeStack.peek()).setTerminal(new Terminal(ctx.getText()));
    }


}
