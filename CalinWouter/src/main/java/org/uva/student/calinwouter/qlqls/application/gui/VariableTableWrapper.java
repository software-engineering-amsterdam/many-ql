package org.uva.student.calinwouter.qlqls.application.gui;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

import java.util.LinkedList;
import java.util.List;

public class VariableTableWrapper {
    private VariableTable variableTable;
    private List<ChangedStateEventListener> listeners;

    public void subscribeChangedStateEventListener(ChangedStateEventListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(){
        for(ChangedStateEventListener listener: listeners){
            listener.onStateChanged();
        }
    }

    public void setVariableTable(VariableTable variableTable) {
        this.variableTable = variableTable;
        notifyListeners();
    }

    public VariableTable getVariableTable(){
        return variableTable;
    }

    public VariableTableWrapper(VariableTable variableTable) {
        this.variableTable = variableTable;
        listeners = new LinkedList<ChangedStateEventListener>();
    }
}
