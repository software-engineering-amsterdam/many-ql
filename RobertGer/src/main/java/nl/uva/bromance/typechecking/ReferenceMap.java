package nl.uva.bromance.typechecking;

import nl.uva.bromance.AST.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Robert on 2/22/2015.
 */
public class ReferenceMap extends HashMap<String, Node> {

    public <T extends Node> List<T> findNodeOfType(Class<T> clazz) {
        List<T> list = new ArrayList<>();
        for (Node value : values()) {
            if (value.getClass().equals(clazz)) {
                list.add((T) value);
            }
        }
        return list;
    }
}
