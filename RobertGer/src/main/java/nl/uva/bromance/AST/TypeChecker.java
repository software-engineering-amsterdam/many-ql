package nl.uva.bromance.AST;

import nl.uva.bromance.Answer;

import java.util.HashMap;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class TypeChecker {
    private HashMap<String, Answer> questionReferences = new HashMap<>();
    private Root ast;

    public TypeChecker(Root ast){
        this.ast = ast;
    }
    public boolean runChecks(){
        buildReferenceMap(ast);
        System.out.println("Got questions :");
        for (String key : questionReferences.keySet()){
            System.out.println(key);
        }
        return true;
    }
    private void buildReferenceMap(Node n) {
        for (Node child : n.children) {
            if ("Question".equals(child.getClass().getSimpleName())) {
                Question q = (Question) child;
                // Check if we already got a reference to this question
                if (questionReferences.get(q.getIdentifier()) != null){
                    if (!questionReferences.get(q.getIdentifier()).typeIsEqual(q.getQuestionType())){
                        System.err.println("TypeChecker Error @ line "+q.getLineNumber()+": Question "+q.getIdentifier()+" was already defined with a different type");
                    }
                } else {
                    Answer a = new Answer(q.getQuestionType());
                    questionReferences.put(q.getIdentifier(),a);
                }
            } else {
                buildReferenceMap(child);
            }
        }
    }
}
