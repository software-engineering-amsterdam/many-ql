package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

import java.util.Date;

/**
 * Created by juriaan on 17-2-15.
 */
public class ASTDate extends Node {
    private Date date;

    public ASTDate(Date date) {
        this.date = date;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Date getDate() {
        return date;
    }
}
