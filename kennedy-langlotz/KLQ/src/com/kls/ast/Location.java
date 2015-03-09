package com.kls.ast;

import java.net.URI;

/**
 * Created by Timon on 03.03.2015.
 */
public class Location {
    private final String file;
    private final int offset;
    private final int length;
    private final int beginLine;
    private final int beginColumn;
    private final int endLine;
    private final int endColumn;

    public Location(String file, int offset, int length, int beginLine, int beginColumn, int endLine, int endColumn) {
        this.file = file;
        this.offset = offset;
        this.length = length;
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public String getFile() {
        return file;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    public int getBeginLine() {
        return beginLine;
    }

    public int getBeginColumn() {
        return beginColumn;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getEndColumn() {
        return endColumn;
    }
}
