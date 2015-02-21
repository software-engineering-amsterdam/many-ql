package nl.uva.bromance.AST;

import nl.uva.bromance.AST.Conditionals.ElseIfStatement;
import nl.uva.bromance.AST.Conditionals.ElseStatement;
import nl.uva.bromance.AST.Conditionals.IfStatement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Input extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<>(Arrays.asList(Calculation.class, IfStatement.class, ElseStatement.class, ElseIfStatement.class));

    public Input(int lineNumber) {
        super(lineNumber, Input.class);
        this.setAcceptedParents(parentsAllowed);
    }

}
