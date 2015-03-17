package org.uva.student.calinwouter.qlqls.application.gui;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

import java.util.LinkedList;
import java.util.List;

/*
 * A wrapper for the variable table that also allows listeners to get notified when
 * changes occur in the table.
 */
public class StateWrapper {
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

    public StateWrapper(VariableTable variableTable) {
        this.variableTable = variableTable;
        listeners = new LinkedList<ChangedStateEventListener>();
    }
}
