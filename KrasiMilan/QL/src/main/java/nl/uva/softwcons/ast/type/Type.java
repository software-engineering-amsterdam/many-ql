package nl.uva.softwcons.ast.type;

import nl.uva.softwcons.ast.ASTNode;
import nl.uva.softwcons.ast.LineInfo;

public enum Type implements ASTNode {
    BOOLEAN, STRING, INTEGER, DATE, DECIMAL, UNDEFINED;

    @Override
    public LineInfo getLineInfo() {
        // TODO Auto-generated method stub
        return null;
    }
}
