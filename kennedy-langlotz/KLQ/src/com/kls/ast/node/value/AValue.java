package com.kls.ast.node.value;

import com.kls.ast.node.PropertyNode;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class AValue<T> {
    protected T value;

    public AValue(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public AValue createValueFrom(PropertyNode.Property property, String content){
        switch (property){
            case FONT_FAMILY:
                return new FontFamilyValue(content);
            case FONT_STYLE:
                return new FontStyleValue(content);
            case FONT_SIZE:
                int fontsize = Integer.parseInt(content);
                return new FontSizeValue(fontsize);
            case FONT_COLOR:
            case BACKGROUND_COLOR:
                return new ColorValue(content);
            case WIDGET:
                return new WidgetValue(content);
            default:
                throw new IllegalArgumentException("Unknown Property");
        }
    }
}
