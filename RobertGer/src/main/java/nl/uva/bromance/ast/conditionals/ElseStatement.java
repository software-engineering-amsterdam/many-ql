package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Node;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class ElseStatement extends Node {

    public ElseStatement(int lineNumber) {
        super(lineNumber, ElseStatement.class);
    }
}
