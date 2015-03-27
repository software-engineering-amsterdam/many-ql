package nl.uva.softwcons.qls.ast.segment;

import nl.uva.softwcons.qls.ast.ASTNode;

public abstract class PageSegment implements ASTNode {

    public abstract <T> T accept(SegmentVisitor<T> visitor);

}
