package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.ql.generated.node.AForm;
import org.uva.student.calinwouter.ql.generated.node.PStmt;
import org.uva.student.calinwouter.ql.interpreter.components.types.TypeModel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FormInterpreter extends AnalysisAdapter {

    private JFrame frame;
    private Map<String, TypeModel<?>> variableMap;
    private LinkedList<PStmt> stmts;

    @Override
    public void caseAForm(AForm node) {
        String title = node.getIdent().getText();
        stmts = node.getStmt();
        createForm(title);
        createFormContent();
    }

    private void createForm(String title) {
        frame = new JFrame(title);
    }

    private void createFormContent() {
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        panel.setLayout(new GridBagLayout());
        for (PStmt stmt : stmts) {
            stmt.apply(new StmtInterpreter(panel, this));
        }
        jScrollPane.getViewport().add(panel);
        frame.setContentPane(jScrollPane);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FormInterpreter() {
        variableMap = new HashMap<String, TypeModel<?>>();
    }

    public TypeModel<?> getField(String key) {
        return variableMap.get(key);
    }

    public void setField(String key, TypeModel<?> value) {
        variableMap.put(key, value);
        createFormContent();
    }
}
