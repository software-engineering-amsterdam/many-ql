package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class QLSQuestion extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<>(Arrays.asList(QLSPage.class,QLSSection.class));
	private String identifier;
    private Question questionNode;

    public QLSQuestion(int lineNumber, String id, AST qlAST) {
        super(lineNumber, QLSQuestion.class);
        super.setAcceptedParents(parentsAllowed);

        List<Question> questions = qlAST.getAllChildrenOfType_ForAst(Question.class);

        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
            for (Question q : questions){
                if (identifier.equals(q.getIdentifier().get())){
                    questionNode = q;
                }
            }
            if (questionNode == null){
                System.err.println("QLS Error @ line "+ getLineNumber() + " Reference to undefined question :"+identifier);
            }
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public Optional<? extends Pane> visualize(Pane parent) {
        return this.questionNode.visualize(parent);
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Question] { Name: "+identifier+" }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }
    }
}
