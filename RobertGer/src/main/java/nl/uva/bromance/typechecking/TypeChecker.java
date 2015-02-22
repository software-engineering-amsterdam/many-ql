package nl.uva.bromance.typechecking;

import nl.uva.bromance.AST.Node;
import nl.uva.bromance.AST.Question;
import nl.uva.bromance.AST.Questionnaire;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker {
    private ReferenceMap referenceMap = new ReferenceMap();
    private Questionnaire ast;

    public TypeChecker(Questionnaire ast) {
        this.ast = ast;
    }

    public boolean runChecks() {
        buildReferenceMap(ast);
        typeCheck(ast);
        System.out.println("Got questions :");
        for (Node value : referenceMap.values()) {
            if (value instanceof Question) {
                System.out.println(((Question) value).getQuestionString());
            }
        }
        return true;
    }

    private void typeCheck(Node n) {
        try {
            n.typeCheck();
        } catch (TypeCheckingException e) {
            e.printStackTrace();
        }
        if (n.hasChildren()) {
            for (Node child : n.getChildren()) {
                buildReferenceMap(child);
            }
        }
    }

    private void buildReferenceMap(Node n) {
        try {
            n.addReference(referenceMap);
        } catch (TypeCheckingException e) {
            e.printStackTrace();
        }
        if (n.hasChildren()) {
            for (Node child : n.getChildren()) {
                buildReferenceMap(child);
            }
        }
    }
}
