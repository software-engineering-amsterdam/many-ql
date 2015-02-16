package org.uva.student.calinwouter.qlqls.ql.interpreter.components.gui;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.StmtInterpreter;

import javax.swing.*;
import java.awt.*;

public class GuiFormInterpreter extends FormInterpreter {
    private JFrame frame;
    private JPanel panel;

    @Override
    public void caseAForm(AForm node) {
        super.caseAForm(node);
        String title = node.getIdent().getText();
        createForm(title);
        reInterpret();
    }

    @Override
    protected StmtInterpreter createStmtInterpreter() {
        return new GuiStmtInterpreter(panel, this);
    }

    private void createForm(String title) {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.pack();
    }

    @Override
    protected void reInterpret() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        super.reInterpret();
        JScrollPane jScrollPane = new JScrollPane();
        GridBagConstraints exceptionsConstraints = new GridBagConstraints();
        TextArea ta = new TextArea(interpretationExceptions.toString());
        exceptionsConstraints.fill = GridBagConstraints.BOTH;
        exceptionsConstraints.ipady = 0;
        exceptionsConstraints.anchor = GridBagConstraints.PAGE_START;
        exceptionsConstraints.insets = new Insets(10,0,0,0);
        exceptionsConstraints.gridx = 0;
        exceptionsConstraints.weightx = .25;
        exceptionsConstraints.gridwidth = 2;
        exceptionsConstraints.weighty = 2;
        panel.add(ta, exceptionsConstraints);
        jScrollPane.getViewport().add(panel);
        frame.setContentPane(jScrollPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
