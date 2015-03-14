package com.kls.ast.node.property;

import com.kls.ast.node.value.AValue;
import javafx.scene.text.Font;

/**
 * Created by Timon on 10.03.2015.
 */
public class FontFamilyProperty extends AProperty {
    public static final String FONT_FAMILY = "font-family";

    public FontFamilyProperty() {
        super(FONT_FAMILY);
    }

    @Override
    public boolean isCompatibleWith(AValue value) {
        return value.getType() == AValue.Type.STRING
                && Font.getFamilies().contains(value.getValue());
    }
}
