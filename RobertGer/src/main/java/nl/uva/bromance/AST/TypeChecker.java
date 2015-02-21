package nl.uva.bromance.AST;

import java.util.HashMap;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker {
    private HashMap<String, Node> references = new HashMap<>();
    private Root ast;

    public TypeChecker(Root ast) {
        this.ast = ast;
    }

    public boolean runChecks() {
        buildReferenceMap(ast);
        System.out.println("Got questions :");
        for (String key : references.keySet()) {
            if ("Question".equals(key)) {
                System.out.println(key);
            }
        }
        return true;
    }

    private void buildReferenceMap(Node n) {
        if (n.hasChildren()) {
            for (Node child : n.children) {
                n.typeCheck(references, n);
                buildReferenceMap(child);
            }
        }
    }
}
