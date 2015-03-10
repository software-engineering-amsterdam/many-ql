package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Widget extends AbstractASTNode {

    public final static String DEFAULT_FONT = "Arial";
    public final static int DEFAULT_FONT_SIZE = 12;
    public final static String DEFAULT_COLOR = "#000000";
    public final static int DEFAULT_WIDTH = 50;

    private String label;
    private Style style;

    public Widget(int _lineNum) {
        super(_lineNum);
        this.label = "";
    }

    public Widget() {
        this.label = "";
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

    public abstract void applyStyle(Style _style);

    public abstract List<Type> getSupportedQuestionTypes();

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);

    public void setLabel(String _label) {
        this.label = _label;
    }

    public boolean isNull() {
        return false;
    }
}
