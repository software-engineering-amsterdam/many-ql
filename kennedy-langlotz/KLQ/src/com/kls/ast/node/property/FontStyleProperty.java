package com.kls.ast.node.property;

import com.kls.ast.node.value.AValue;

/**
 * Created by Timon on 10.03.2015.
 */
public class FontStyleProperty extends AProperty {
    public final static String FONT_STYLE = "font-style";

    public FontStyleProperty() {
        super(FONT_STYLE);
    }

    @Override
    public boolean isCompatibleWith(AValue value) {
        return value.getType() == AValue.Type.FONT_STYLE;
    }
}
