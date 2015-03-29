package nl.uva.softwcons.qls.ui.style;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.qls.ast.style.Style;

public class StyleBlock {

    private final Map<String, String> properties;

    public StyleBlock() {
        this.properties = new HashMap<String, String>();
    }

    public StyleBlock(final Map<String, String> properties) {
        this.properties = properties;
    }

    public StyleBlock(final Style style) {
        this.properties = new HashMap<String, String>(style.getProperties());
    }

    public void addProperty(final String key, final String value) {
        this.properties.put(key, value);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public StyleBlock inherit(final StyleBlock parentStyle) {
        final StyleBlock mergedStyle = new StyleBlock(this.properties);
        parentStyle.getProperties().forEach((key, value) -> {
            if (!properties.containsKey(key)) {
                mergedStyle.addProperty(key, value);
            }
        });

        return mergedStyle;
    }

    public String asString() {
        final StringBuilder builder = new StringBuilder();
        this.properties.forEach((key, value) -> {
            builder.append("-fx-" + key + ": " + value + ";\n");
        });
        return builder.toString();
    }

}
