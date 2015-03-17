package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

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
    // TODO looks pretty bad...
    public StylingSettings getStylingSettings(String identifier, TypeDescriptor type) {
        for (Page page : getPages()) {
            Map<String, Object> resultPage = new HashMap<String, Object>();
            Map<String, Object> o = page.getDefaults().getDefaultStyleSheetSettings().get(type);
            if (o != null) {
                resultPage.putAll(o);
            }
            for (Section section : page.getSections()) {
                Map<String, Object> resultSection = new HashMap<String, Object>(resultPage);
                o = section.getDefaults().getDefaultStyleSheetSettings().get(type);
                if (o != null) {
                    resultSection.putAll(o);
                }
                for (AbstractFormField abstractFormField : section.getFields()) {
                    if (abstractFormField.getIdent().equals(identifier)) {
                        Map<String, Object> resultField = new HashMap<String, Object>(resultSection);
                        o = abstractFormField.getStylingArguments();
                        if (o != null) {
                            resultField.putAll(o);
                        }
                        return new StylingSettings(type, resultField);
                    }
                }
            }
        }
        throw new FieldNotFoundException(identifier);
    }

    @SuppressWarnings("unused")
    public StyleSheet(String ident, Page... pages) {
        this(ident, new Pages(pages), new Defaults(new HashMap<TypeDescriptor, Map<String, Object>>()));
    }
}
