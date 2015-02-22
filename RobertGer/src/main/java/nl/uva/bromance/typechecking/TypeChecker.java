package nl.uva.bromance.typechecking;

import nl.uva.bromance.AST.Node;
import nl.uva.bromance.AST.Question;
import nl.uva.bromance.AST.Questionnaire;

import java.util.HashMap;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker {
    private HashMap<String, Node> references = new HashMap<>();
    private Questionnaire ast;

    public TypeChecker(Questionnaire ast) {
        this.ast = ast;
    }

    public boolean runChecks() {
        buildReferenceMap(ast);
        System.out.println("Got questions :");
        for (Node value : references.values()) {
            if (value instanceof Question) {
                System.out.println(((Question) value).getQuestionString());
            }
        }
        return true;
    }

    private void buildReferenceMap(Node n) {
        if (n.hasChildren()) {
            for (Node child : n.getChildren()) {
                buildReferenceMap(child);
            }
        }
        try {
            n.typeCheck(references);
        } catch (TypeCheckingException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
