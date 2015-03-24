package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.*;
import org.fugazi.qls.ast.widget.widget_types.UndefinedWidgetType;
import org.fugazi.qls.ast.widget.widget_types.IWidgetType;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQLSWidget extends AbstractASTNode implements IWidget {

    public final static String DEFAULT_FONT = "Arial";
    public final static int DEFAULT_FONT_SIZE = 14;
    public final static int DEFAULT_COLOR = 0x000000;
    public final static int DEFAULT_WIDTH = 50;

    protected IWidgetType type;

    public AbstractQLSWidget() {
        this.type   = new UndefinedWidgetType();
    }

    public IWidgetType getType() {
        return this.type;
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
        Style style = this.getDefaultStyle();
        this.applyStyle(style);
    }

    public abstract void applyStyle(Style _style);

    @Override
    public abstract void render(UIForm _canvas);

    @Override
    public abstract void suppress(UIForm _canvas);

    @Override
    public abstract ExpressionValue getWidgetValue();

    @Override
    public abstract void setWidgetValue(ExpressionValue _value);

    @Override
    public abstract void addEventListener(WidgetsEventListener _listener);
    
    @Override
    public abstract void setReadOnly(boolean _isReadonly);

    public abstract List<Type> getSupportedQuestionTypes();

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);

    public abstract void setLabel(String _label);

    public boolean isUndefined() {
        return false;
    }
}
