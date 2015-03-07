package com.kls.ast.node;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class Value<T> {
    private T value;

    public Value(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    /*============= Font Family =======================*/
    public class FontFamilyValue extends Value<String> {
        public FontFamilyValue(String fontFamily){
            super(fontFamily);
        }
    }

    /*============ Font Style =========================*/
    public class FontStyleValue extends Value<Integer> {
        public final int BOLD = 1;
        public final int ITALIC = 2;
        public final int UNDERLINED = 3;
        public final int BOLD_ITALIC = 4;
        public final int BOLD_UNDERLINED = 5;
        public final int ITALIC_UNDERLINED = 6;
        public final int BOLD_ITALIC_UNDERLINED = 7;

        public FontStyleValue(int fontStyle){
            super(fontStyle);
        }
    }

    /*============ Font Size ==========================*/
    public class FontSizeValue extends Value<Integer> {
        public FontSizeValue(int fontSize){
            super(fontSize);
        }
    }

    /*=========== Color ==============================*/
    public class ColorValue extends Value<String> {
        public ColorValue(String hexColor){
            super(hexColor);
        }
    }

    /*========== Widget =============================*/
    public class WidgetValue extends Value<Integer> {
        public final int SLIDER = 1;
        public final int SPINBOX = 2;
        public final int TEXT = 3;
        public final int YES_NO_RADIO = 4;
        public final int YES_NO_DROPDOWN = 5;
        public final int CHECKBOX = 6;

        public WidgetValue(int widget){
            super(widget);
        }
    }
}
