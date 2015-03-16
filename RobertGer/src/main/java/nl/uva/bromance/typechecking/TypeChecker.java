package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.Question;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker {
    private ReferenceMap referenceMap = new ReferenceMap();
    private AST<QLNode> ast;

    public TypeChecker(AST<QLNode> ast) {
        this.ast = ast;
    }

    public boolean runChecks() {
        buildReferenceMap(ast.getRoot());
        typeCheck(ast.getRoot());
        System.out.println("Got questions :");
        for (QLNode value : referenceMap.values()) {
            if (value instanceof Question) {
                System.out.println(((Question) value).getQuestionString());
            }
        }
        return true;
    }

    private void typeCheck(QLNode n) {
        try {
            n.typeCheck();
        } catch (TypeCheckingException e) {
            e.printStackTrace();
        }
        if (n.hasChildren()) {
            for (QLNode child : n.getChildren()) {
                typeCheck(child);
            }
        }
    }

    private void buildReferenceMap(QLNode n) {
        try {
            n.addReference(referenceMap);
        } catch (TypeCheckingException e) {
            e.printStackTrace();
        }
        if (n.hasChildren()) {
            for (QLNode child : n.getChildren()) {
                buildReferenceMap(child);
            }
        }
    }
}
