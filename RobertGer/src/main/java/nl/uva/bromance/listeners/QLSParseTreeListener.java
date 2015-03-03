package nl.uva.bromance.listeners;


import nl.uva.bromance.AST.*;
import nl.uva.bromance.parsers.QLSBaseListener;
import nl.uva.bromance.parsers.QLSParser;

import java.util.Stack;

//TODO: Use Optional to make it obvious that the value can be null. Makes the code prettier as well.
public class QLSParseTreeListener extends QLSBaseListener {

    private Stack<Node> nodeStack = new Stack<>();
    private Stylesheet ast = null;

    public Stylesheet getAst() {
        return ast;
    }

    public void enterStylesheet(QLSParser.StylesheetContext ctx) {
        nodeStack.push(new Stylesheet(ctx.start.getLine()));
    }

    public void exitQuestionnaire(QLSParser.StylesheetContext ctx) {
        ast = (Stylesheet) nodeStack.pop();
        System.out.println("--Printing AST--");
        ast.printDebug();
    }
}
