package com.kls.logic.style;

/**
 * Created by Juriaan on 14-3-2015.
 */
public class QuestionStyle extends AStyle {
    public void merge(PageStyle style){
        overrideMerge(style, false);
    }

    public void merge(SectionStyle style){
        overrideMerge(style, false);
    }

    public void merge(QuestionStyle style){
        overrideMerge(style, false);
    }
}
