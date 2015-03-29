package nl.uva.softwcons.qls.ast.style;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.qls.ast.ASTNode;

public class Style implements ASTNode {
    private final Map<String, String> properties;

    public Style() {
        properties = new HashMap<String, String>();
    }

    public Style(final Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void addProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public Style inherit(final Style parentStyle) {
        Style mergedStyle = new Style(this.properties);
        parentStyle.getProperties().forEach((key, value) -> {
            if (!properties.containsKey(key)) {
                mergedStyle.addProperty(key, value);
            }
        });
        return mergedStyle;
    }
}
