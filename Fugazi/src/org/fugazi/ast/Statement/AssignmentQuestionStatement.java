package org.fugazi.ast.Statement;

import com.oracle.javafx.jmx.json.JSONDocument;
import com.sun.org.apache.xpath.internal.Expression;
import org.fugazi.ast.Literals.ID;
import org.fugazi.ast.Type.Type;

public class AssignmentQuestionStatement extends QuestionStatement {

    private Expression assignedValue;

    public AssignmentQuestionStatement(Type type, String label, ID identifier, Expression assignedValue) {
        super(type, label, identifier);
        this.assignedValue = assignedValue;
    }

    public Expression getAssignedValue() {
        return this.assignedValue;
    }
}
