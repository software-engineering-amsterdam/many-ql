package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.visualization.Visualizer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QLSQuestion extends QLSNode {
    private Identifier identifier;
    private Question questionNode;

    public QLSQuestion(int lineNumber, String id, AST qlAST) {
        super(lineNumber);

        List<Question> questions = qlAST.getAllChildrenOfType_ForAst(Question.class);

        //TODO: We need to do something about Identfiers being Strings.
        if (id != null) {
            this.identifier = new Identifier(id.toLowerCase());
            for (Question q : questions) {
                if (identifier.getId().equals(q.getIdentifier().get().getId())) {
                    questionNode = q;
                }
            }
            if (questionNode == null) {
                System.err.println("QLS Error @ line " + getLineNumber() + " Reference to undefined question :" + this.identifier.getId());
            }
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public Optional<? extends Pane> visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        return this.questionNode.visualize(parent, answerMap, visualizer);
    }

}
