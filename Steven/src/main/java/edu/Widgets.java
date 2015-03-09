package edu;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Steven Kok on 02/03/2015.
 */
public enum Widgets {

    SLIDER("SLIDER"), SPINBOX("SPINBOX"), TEXT("TEXT"), YESNO_RADIO("YESNORADIO"), CHECKBOX("CHECKBOX"), YESNO_DROPDOWN("YESNODROPDOWN");

    private final String widget;

    Widgets(String widget) {
        this.widget = widget;
    }

    public String getWidget() {
        return widget;
    }

    public static Widgets getWidget(String widget) throws InvalidArgumentException {
        for (Widgets widgets : values()) {
            if (widgets.getWidget().equals(widget)) {
                return widgets;
            }
        }
        throw new InvalidArgumentException(new String[]{"Unknown Widget for input: " + widget});
    }
}
