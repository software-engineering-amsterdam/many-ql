package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
public class Pages {
    private final List<Page> pages;

    public Pages(Page... pages) {
        this.pages = Arrays.asList(pages);
    }

    public List<FieldWidget> collectFieldWidgets() {
        List<FieldWidget> fieldWidgets = new LinkedList<FieldWidget>();
        for (Page page : pages) {
            fieldWidgets.addAll(page.collectFieldWidgets());
        }
        return fieldWidgets;
    }
}
