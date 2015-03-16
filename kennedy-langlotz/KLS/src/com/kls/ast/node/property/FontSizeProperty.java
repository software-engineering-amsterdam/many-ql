package com.kls.ast.node.property;

import com.kls.ast.node.value.AValue;

/**
 * Created by Timon on 10.03.2015.
 */
public class FontSizeProperty extends AProperty {
    public final static String FONT_SIZE = "font-size";

    public FontSizeProperty() {
        super(FONT_SIZE);
    }

    @Override
    public boolean isCompatibleWith(AValue value) {
        return value.getType() == AValue.Type.FONT_SIZE;
    }
}
