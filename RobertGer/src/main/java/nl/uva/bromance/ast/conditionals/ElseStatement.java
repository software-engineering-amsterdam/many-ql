package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Calculation;
import nl.uva.bromance.ast.Form;
import nl.uva.bromance.ast.Label;
import nl.uva.bromance.ast.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class ElseStatement extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<Class<? extends Node>>(Arrays.asList(Form.class, Label.class, Calculation.class));

    public ElseStatement(int lineNumber) {
        super(lineNumber, ElseStatement.class);
        super.setAcceptedParents(parentsAllowed);
    }
}
