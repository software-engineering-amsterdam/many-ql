package nl.uva.softwcons.qls.ui.style;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.widgetstyle.StyledWidget;
import nl.uva.softwcons.qls.ast.widgetstyle.type.WidgetType;

public class DefaultStylesMerged {
    private final Map<Type, WidgetType> widgetsForTypes;
    private final Map<Type, StyleBlock> stylesForTypes;

    public DefaultStylesMerged() {
        this.widgetsForTypes = new ConcurrentHashMap<>();
        this.stylesForTypes = new ConcurrentHashMap<>();
    }

    public DefaultStylesMerged(final Map<Type, StyledWidget> styles) {
        this();
        styles.forEach((type, stylizedWidget) -> {
            widgetsForTypes.put(type, stylizedWidget.getWidgetType().get());
            stylesForTypes.put(type, new StyleBlock(stylizedWidget.getWidgetStyle()));
        });
    }

    public StyleBlock getStyle(final Type type) {
        return stylesForTypes.getOrDefault(type, new StyleBlock());
    }

    public WidgetType getWidget(final Type type) {
        return widgetsForTypes.get(type);
    }

    public void addStyle(final Type type, final StyleBlock style) {
        stylesForTypes.put(type, style);
    }

    public void addWidget(final Type type, final WidgetType widget) {
        widgetsForTypes.put(type, widget);
    }

    public boolean contains(final Type type) {
        return widgetsForTypes.containsKey(type);
    }

    public Set<Type> getAllTypes() {
        return widgetsForTypes.keySet();
    }

    public void applyParentStyles(final DefaultStylesMerged parentStyles) {
        parentStyles.getAllTypes().forEach(type -> {
            overrideType(type, parentStyles.getWidget(type), parentStyles.getStyle(type));
        });
    }

    private void overrideType(final Type type, final WidgetType parentWidgetType, final StyleBlock parentStyleBlock) {
        if (this.contains(type) && getWidget(type).getClass() == parentWidgetType.getClass()) {
            addStyle(type, getStyle(type).inherit(parentStyleBlock));
        } else {
            addWidget(type, parentWidgetType);
            addStyle(type, parentStyleBlock);
        }
    }
}
