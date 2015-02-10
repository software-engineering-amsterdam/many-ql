package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.QuestionModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class AFormInterpreter implements InterpreterInterface<PForm> {
    /*
    Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        try {
            Start ast = parser.parse();
            // TODO assumes form.
            new AFormInterpreter().interprete(new Environment(), ((AFormBegin) ast.getPBegin()).getForm());
        } catch(Exception e) {
            e.printStackTrace();
        }
     */
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

    private TableModel getTableModel() {
        final DefaultTableModel tableModel = new DefaultTableModel(0,2);
        for (QuestionModel questionModel : environment.getQuestionModels()) {
            tableModel.addRow(new Object[] {
                    questionModel.getText(),
                    environment.getEnvVars().get(questionModel.getVariable())});
        }
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                String variable = environment.getQuestionModels().get(e.getFirstRow()).getVariable();
                String value = tableModel.getValueAt(e.getFirstRow(), 1).toString();
                environment.getEnvVars().put(variable, value);
            }
        });
        return tableModel;
    }

    private void interpreteStatements() {
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
