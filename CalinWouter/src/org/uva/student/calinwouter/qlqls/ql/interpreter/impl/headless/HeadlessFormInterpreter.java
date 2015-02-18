package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.StmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;

import java.util.LinkedList;
import java.util.List;

/**
 * The HeadlessFormInterpreter is used for interpreting statements without additional actions, creating the model
 * used for rendering the GUI or for unit tests.
 */
public class HeadlessFormInterpreter extends FormInterpreter {

    private List<FormField> fields;

    public void addFormField(FormField field) {
        fields.add(field);
    }

    public List<FormField> getFields() {
        return fields;
    }

    @Override
    protected StmtInterpreter createStmtInterpreter() {
        return new HeadlessStmtInterpreter(this);
    }

    @Override
    public void caseAForm(AForm node) {
        fields = new LinkedList<FormField>();
        super.caseAForm(node);
    }
}
