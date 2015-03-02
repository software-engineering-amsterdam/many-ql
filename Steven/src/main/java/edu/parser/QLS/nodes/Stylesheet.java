package edu.parser.QLS.nodes;

import edu.parser.AbstractNode;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.statement.Statement;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Stylesheet implements AbstractNode<QLSVisitor> {
    private final List<Statement> statements;
    private final Identifier title;

    public Stylesheet(Identifier title, List<Statement> statements) {
        this.title = title;
        this.statements = statements;
    }

    public Identifier getTitle() {
        return title;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
