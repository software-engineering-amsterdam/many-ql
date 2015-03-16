package com.kls.logic;

import com.kls.logic.style.AStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Juriaan on 14-3-2015.
 */
public class StyleMap {
    //TODO rethink this class
    private Map<String, AStyle> pageStyle;
    private Map<String, AStyle> sectionStyle;
    private Map<String, AStyle> questionStyle;

    public StyleMap(){
        pageStyle = new HashMap<String, AStyle>();
        sectionStyle = new HashMap<String, AStyle>();
        questionStyle = new HashMap<String, AStyle>();
    }

    public void addPageStyle(String identifier, AStyle AStyle){
        pageStyle.put(identifier, AStyle);
    }

    public void addSectionStyle(String identifier, AStyle AStyle){
        sectionStyle.put(identifier, AStyle);
    }

    public void addQuestionStyle(String identifier, AStyle AStyle){
        questionStyle.put(identifier, AStyle);
    }

    public AStyle getStyle(String identifier){
        return pageStyle.get(identifier);
    }

    public boolean contains(String identifier){
        return pageStyle.containsKey(identifier);
    }
}
