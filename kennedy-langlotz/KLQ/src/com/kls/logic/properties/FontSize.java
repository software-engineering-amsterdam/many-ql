package com.kls.logic.properties;

/**
 * Created by Juriaan on 14-3-2015.
 */
public class FontSize extends AProperty {
    private Integer value;

    public FontSize(Integer value){
        super("font-size");
        this.value = value;
    }

    @Override
    public String toCSS() {
        return String.format("%s: %s;", getPropertyName(), value);
    }
}
