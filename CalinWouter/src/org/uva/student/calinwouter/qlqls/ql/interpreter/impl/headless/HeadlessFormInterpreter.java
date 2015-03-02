package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldInUseException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InterpretationException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelInUseException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.StmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.*;

/**
 * The HeadlessFormInterpreter is used for interpreting statements without additional actions, creating the model
 * used for rendering the GUI or for unit tests.
 */
public class HeadlessFormInterpreter extends AnalysisAdapter {
    private List<FormField> fields;
    private List<ChangedStateEventListener> changedStateEventListeners;
    private AForm form;
    private Map<String, Value<?>> variableMap;

    public Value<?> getField(String key) {
        return variableMap.get(key);
    }

    public void setField(String key, Value<?> value) {
        variableMap.put(key, value);
    }

    public void addFormField(FormField field) {
        fields.add(field);
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

    private void notifyListeners() {
        for (ChangedStateEventListener changedStateEventListener : changedStateEventListeners) {
            changedStateEventListener.onStateChanged();
        }
    }

    public void interpret() {
        if (form == null) {
            throw new IllegalStateException("No form was applied on the headless form interpreter.");
        }
        fields = new LinkedList<FormField>();
        super.caseAForm(form);
        notifyListeners();
    }

    @Override
    public void caseAForm(AForm form) {
        this.form = form;
    }

    public HeadlessFormInterpreter() {
        variableMap = new HashMap<String, Value<?>>();
        changedStateEventListeners = new LinkedList<ChangedStateEventListener>();
    }
}
