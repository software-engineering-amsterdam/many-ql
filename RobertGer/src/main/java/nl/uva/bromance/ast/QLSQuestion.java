package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QLSNodeVisitor;

import java.util.List;
import java.util.UUID;

public class QLSQuestion extends QLSNode {
    private UUID identifier;

    private Question questionNode;

    public QLSQuestion(int lineNumber, String id, AST qlAST) {
        super(lineNumber);

        List<Question> questions = qlAST.getAllChildrenOfType_ForAst(Question.class);
        id = id.substring(1,id.length() -1);
        if (id != null) {
            for (Question q : questions) {
                if (id.equals(q.getIdentifier())) {
                    questionNode = q;
                }
            }
            if (questionNode == null) {
                System.err.println("QLS Error @ line " + getLineNumber() + " Reference to undefined question :" + id);
            }
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    @Override
    public void accept(QLSNodeVisitor visitor) {
        visitor.visit(this);
        for (QLSNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    public Question getQuestionNode() {
        return questionNode;
    }
}
