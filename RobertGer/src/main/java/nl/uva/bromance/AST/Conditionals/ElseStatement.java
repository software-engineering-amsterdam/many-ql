package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Node;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class ElseStatement extends Node {
    private static final String[] parentsAllowed = {"Form","Label","Calculation"};

    public ElseStatement(int lineNumber) {
        super(lineNumber,"ElseStatement");
        super.setAcceptedParents(parentsAllowed);
    }
}
