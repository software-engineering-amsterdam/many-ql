package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QlsNodeVisitor;

import java.util.List;

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
                if (identifier.getId().equals(q.getIdentifier().getId())) {
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

    @Override
    public void accept(QlsNodeVisitor visitor) {
        visitor.visit(this);
        for (QLSNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    public Question getQuestionNode() {
        return questionNode;
    }
}
