package com.kls.logic.style;

import com.kls.logic.properties.AProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Juriaan on 14-3-2015.
 */
public abstract class AStyle {
    private Map<String, AProperty> properties;

    public AStyle(){
        properties = new HashMap<String, AProperty>();
    }

    public void addProperty(AProperty property){
        properties.put(property.getPropertyName(), property);
    }

    public abstract void merge(PageStyle style);
    public abstract void merge(SectionStyle style);
    public abstract void merge(QuestionStyle style);

    public void overrideMerge(AStyle style, boolean override){
        for(AProperty property : style.getProperties().values()){
            if(!override && !properties.containsKey(property.getPropertyName())) {
                properties.put(property.getPropertyName(), property);
            }
        }
    }

    public Map<String, AProperty> getProperties() {
        return properties;
    }

    public String toCSS(){
        String css = "";
        for(AProperty property : properties.values()){
            css = css.concat(property.toCSS());
        }

        return css;
    }
}
