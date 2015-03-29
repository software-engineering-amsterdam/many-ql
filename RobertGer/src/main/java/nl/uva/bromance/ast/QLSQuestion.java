package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QLSNodeVisitor;

import java.util.List;

public class QLSQuestion extends QLSNode {

    private Question questionNode;

    public QLSQuestion(int lineNumber, String id, AST qlAST) {
        super(lineNumber);

        List<Question> questions = qlAST.getAllChildrenOfType_ForAst(Question.class);
        if (id != null) {
            id = id.substring(1, id.length() - 1);
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
