package com.kls.ast.node.value;

/**
 * Created by Timon on 06.03.2015.
 */
public class WidgetValue extends AValue<Integer> {
    private static final int NONE = 0;
    public static final int SLIDER = 1;
    public static final int SPINBOX = 2;
    public static final int TEXT = 3;
    public static final int YES_NO_RADIO = 4;
    public static final int YES_NO_DROPDOWN = 5;
    public static final int CHECKBOX = 6;

    public WidgetValue(int widget){
        super(widget);
    }

    public WidgetValue(String widget){
        super(NONE);
        this.value = parseWidgetString(widget);
    }

    private int parseWidgetString(String widget){
        if (widget.equals("slider")){
            return SLIDER;
        }
        if (widget.equals("spinbox")){
            return SPINBOX;
        }
        if (widget.equals("text")){
            return TEXT;
        }
        if (widget.equals("yes-no-radio")){
            return YES_NO_RADIO;
        }
        if (widget.equals("yes-no-dropdown")){
            return YES_NO_DROPDOWN;
        }
        if (widget.equals("checkbox")){
            return CHECKBOX;
        }
        return NONE;
    }
}
