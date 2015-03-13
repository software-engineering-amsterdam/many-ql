package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.model.Form;
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
public class FormInterpreter extends AnalysisAdapter {
    private List<FormField> fields;
    private List<ChangedStateEventListener> changedStateEventListeners;
    private AForm aForm;
    private Map<String, Value<?>> variableMap;
    private Form form;
    private QLIntepreter qlIntepreter;


    public void setField(String key, Value<?> value) {
        variableMap.put(key, value);
    }

    public void addFormField(FormField field) {
        //fields.add(field);
        form.addFormField(field);
    }

    public Value<?> getField(String key) {
        return variableMap.get(key);
    }

    public AForm getaForm() {
        return aForm;
    }

    public List<FormField> getFields() {
        return fields;
    }

    public Form getForm() { return form;}

    public String getLabelForField(String fieldName) throws LabelNotAvailableException {
        if (aForm == null) throw new IllegalStateException("No aForm was applied on the headless aForm interpreter.");
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

    protected StmtInterpreter createStmtInterpreter() {
        return new StmtInterpreter(this, qlIntepreter);
    }

    private void notifyListeners() {
        for (ChangedStateEventListener changedStateEventListener : changedStateEventListeners) {
            changedStateEventListener.onStateChanged();
        }
    }

    public void interpret() {
        if (aForm == null) throw new IllegalStateException("No aForm was applied on the headless aForm interpreter.");
        fields = new LinkedList<FormField>();
        LinkedList<PStmt> stmts = aForm.getStmt();
        for (PStmt stmt : stmts) {
            stmt.apply(createStmtInterpreter());
        }
        notifyListeners();
    }

    @Override
    public void caseAForm(AForm form) {
        fields = new LinkedList<FormField>();
        LinkedList<PStmt> stmts = form.getStmt();
        for (PStmt stmt : stmts) {
            stmt.apply(createStmtInterpreter());
        }
    }

    public FormInterpreter(QLIntepreter qlIntepreter) {
        form = new Form();
        variableMap = new HashMap<String, Value<?>>();
        changedStateEventListeners = new LinkedList<ChangedStateEventListener>();
        this.qlIntepreter = qlIntepreter;
    }
}