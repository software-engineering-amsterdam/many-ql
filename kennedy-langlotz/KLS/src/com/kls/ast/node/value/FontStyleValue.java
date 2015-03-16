package com.kls.ast.node.value;

/**
 * Created by Timon on 06.03.2015.
 */
public class FontStyleValue extends AValue<String> {
    public static final String FONT_BOLD = "bold";
    public static final String FONT_ITALIC = "italic";
    public static final String FONT_UNDERLINED = "underlined";

    public FontStyleValue(String fontstyle){
        super(fontstyle, Type.FONT_STYLE);
    }
}
