package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.SymbolTable;
import org.uva.student.calinwouter.qlqls.ql.model.Form;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//TODO all the variableMap related functions should be moved to SymbolTable
public class QLIntepreter {
    private List<ChangedStateEventListener> changedStateEventListeners;
    private Map<String, Value<?>> variableMap;
    private FormInterpreter formInterpreter;
    private AForm form;

    public void setField(String key, Value<?> value) {
        variableMap.put(key, value);
        formInterpreter.setField(key,value);
    }

    public Value<?> getField(String key) {
        return variableMap.get(key);
    }

    public Form interpret(){
        System.out.println("interpreting");
        formInterpreter = new FormInterpreter(this);
        form.apply(formInterpreter);
        notifyListeners();
        return formInterpreter.getForm();
    }

    private void notifyListeners() {
        for (ChangedStateEventListener changedStateEventListener : changedStateEventListeners) {
            changedStateEventListener.onStateChanged();
        }
    }

    public void subscribeChangedStateEventListener(ChangedStateEventListener changedStateEventListener) {
        changedStateEventListeners.add(changedStateEventListener);
    }

    public QLIntepreter(AForm form) {
        this.form = form;
        changedStateEventListeners = new LinkedList<ChangedStateEventListener>();
        variableMap = new HashMap<String, Value<?>>();
    }
}
