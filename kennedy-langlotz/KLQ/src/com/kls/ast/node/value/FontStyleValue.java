package com.kls.ast.node.value;

/**
 * Created by Timon on 06.03.2015.
 */
public class FontStyleValue extends AValue<Integer> {
    private static final int NONE = 0;
    public static final int BOLD = 1;
    public static final int ITALIC = 2;
    public static final int UNDERLINED = 3;
    public static final int BOLD_ITALIC = 4;
    public static final int BOLD_UNDERLINED = 5;
    public static final int ITALIC_UNDERLINED = 6;
    public static final int BOLD_ITALIC_UNDERLINED = 7;

    public FontStyleValue(int fontstyle){
        super(fontstyle);
    }

    public FontStyleValue(String fontstyle){
        super(NONE);
        boolean bold = false, italic = false, underlined = false;
        if (fontstyle.contains("bold")){
            bold = true;
        }
        if (fontstyle.contains("italic")){
            italic = true;
        }
        if (fontstyle.contains("underlined")) {
            underlined = true;
        }
        this.value = parseFontStyleBooleans(bold, italic, underlined);
    }

    public int parseFontStyleBooleans(boolean bold, boolean italic, boolean underlined){
        if (bold && italic && underlined){
            return BOLD_ITALIC_UNDERLINED;
        } else if (bold && italic){
            return BOLD_ITALIC;
        } else if (bold && underlined){
            return BOLD_UNDERLINED;
        } else if (italic && underlined){
            return ITALIC_UNDERLINED;
        } else if (bold){
            return BOLD;
        } else if (italic){
            return ITALIC;
        } else if (underlined){
            return UNDERLINED;
        }
        return NONE;
    }
}
