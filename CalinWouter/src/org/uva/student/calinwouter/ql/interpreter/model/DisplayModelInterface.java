package org.uva.student.calinwouter.ql.interpreter.model;

import javax.swing.event.TableModelEvent;

public interface DisplayModelInterface {
    
    Object[] renderTableRow(Environment environment);

    boolean updateEnvironmentForRowChange(TableModelEvent e);

    boolean isCellEditable(int row, int column);
}
