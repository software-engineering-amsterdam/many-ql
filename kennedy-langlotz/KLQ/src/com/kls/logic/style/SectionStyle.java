package com.kls.logic.style;

/**
 * Created by Juriaan on 14-3-2015.
 */
public class SectionStyle extends AStyle {
    @Override
    public void merge(PageStyle style) {
        overrideMerge(style, false);
    }

    @Override
    public void merge(SectionStyle style) {
        overrideMerge(style, false);
    }

    @Override
    public void merge(QuestionStyle style) {
        overrideMerge(style, true);
    }
}
