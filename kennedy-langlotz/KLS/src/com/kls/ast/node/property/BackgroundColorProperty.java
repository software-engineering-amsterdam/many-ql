package com.kls.ast.node.property;

import com.kls.ast.node.value.AValue;

/**
 * Created by Timon on 10.03.2015.
 */
public class BackgroundColorProperty extends AProperty {
    public static final String BACKGROUND_COLOR = "background-color";

    public BackgroundColorProperty() {
        super(BACKGROUND_COLOR);
    }

    @Override
    public boolean isCompatibleWith(AValue value) {
        return value.getType() == AValue.Type.COLOR;
    }
}
