package com.kls.ast.node.value;

/**
 * Created by Timon on 06.03.2015.
 */
public class WidgetValue extends AValue<String> {

    public WidgetValue(String widget){
        super(widget, Type.WIDGET);
    }

    public WidgetValue(Widget widget){
        super(widget.toString(), Type.WIDGET);
    }

    public enum Widget {
        NOT_A_WIDGET(null), SLIDER("slider"), SPINBOX("spinbox"), TEXT("text"),
        YES_NO_RADIO("yes-no-radio"), YES_NO_DROPDOWN("yes-no-dropdown"), CHECKBOX("checkbox");

        private String string;

        private Widget(String string){
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}
