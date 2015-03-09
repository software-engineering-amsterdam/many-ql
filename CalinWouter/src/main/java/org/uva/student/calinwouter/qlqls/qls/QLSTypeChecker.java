package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
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
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

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
        List<Defaults> collectedDefaults = new LinkedList<Defaults>();
        for (Page p : styleSheet.getPages().getPages()) {
            for (Section s : p.getSections().getSections()) {
                collectedDefaults.add(s.getDefaults());
            }
            collectedDefaults.add(p.getDefaults());
        }
        collectedDefaults.add(styleSheet.getDefaults());
        return collectedDefaults;
    }

    private List<String> collectFields(StyleSheet styleSheet) {
        List<String> collectedFields = new LinkedList<String>();
        for (Page p : styleSheet.getPages().getPages()) {
            for (Section s : p.getSections().getSections()) {
                for (AbstractFormField abstractFormField : s.getFields().getFields()) {
                    collectedFields.add(abstractFormField.getIdent());
                }
            }
        }
        return collectedFields;
    }

    private Set<String> detectDuplicates(final StyleSheet styleSheet, List<String> fields) {
        Set<String> foundFields = new HashSet<String>();
        Set<String> duplicateFields = new HashSet<String>();
        for (String s : fields) {
            if (!foundFields.add(s)) {
                duplicateFields.add(s);
            }
        }
        return duplicateFields;
    }

    private Set<String> detectUndefinedReferences(StyleSheet styleSheet, List<FieldType> fieldTypes, List<String> fields) {
        Set<String> undefinedReferences = new HashSet<String>();
        Set<String> qlFields = new HashSet<String>();
        for (FieldType fieldType : fieldTypes) {
            qlFields.add(fieldType.getFieldName());
        }
        for (String s : fields) {
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
        Set<String> invalidWidgetAssignments = new HashSet<String>();
        for (FieldType fieldType : fieldTypes) {
            try {
                AbstractWidget abstractWidget = (AbstractWidget) styleSheet.
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
        Set<WidgetType> invalidDefaultWidgetAssignments = new HashSet<WidgetType>();
        for (Defaults defaults : collectDefaults(styleSheet)) {
            invalidDefaultWidgetAssignments.addAll(
                    detectInvalidDefaultWidgetAssignments(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR, defaults));
            invalidDefaultWidgetAssignments.addAll(
                    detectInvalidDefaultWidgetAssignments(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR, defaults));
            invalidDefaultWidgetAssignments.addAll(
                    detectInvalidDefaultWidgetAssignments(StringValue.STRING_VALUE_TYPE_DESCRIPTOR, defaults));
        }
        return invalidDefaultWidgetAssignments;
    }

    private Set<WidgetType> detectInvalidDefaultWidgetAssignments(final TypeDescriptor<?> valueTypeDescriptor,
                                                              final Defaults defaults) {
        Set<WidgetType> invalidDefaultWidgetAssignments = new HashSet<WidgetType>();
        AbstractWidget widget = (AbstractWidget) defaults.getDefaultStyleSheetSettings().get(valueTypeDescriptor).get("widget");
        if (!valueTypeDescriptor.isAllowed(widget)) {
            invalidDefaultWidgetAssignments.add(new WidgetType(widget, valueTypeDescriptor));
        }
        return invalidDefaultWidgetAssignments;
    }

    private Set<String> detectMissingQLFieldsInQLS(StyleSheet styleSheet, List<FieldType> fieldTypes, List<String> fields) {
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
                detectUndefinedReferences(styleSheet, fieldTypes, fields),
                detectMissingQLFieldsInQLS(styleSheet, fieldTypes, fields),
                detectInvalidWidgetAssignments(styleSheet, fieldTypes),
                detectInvalidDefaultWidgetAssignments(styleSheet),
                detectDuplicates(styleSheet, fields));
    }
}
