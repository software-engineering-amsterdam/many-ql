package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
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
    private List<ChangedStateEventListener> changedStateEventListeners;
    private AForm form;

    public void addFormField(FormField field) {
        fields.add(field);
    }

    public List<FormField> getFields() {
        return fields;
    }

    public AForm getForm() {
        return form;
    }

    public String getLabelForField(String fieldName) throws LabelNotAvailableException {
        if (form == null) throw new IllegalStateException("No form was applied on the headless form interpreter.");
        for (FormField f : fields) {
            if (fieldName.equals(f.getVariable()))
                return f.getLabel();
        }
        throw new LabelNotAvailableException();
    }

    public void subscribeChangedStateEventListener(ChangedStateEventListener changedStateEventListener) {
        changedStateEventListeners.add(changedStateEventListener);
    }

    @Override
    protected StmtInterpreter createStmtInterpreter() {
        return new HeadlessStmtInterpreter(this);
    }

    private void notifyListeners() {
        for (ChangedStateEventListener changedStateEventListener : changedStateEventListeners) {
            changedStateEventListener.onStateChanged();
        }
    }

    public void interpret() {
        if (form == null) throw new IllegalStateException("No form was applied on the headless form interpreter.");
        fields = new LinkedList<FormField>();
        super.caseAForm(form);
        notifyListeners();
    }

    @Override
    public void caseAForm(AForm form) {
        this.form = form;
    }

    public HeadlessFormInterpreter() {
        changedStateEventListeners = new LinkedList<ChangedStateEventListener>();
    }
}