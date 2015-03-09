package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class StyleSheet {
    private final String styleSheetName;
    private final Pages pages;
    private final Defaults defaults;

    /**
     * Get the styling settings of a widget by overriding their settings in-depth.
     */
    public Map<String, Object> getStylingSettings(String ident, TypeDescriptor type) throws FieldNotFoundException {
        for (Page page : getPages().getPages()) {
            Map<String, Object> resultPage = new HashMap<String, Object>();
            resultPage.putAll(page.getDefaults().getDefaultStyleSheetSettings().get(type));
            for (Section section : page.getSections().getSections()) {
                Map<String, Object> resultSection = new HashMap<String, Object>(resultPage);
                resultSection.putAll(section.getDefaults().getDefaultStyleSheetSettings().get(type));
                for (AbstractFormField abstractFormField : section.getFields().getFields()) {
                    if (abstractFormField.getIdent().equals(ident)) {
                        Map<String, Object> resultField = new HashMap<String, Object>(resultSection);
                        resultField.putAll(abstractFormField.getStylingArguments());
                        return resultField;
                    }
                }
            }
        }
        throw new FieldNotFoundException();
    }

    @SuppressWarnings("unused")
    public StyleSheet(String ident, Page... pages) {
        this(ident, new Pages(pages), new Defaults(new HashMap<TypeDescriptor, Map<String, Object>>()));
    }
}
