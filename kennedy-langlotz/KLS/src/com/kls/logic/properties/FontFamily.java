package com.kls.logic.properties;

/**
 * Created by Juriaan on 14-3-2015.
 */
public class FontFamily extends AProperty {
    private String value;

    public FontFamily(String value){
        super("-fx-font-family");
        this.value = value;
    }

    @Override
    public String toCSS() {
        return String.format("%s: %s;", getPropertyName(), value);
    }
}
