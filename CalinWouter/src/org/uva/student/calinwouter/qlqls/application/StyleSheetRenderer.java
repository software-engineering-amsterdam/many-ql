package org.uva.student.calinwouter.qlqls.application;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class StyleSheetRenderer implements IModel {
    private Component lastComponent;

    @Override
    public void caseHashMap(HashMap<Object, Object> hashMap) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseString(String string) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseInteger(Integer integer) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseStyleSheet(StyleSheet styleSheet) {
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jTabbedPane = new JTabbedPane();
        for (Page p : styleSheet.getPages()) {
            p.apply(this);
            jTabbedPane.add(p.getPageName(), cmp);
        }
        frame.getContentPane().add(lastComponent);
        frame.pack();
        frame.setVisible(true);
        styleSheet.apply(this);
    }

    @Override
    public void caseDefault(Default defaultSetting) {

    }

    @Override
    public void casePage(Page page) {
        lastComponent = new JPanel();
    }

    @Override
    public void caseSection(Section section) {

    }

    @Override
    public void caseTypeDescriptor(TypeDescriptor<?> typeDescriptor) {

    }

    @Override
    public void caseQuestion(Question question) {

    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {

    }

    @Override
    public void caseRadio(Radio radio) {

    }

    @Override
    public void caseSpinbox(Spinbox radio) {

    }

    public StyleSheetRenderer(StyleSheet styleSheet) {
        styleSheet.apply(this);
    }
}
