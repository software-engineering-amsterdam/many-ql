package nl.uva.softwcons.ast.statement;

import nl.uva.softwcons.ast.ASTNode;

public abstract class Statement implements ASTNode {

    public abstract <T> T accept(StatementVisitor<T> visitor);
}
