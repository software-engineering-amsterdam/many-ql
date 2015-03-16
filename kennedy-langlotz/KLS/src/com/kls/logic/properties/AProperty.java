package com.kls.logic.properties;

/**
 * Created by Juriaan on 14-3-2015.
 */
public abstract class AProperty {
    private String name;

    public AProperty(String name){
        this.name = name;
    }

    public abstract String toCSS();

    public String getPropertyName(){
        return name;
    }
}
