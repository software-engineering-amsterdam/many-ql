package nl.uva.softwcons.qls.ast.style;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.qls.ast.ASTNode;

public class Style implements ASTNode {
    private final Map<String, String> properties;
    private final LineInfo lineInfo;

    public Style(final LineInfo lineInfo) {
        this.lineInfo = lineInfo;
        this.properties = new HashMap<String, String>();
    }

    public Style(final Map<String, String> properties, final LineInfo lineInfo) {
        this.lineInfo = lineInfo;
        this.properties = properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }
}
