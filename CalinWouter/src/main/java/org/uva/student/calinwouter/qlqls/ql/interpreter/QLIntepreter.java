package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.SymbolTable;
import org.uva.student.calinwouter.qlqls.ql.model.Form;

import java.util.LinkedList;
import java.util.List;

public class QLIntepreter {
    private List<ChangedStateEventListener> changedStateEventListeners;
    private AForm aForm;
    private Form form;
    private SymbolTable symbolTable;
    private FormInterpreter formInterpreter;

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public Form getForm() {
        return form;
    }

    public Form interpret(){
        form = new Form();
        formInterpreter = new FormInterpreter(symbolTable, form);
        aForm.apply(formInterpreter);
        notifyListeners();
        return form;
    }

    private void notifyListeners() {
        for (ChangedStateEventListener changedStateEventListener : changedStateEventListeners) {
            changedStateEventListener.onStateChanged();
        }
    }

    public void subscribeChangedStateEventListener(ChangedStateEventListener changedStateEventListener) {
        changedStateEventListeners.add(changedStateEventListener);
    }

    public QLIntepreter(AForm aForm, SymbolTable symbolTable) {
        this.aForm = aForm;
        changedStateEventListeners = new LinkedList<ChangedStateEventListener>();
        this.symbolTable = symbolTable;
    }
}
