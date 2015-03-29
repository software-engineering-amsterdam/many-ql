package nl.uva.softwcons.qls.ast.style;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.qls.ast.ASTNode;

public class Style implements ASTNode {
    private final Map<String, String> properties;

    public Style() {
        properties = new HashMap<String, String>();
    }

    public Style(final Map<String, String> properties) {
        this.properties = properties;
    }

    public void addProperty(final String key, final String value) {
        this.properties.put(key, value);
    }

    public Style inherit(final Style parentStyle) {
        final Style mergedStyle = new Style(this.properties);
        parentStyle.properties.forEach((key, value) -> {
            if (!properties.containsKey(key)) {
                mergedStyle.addProperty(key, value);
            }
        });

        return mergedStyle;
    }

    @Override
    public LineInfo getLineInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    public String asString() {
        StringBuilder builder = new StringBuilder();
        this.properties.forEach((key, value) -> {
            builder.append("-fx-" + key + ": " + value + ";\n");
        });
        return builder.toString();
    }
}
