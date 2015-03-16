package com.kls.ast.node.property;

import com.kls.ast.node.value.AValue;

/**
 * Created by Timon on 10.03.2015.
 */
public class FontColorProperty extends AProperty {
    public static final String FONT_COLOR = "font-color";

    public FontColorProperty() {
        super(FONT_COLOR);
    }

    @Override
    public boolean isCompatibleWith(AValue value) {
        return value.getType() == AValue.Type.COLOR;
    }
}
