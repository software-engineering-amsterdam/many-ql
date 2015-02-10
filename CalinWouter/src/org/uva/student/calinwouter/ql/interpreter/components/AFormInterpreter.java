package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.DisplayModelInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class AFormInterpreter implements InterpreterInterface<PForm> {
    private Environment environment;
    private PForm form;
    //private TableModel tableModel;
    private JTable jtable;

    private TableModel createTableModel() {
        return new DefaultTableModel();
    }

    private void createWindow(String formName) {
        JFrame frame = new JFrame("QL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtable = new JTable(createTableModel());
        JScrollPane jScrollPane = new JScrollPane();

        jScrollPane.getViewport().add(jtable);
        frame.getContentPane().add(jScrollPane);
        jScrollPane.setPreferredSize(new Dimension(640, 480));

        frame.pack();
        frame.setVisible(true);
    }

    private TableModel getTableModel() {
        final DefaultTableModel tableModel = new DefaultTableModel(0,2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return environment.getDisplayModels().get(row).isCellEditable(row, column);
            }
        };
        for (DisplayModelInterface displayModel : environment.getDisplayModels()) {
            tableModel.addRow(displayModel.renderTableRow(environment));
        }
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                DisplayModelInterface displayModel = environment.getDisplayModels().get(e.getFirstRow());
                String change = "" + tableModel.getValueAt(e.getFirstRow(), e.getColumn());
                if (displayModel.updateEnvironmentForRowChange(e, change, environment)) {
                    interpreteStatements();
                }
            }
        });
        return tableModel;
    }

    private void interpreteStatements() {
        environment.clearDisplay();
        new PStmtlistInterpreter().interprete(environment, ((AForm) form).getStmtlist());
        jtable.setModel(getTableModel());
    }

    private String getFormTitle(PForm form) {
        return ((AForm) form).getIdent().getText();
    }

    @Override
    public Object interprete(Environment environment, PForm form) {
        this.environment = environment;
        this.form = form;
        createWindow(getFormTitle(form));
        interpreteStatements();
        return null;
    }

}
