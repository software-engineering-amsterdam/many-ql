package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractPushable;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class QLSTypeChecker extends QLSInterpreter {
    private LinkedList<String> fieldUses = new LinkedList<String>();

    @Override
    public AbstractModel<?> interopComponent(String componentName, List<AbstractPushable<?>> args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        AbstractModel model = super.interopComponent(componentName, args);
        fieldUses.addAll(model.getFieldUses());
        return model;
    }

    public Set<String> getUnallowedWidgetsTypes(Set<Map.Entry<String, TypeDescriptor<?>>> fieldToTypeTuples) {
        HashSet<String> unallowedWidgetsTypes = new HashSet<String>();
        for (Map.Entry<String, TypeDescriptor<?>> tuple : fieldToTypeTuples) {
            try {
                if (fieldToWidgetMap.get(tuple.getKey()) != null) {
                    tuple.getValue().callTypeMethod(fieldToWidgetMap.get(tuple.getKey()));
                }
            } catch (UnsupportedOperationException e) {
                unallowedWidgetsTypes.add(tuple.getKey());
            }
        }
        return unallowedWidgetsTypes;
    }

    public Set<String> getUnallowedFieldReferences(Set<String> allowedFieldReferences) {
        LinkedHashSet<String> unallowedFieldReferences = new LinkedHashSet<String>();
        for (String s : fieldUses) {
            if (!allowedFieldReferences.contains(s)) {
                unallowedFieldReferences.add(s);
            }
        }
        return unallowedFieldReferences;
    }

    public Set<String> getUnreferencedFields(Set<String> fieldsToBeUsed) {
        LinkedHashSet<String> unreferencedFields = new LinkedHashSet<String>();
        for (String s : fieldsToBeUsed) {
            if (!fieldUses.contains(s)) {
                unreferencedFields.add(s);
            }
        }
        return unreferencedFields;
    }

    public Set<String> getFieldUsedMultipleTimes() {
        LinkedHashSet<String> duplicates = new LinkedHashSet<String>();
        LinkedHashSet<String> copySet = new LinkedHashSet<String>();
        for (String s : fieldUses) {
            if (!copySet.add(s)) {
                duplicates.add(s);
            }
        }
        return duplicates;
    }

}