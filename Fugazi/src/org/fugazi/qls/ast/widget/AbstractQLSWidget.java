package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.UndefinedStyle;
import org.fugazi.qls.ast.style.style_property.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public abstract class AbstractQLSWidget extends AbstractASTNode implements IWidget {

    public final static String DEFAULT_FONT = "Arial";
    public final static int DEFAULT_FONT_SIZE = 12;
    public final static String DEFAULT_COLOR = "#000000";
    public final static int DEFAULT_WIDTH = 50;

    protected String label = "";
    protected Style style = new UndefinedStyle();

    public AbstractQLSWidget(int _lineNum) {
        super(_lineNum);
    }

    public AbstractQLSWidget() {
    }
    
    public Font getDefaultFont() {
        return new Font(DEFAULT_FONT);
    }

    public FontSize getDefaultFontSize() {
        return new FontSize(DEFAULT_FONT_SIZE);
    }
    
    public Color getDefaultColor() {
        return new Color(DEFAULT_COLOR);
    }

    public Width getDefaultWidth() {
        return new Width(DEFAULT_WIDTH);
    }
    
    public Style getDefaultStyle() {
        List<StyleProperty> defaultStyles = new ArrayList<StyleProperty>();
        defaultStyles.add(getDefaultFont());
        defaultStyles.add(getDefaultFontSize());
        defaultStyles.add(getDefaultColor());
        defaultStyles.add(getDefaultWidth());
        
        return new Style(defaultStyles);
    }

    public void resetStyleToDefault() {
        this.style = getDefaultStyle();
        this.applyStyle(this.style);
    }

    public abstract void applyStyle(Style _style);

    @Override
    public JComponent getJComponent() {
        throw new AssertionError();
    }

    @Override
    public ExpressionValue getValue() {
        throw new AssertionError();
    }

    @Override
    public void setValue(ExpressionValue _value) {
        throw new AssertionError();
    }

    @Override
    public void addEventListener(EventListener _listener) {
        throw new AssertionError();
    }
    
    @Override
    public void setReadOnly(boolean _isReadonly) {
        throw new AssertionError();
    }

    public abstract List<Type> getSupportedQuestionTypes();

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);

    public void setLabel(String _label) {
        this.label = _label;
    }

    public boolean isUndefined() {
        return false;
    }
}
