package com.kls.logic.properties;

/**
 * Created by Juriaan on 14-3-2015.
 */
public class FontColor extends AProperty {
    private String value;

    public FontColor(String value){
        super("color");
        this.value = value;
    }

    @Override
    public String toCSS() {
        return String.format("%s: %s;", getPropertyName(), value);
    }
}
