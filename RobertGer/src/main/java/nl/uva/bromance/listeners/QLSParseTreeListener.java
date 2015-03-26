package nl.uva.bromance.listeners;

import nl.uva.bromance.ast.*;
import nl.uva.bromance.parsers.QLSBaseListener;
import nl.uva.bromance.parsers.QLSParser;

import java.util.Stack;

//TODO: Use Optional to make it obvious that the value can be null. Makes the code prettier as well.
public class QLSParseTreeListener extends QLSBaseListener {

    public QLSParseTreeListener(AST qlAST) {
        this.qlAST = qlAST;
    }

    private Stack<QLSNode> nodeStack = new Stack<>();
    private AST<QLNode> qlAST = null;
    private AST<QLSNode> qlsAST = null;

    public AST<QLSNode> getAst() {
        return qlsAST;
    }

    public void enterStylesheet(QLSParser.StylesheetContext ctx) {
        nodeStack.push(new QLSStylesheet(ctx.start.getLine()));
    }

    public void exitStylesheet(QLSParser.StylesheetContext ctx) {
        qlsAST = new AST<>(nodeStack.pop());
        System.out.println("--Printing QLS ast--");
    }

    public void enterPage(QLSParser.PageContext ctx) {
        nodeStack.push(new QLSPage(ctx.start.getLine(), ctx.name.getText()));
    }

    public void exitPage(QLSParser.PageContext ctx) {
        QLSPage page = (QLSPage) nodeStack.pop();
        nodeStack.peek().addChild(page);
    }

    public void enterSection(QLSParser.SectionContext ctx) {
        nodeStack.push(new QLSSection(ctx.start.getLine(), ctx.name.getText()));
    }

    public void exitSection(QLSParser.SectionContext ctx) {
        QLSSection section = (QLSSection) nodeStack.pop();
        nodeStack.peek().addChild(section);
    }

    public void enterQuestion(QLSParser.QuestionContext ctx) {
        nodeStack.push(new QLSQuestion(ctx.start.getLine(), ctx.name.getText(), qlAST));
    }

    public void exitQuestion(QLSParser.QuestionContext ctx) {
        QLSQuestion question = (QLSQuestion) nodeStack.pop();
        nodeStack.peek().addChild(question);
    }
}
