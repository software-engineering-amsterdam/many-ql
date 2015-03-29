package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSTypeCheckResults;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetType;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Defaults;
import org.uva.student.calinwouter.qlqls.qls.model.functions.StyleSheet;

import java.util.*;

/**
 * This TypeChecker checks if:
 *
 * - No references are made to questions that are not in the QL program
 * - All questions of the QL program are placed by the QLS program.
 * - (Default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
 * - There are no field duplications in QLS.
 */
public class QLSTypeChecker {
    private final List<String> fields;
    private final StyleSheet styleSheet;
    private final List<FieldType> fieldTypes;
    private final List<Defaults> collectedDefaults;

    private List<Defaults> collectDefaults() {
        return styleSheet.collectAllDefaultsInstances();
    }

    private List<String> collectFields() {
        return styleSheet.collectFields();
    }

    private void addIfDuplicateField(Set<String> foundFields, Set<String> duplicateFields, String testField) {
        if (!foundFields.add(testField)) {
            duplicateFields.add(testField);
        }
    }

    private Set<String> detectDuplicates() {
        final Set<String> foundFields = new HashSet<String>();
        final Set<String> duplicateFields = new HashSet<String>();
        for (final String fieldName : fields) {
            addIfDuplicateField(foundFields, duplicateFields, fieldName);
        }
        return duplicateFields;
    }

    private void addAllFieldNames(Set<String> qlFields) {
        for (final FieldType fieldType : fieldTypes) {
            qlFields.add(fieldType.getFieldName());
        }
    }

    private void addIfNotReferenced(String fieldName, Set<String> qlFields, Set<String> undefinedReferences) {
        if (!qlFields.contains(fieldName)) {
            undefinedReferences.add(fieldName);
        }
    }

    private Set<String> detectUndefinedReferences(Set<String> qlFields) {
        final Set<String> undefinedReferences = new HashSet<String>();
        for (final String fieldName : fields) {
            addIfNotReferenced(fieldName, qlFields, undefinedReferences);
        }
        return undefinedReferences;
    }

    private Set<String> detectUndefinedReferences() {
        final Set<String> qlFields = new HashSet<String>();
        addAllFieldNames(qlFields);
        return detectUndefinedReferences(qlFields);
    }

    private void addIfInvalidWidgetAssignment(Set<String> invalidWidgetAssignments, ITypeDescriptor fieldTypeDescriptor,
                                              AbstractWidget abstractWidget, String fieldName) {
        if (!fieldTypeDescriptor.isAllowed(abstractWidget)) {
            invalidWidgetAssignments.add(fieldName);
        }
    }

    private void detectInvalidWidgetAssignment(FieldType fieldType, Set<String> invalidWidgetAssignments) {
        final String fieldName = fieldType.getFieldName();
        try {
            final StylingSettings stylingSettings = styleSheet.deriveStylingSettings(fieldType);
            final AbstractWidget abstractWidget = stylingSettings.getWidget();
            final ITypeDescriptor fieldTypeDescriptor = fieldType.getTypeDescriptor();
            addIfInvalidWidgetAssignment(invalidWidgetAssignments, fieldTypeDescriptor, abstractWidget, fieldName);
        } catch(FieldNotFoundException e) {
            invalidWidgetAssignments.add(fieldName);
        }
    }

    /**
     * Detects invalid widget assignments (e.g. boolean to textbox) or no widget assignments at all.
     */
    private Set<String> detectInvalidWidgetAssignments() {
        final Set<String> invalidWidgetAssignments = new HashSet<String>();
        for (final FieldType fieldType : fieldTypes) {
            detectInvalidWidgetAssignment(fieldType, invalidWidgetAssignments);
        }
        return invalidWidgetAssignments;
    }

    private void detectInvalidBooleanDefaultWidgetAssignments(
            Set<WidgetType> invalidDefaultWidgetAssignments, Defaults defaults) {
        final Set<WidgetType> invalidBooleanDefaultWidgetAssignments =
                detectInvalidDefaultWidgetAssignments(BooleanValue.BOOL_VALUE_TYPE_DESCRIPTOR, defaults);
        invalidDefaultWidgetAssignments.addAll(invalidBooleanDefaultWidgetAssignments);
    }

    private void detectInvalidIntegerDefaultWidgetAssignments(
            Set<WidgetType> invalidDefaultWidgetAssignments, Defaults defaults) {
        final Set<WidgetType> invalidIntegerDefaultWidgetAssignments =
                detectInvalidDefaultWidgetAssignments(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR, defaults);
        invalidDefaultWidgetAssignments.addAll(invalidIntegerDefaultWidgetAssignments);
    }

    private void detectInvalidStringDefaultWidgetAssignments(
            Set<WidgetType> invalidDefaultWidgetAssignments, Defaults defaults) {
        final Set<WidgetType> invalidStringDefaultWidgetAssignments =
                detectInvalidDefaultWidgetAssignments(StringValue.STRING_VALUE_TYPE_DESCRIPTOR, defaults);
        invalidDefaultWidgetAssignments.addAll(invalidStringDefaultWidgetAssignments);
    }

    private Set<WidgetType> detectInvalidDefaultWidgetAssignments() {
        final Set<WidgetType> invalidDefaultWidgetAssignments = new HashSet<WidgetType>();
        for (final Defaults defaults : collectedDefaults) {
            detectInvalidBooleanDefaultWidgetAssignments(invalidDefaultWidgetAssignments, defaults);
            detectInvalidIntegerDefaultWidgetAssignments(invalidDefaultWidgetAssignments, defaults);
            detectInvalidStringDefaultWidgetAssignments(invalidDefaultWidgetAssignments, defaults);
        }
        return invalidDefaultWidgetAssignments;
    }

    private AbstractWidget getWidgetFromDefaultStyles(Defaults defaults, ITypeDescriptor valueTypeDescriptor) {
        return defaults.getWidget(valueTypeDescriptor);
    }

    private Set<WidgetType> detectInvalidDefaultWidgetAssignments(final ITypeDescriptor valueTypeDescriptor,
                                                              final Defaults defaults) {
        final Set<WidgetType> invalidDefaultWidgetAssignments = new HashSet<WidgetType>();
        final AbstractWidget widget = getWidgetFromDefaultStyles(defaults, valueTypeDescriptor);
        if (!valueTypeDescriptor.isAllowed(widget)) {
            final WidgetType unallowedWidgetType = new WidgetType(widget, valueTypeDescriptor);
            invalidDefaultWidgetAssignments.add(unallowedWidgetType);
        }
        return invalidDefaultWidgetAssignments;
    }

    private void checkMissingQLFieldInQLS(FieldType fieldType, Set<String> missingQLFieldsInQLS) {
        if (!fields.contains(fieldType.getFieldName())) {
            final String fieldTypeName = fieldType.getFieldName();
            missingQLFieldsInQLS.add(fieldTypeName);
        }
    }

    private Set<String> detectMissingQLFieldsInQLS() {
        Set<String> missingQLFieldsInQLS = new HashSet<String>();
        for (FieldType fieldType : fieldTypes) {
            checkMissingQLFieldInQLS(fieldType, missingQLFieldsInQLS);
        }
        return missingQLFieldsInQLS;
    }

    /**
     * Perform five different style checks on the provided stylesheet.
     */
    public QLSTypeCheckResults typeCheck() {
        return new QLSTypeCheckResults(
                detectUndefinedReferences(),
                detectMissingQLFieldsInQLS(),
                detectInvalidWidgetAssignments(),
                detectInvalidDefaultWidgetAssignments(),
                detectDuplicates());
    }

    public QLSTypeChecker(StyleSheet styleSheet, List<FieldType> fieldTypes) {
        this.styleSheet = styleSheet;
        this.fieldTypes = fieldTypes;
        this.fields = collectFields();
        this.collectedDefaults = collectDefaults();
    }
}
