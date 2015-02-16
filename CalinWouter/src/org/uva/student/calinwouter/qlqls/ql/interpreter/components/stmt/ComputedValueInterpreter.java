package org.uva.student.calinwouter.qlqls.ql.interpreter.components.stmt;

import org.uva.student.calinwouter.qlqls.generated.node.AValueStmt;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.ExpInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.FormInterpreter;

import javax.swing.*;
import java.awt.*;

public class ComputedValueInterpreter {
    private JPanel jPanel;
    private final AValueStmt node;
    private final FormInterpreter formInterpreter;

    public void interpret() {
        formInterpreter.registerLabelUse(node.getStr().getText());
        GridBagConstraints cTitle = new GridBagConstraints();
        GridBagConstraints cValueComponent;
        Label lblTitle = new Label(node.getStr().getText());
        cTitle.fill = GridBagConstraints.HORIZONTAL;
        cTitle.ipady = 0;
        cTitle.anchor = GridBagConstraints.PAGE_START;
        cTitle.insets = new Insets(10,0,0,0);
        cTitle.gridx = 0;
        cTitle.weightx = .25;
        cTitle.gridwidth = 1;
        cValueComponent = (GridBagConstraints) cTitle.clone();
        cValueComponent.gridx = 1;
        cValueComponent.weightx = .75;
        jPanel.add(lblTitle, cTitle);

        ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        node.getExp().apply(expInterpreter);

        jPanel.add(new Label("" + expInterpreter.getValue()), cValueComponent);
    }

    public ComputedValueInterpreter(JPanel jPanel, FormInterpreter formInterpreter, AValueStmt node) {
        this.jPanel = jPanel;
        this.formInterpreter = formInterpreter;
        this.node = node;
    }
}