package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.lexer.Lexer;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.generated.parser.Parser;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.DisplayModelInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.PushbackReader;
import java.io.StringReader;

public class AFormInterpreter implements InterpreterInterface<PForm> {
    private Environment environment;
    private PForm form;
    private TableModel tableModel;
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

    private Object interpreteExpression(String expression) {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(expression)));
        Parser parser = new Parser(lexer);
        try {
            Start ast = parser.parse();
            return new PExpInterpreter().interprete(environment, ((AExpBegin) ast.getPBegin()).getExp());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private TableModel getTableModel() {
        final DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Field", "Value" }, 0) {
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
                if (displayModel.updateEnvironmentForRowChange(e)) {
                    interpreteStatements();
                }
            }
        });
        return tableModel;
    }

    private void interpreteStatements() throws InterpretationException{
        environment.clearDisplay();
        new PStmtlistInterpreter().interprete(environment, ((AForm) form).getStmtlist());
        jtable.setModel(getTableModel());
        jtable.getColumnModel().getColumn(1).setCellEditor(new TypeSpecificCellEditor());
    }

    private String getFormTitle(PForm form) {
        return ((AForm) form).getIdent().getText();
    }

    @Override
    public Object interprete(Environment environment, PForm form) throws InterpretationException {
        this.environment = environment;
        this.form = form;
        createWindow(getFormTitle(form));
        interpreteStatements();
        return null;
    }

    class TypeSpecificCellEditor extends AbstractCellEditor implements TableCellEditor {
        private TableCellEditor editor;

        @Override
        public Object getCellEditorValue() {
            if (editor != null) {
                return editor.getCellEditorValue();
            }

            return null;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof Boolean) {
                editor = new DefaultCellEditor(new JCheckBox());
            } else {
                editor = new DefaultCellEditor(new JTextField());
            }
            return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
        }
    }

}