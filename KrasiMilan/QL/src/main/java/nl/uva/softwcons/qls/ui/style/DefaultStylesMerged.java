package nl.uva.softwcons.qls.ui.style;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.widget.StylizedWidget;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;

public class DefaultStylesMerged {

    private final Map<Type, WidgetType> widgetsForTypes = new HashMap<>();
    private final Map<Type, StyleBlock> stylesForTypes = new HashMap<>();

    public DefaultStylesMerged() {
    }

    public DefaultStylesMerged(Map<Type, StylizedWidget> styles) {
        styles.forEach((type, stylizedWidget) -> {
            widgetsForTypes.put(type, stylizedWidget.getWidgetType().get());
            stylesForTypes.put(type, new StyleBlock(stylizedWidget.getWidgetStyle()));
        });
    }

    public StyleBlock getStyle(Type type) {
        return stylesForTypes.getOrDefault(type, new StyleBlock());
    }

    public WidgetType getWidget(Type type) {
        return widgetsForTypes.get(type);
    }

    public void addStyle(Type type, StyleBlock style) {
        stylesForTypes.put(type, style);
    }

    public void addWidget(Type type, WidgetType widget) {
        widgetsForTypes.put(type, widget);
    }

    public boolean contains(Type type) {
        return widgetsForTypes.containsKey(type);
    }

    public Set<Type> getAllTypes() {
        return widgetsForTypes.keySet();
    }

    public void applyParentStyles(DefaultStylesMerged parentStyles) {
        parentStyles.getAllTypes().forEach(type -> {
            overrideType(type, parentStyles.getWidget(type), parentStyles.getStyle(type));
        });
    }

    private void overrideType(Type type, WidgetType parentWidgetType, StyleBlock parentStyleBlock) {
        if (this.contains(type) && getWidget(type).getClass() == parentWidgetType.getClass()) {
            addStyle(type, getStyle(type).inherit(parentStyleBlock));
        } else {
            addWidget(type, parentWidgetType);
            addStyle(type, parentStyleBlock);
        }
    }
}
