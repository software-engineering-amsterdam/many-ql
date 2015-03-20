package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Pages implements Iterable<Page> {
    private final List<Page> pages;

    public Pages(Page... pages) {
        this.pages = Arrays.asList(pages);
    }

    @Override
    public Iterator<Page> iterator() {
        return pages.iterator();
    }
}
