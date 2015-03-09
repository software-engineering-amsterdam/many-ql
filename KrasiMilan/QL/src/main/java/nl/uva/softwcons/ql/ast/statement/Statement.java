package nl.uva.softwcons.ql.ast.statement;

import nl.uva.softwcons.ql.ast.ASTNode;

public abstract class Statement implements ASTNode {

    public abstract <T> T accept(StatementVisitor<T> visitor);
}
