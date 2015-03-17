package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSTypeCheckResults;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetType;
import org.uva.student.calinwouter.qlqls.qls.model.components.Defaults;
import org.uva.student.calinwouter.qlqls.qls.model.components.Page;
import org.uva.student.calinwouter.qlqls.qls.model.components.Section;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

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
    private List<Defaults> collectDefaults(StyleSheet styleSheet) {
        final List<Defaults> collectedDefaults = new LinkedList<Defaults>();
        for (final Page p : styleSheet.getPages()) {
            for (final Section s : p.getSections()) {
                collectedDefaults.add(s.getDefaults());
            }
            collectedDefaults.add(p.getDefaults());
        }
        collectedDefaults.add(styleSheet.getDefaults());
        return collectedDefaults;
    }

    private List<String> collectFields(StyleSheet styleSheet) {
        final List<String> collectedFields = new LinkedList<String>();
        for (final Page p : styleSheet.getPages()) {
            for (final Section s : p.getSections()) {
                for (AbstractFormField abstractFormField : s.getFields()) {
                    collectedFields.add(abstractFormField.getIdent());
                }
            }
        }
        return collectedFields;
    }

    private Set<String> detectDuplicates(List<String> fields) {
        final Set<String> foundFields = new HashSet<String>();
        final Set<String> duplicateFields = new HashSet<String>();
        for (final String s : fields) {
            if (!foundFields.add(s)) {
                duplicateFields.add(s);
            }
        }
        return duplicateFields;
    }

    private Set<String> detectUndefinedReferences(List<FieldType> fieldTypes, List<String> fields) {
        final Set<String> undefinedReferences = new HashSet<String>();
        final Set<String> qlFields = new HashSet<String>();
        for (final FieldType fieldType : fieldTypes) {
            qlFields.add(fieldType.getFieldName());
        }
        for (final String s : fields) {
            if (!qlFields.contains(s)) {
                undefinedReferences.add(s);
            }
        }
        return undefinedReferences;
    }

    /**
     * Detects invalid widget assignments (e.g. boolean to textbox) or no widget assignments at all.
     */
    private Set<String> detectInvalidWidgetAssignments(StyleSheet styleSheet, List<FieldType> fieldTypes) {
        final Set<String> invalidWidgetAssignments = new HashSet<String>();
        for (final FieldType fieldType : fieldTypes) {
            try {
                AbstractWidget abstractWidget = styleSheet.
                        getStylingSettings(fieldType.getFieldName(), fieldType.getTypeDescriptor()).getWidget();
                if (!fieldType.getTypeDescriptor().isAllowed(abstractWidget)) {
                    invalidWidgetAssignments.add(fieldType.getFieldName());
                }
            } catch(FieldNotFoundException e) {
                invalidWidgetAssignments.add(fieldType.getFieldName());
            }
        }
        return invalidWidgetAssignments;
    }

    private Set<WidgetType> detectInvalidDefaultWidgetAssignments(StyleSheet styleSheet) {
        final Set<WidgetType> invalidDefaultWidgetAssignments = new HashSet<WidgetType>();
        for (final Defaults defaults : collectDefaults(styleSheet)) {
            invalidDefaultWidgetAssignments.addAll(
                    detectInvalidDefaultWidgetAssignments(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR, defaults));
            invalidDefaultWidgetAssignments.addAll(
                    detectInvalidDefaultWidgetAssignments(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR, defaults));
            invalidDefaultWidgetAssignments.addAll(
                    detectInvalidDefaultWidgetAssignments(StringValue.STRING_VALUE_TYPE_DESCRIPTOR, defaults));
        }
        return invalidDefaultWidgetAssignments;
    }

    private Set<WidgetType> detectInvalidDefaultWidgetAssignments(final TypeDescriptor valueTypeDescriptor,
                                                              final Defaults defaults) {
        final Set<WidgetType> invalidDefaultWidgetAssignments = new HashSet<WidgetType>();
        final AbstractWidget widget = (AbstractWidget) defaults.getDefaultStyleSheetSettings().get(valueTypeDescriptor).get("widget");
        if (!valueTypeDescriptor.isAllowed(widget)) {
            invalidDefaultWidgetAssignments.add(new WidgetType(widget, valueTypeDescriptor));
        }
        return invalidDefaultWidgetAssignments;
    }

    private Set<String> detectMissingQLFieldsInQLS(List<FieldType> fieldTypes, List<String> fields) {
        Set<String> missingQLFieldsInQLS = new HashSet<String>();
        for (FieldType fieldType : fieldTypes) {
            if (!fields.contains(fieldType.getFieldName())) {
                missingQLFieldsInQLS.add(fieldType.getFieldName());
            }
        }
        return missingQLFieldsInQLS;
    }

    /**
     * Perform five different style checks on the provided stylesheet.
     */
    public QLSTypeCheckResults typeCheck(StyleSheet styleSheet, List<FieldType> fieldTypes) {
        List<String> fields = collectFields(styleSheet);
        return new QLSTypeCheckResults(
                detectUndefinedReferences(fieldTypes, fields),
                detectMissingQLFieldsInQLS(fieldTypes, fields),
                detectInvalidWidgetAssignments(styleSheet, fieldTypes),
                detectInvalidDefaultWidgetAssignments(styleSheet),
                detectDuplicates(fields));
    }
}
