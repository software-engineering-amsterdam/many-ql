package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The HeadlessFormInterpreter is used for interpreting statements without additional actions, creating the model
 * used for rendering the GUI or for unit tests.
 */
//public class HeadlessFormInterpreter extends FormInterpreter {
public class HeadlessFormInterpreter extends AnalysisAdapter {
    private List<FormField> fields;
    private List<ChangedStateEventListener> changedStateEventListeners;
    private AForm form;
    private Map<String, Value<?>> variableMap;


    public void setField(String key, Value<?> value) {
        variableMap.put(key, value);
    }

    public void addFormField(FormField field) {
        fields.add(field);
    }

    public Value<?> getField(String key) {
        return variableMap.get(key);
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

    public boolean hasField(String fieldName) {
        for (FormField f: fields)
            if (fieldName.equals(f.getVariable()))
                return  true;
         return false;
    }

    public void subscribeChangedStateEventListener(ChangedStateEventListener changedStateEventListener) {
        changedStateEventListeners.add(changedStateEventListener);
    }

    //@Override
    //protected StmtInterpreter createStmtInterpreter() {
    protected HeadlessStmtInterpreter createStmtInterpreter() {
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
        //super.caseAForm(form);
        LinkedList<PStmt> stmts = form.getStmt();
        for (PStmt stmt : stmts) {
            stmt.apply(createStmtInterpreter());
        }
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