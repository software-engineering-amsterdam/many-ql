package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractPushable;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class QLSTypeChecker extends QLSInterpreter {
    private LinkedList<String> fieldUses;
    private LinkedList<String> illegalWidgetUsages;

    @Override
    public AbstractModel<?> interopComponent(String componentName, List<AbstractPushable<?>> args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        AbstractModel model = super.interopComponent(componentName, args);
        fieldUses.addAll(model.getFieldUses());
        illegalWidgetUsages.addAll(model.getIllegalWidgetUsages()); // TODO
        return model;
    }

    public Set<String> getUnallowedFieldReferences(List<String> allowedFieldReferences) {
        LinkedHashSet<String> unallowedFieldReferences = new LinkedHashSet<String>();
        for (String s : fieldUses) {
            if (!allowedFieldReferences.contains(s)) {
                unallowedFieldReferences.add(s);
            }
        }
        return unallowedFieldReferences;
    }

    public Set<String> getUnreferencedFields(List<String> fieldsToBeUsed) {
        LinkedHashSet<String> unferencedFields = new LinkedHashSet<String>();
        for (String s : fieldsToBeUsed) {
            if (!fieldUses.contains(s)) {
                unferencedFields.add(s);
            }
        }
        return unferencedFields;
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