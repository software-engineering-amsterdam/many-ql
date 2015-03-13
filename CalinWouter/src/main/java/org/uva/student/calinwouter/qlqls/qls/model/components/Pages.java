package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Pages {
    private final List<Page> pages;

    public Pages(Page... pages) {
        this.pages = Arrays.asList(pages);
    }
}
