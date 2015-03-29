package org.uva.student.calinwouter.qlqls.qls.model;

import java.util.Set;

/**
 * This model is used for storing the type checker's results.
 */
public class QLSTypeCheckResults {
    private final Set<String> undefinedReferences;
    private final Set<String> unusedQLFieldsInQLS;
    private final Set<String> invalidWidgetAssignments;
    private final Set<WidgetType> invalidDefaultWidgetAssignments;
    private final Set<String> duplicateFieldUsages;

    public boolean hasUndefinedReferences() {
        return undefinedReferences.size() > 0;
    }

    public boolean hasUnusedQLFieldsInQLS() {
        return unusedQLFieldsInQLS.size() > 0;
    }

    public boolean hasInvalidWidgetAssignments() {
        return invalidWidgetAssignments.size() > 0;
    }

    public boolean hasInvalidDefaultWidgetAssignments() {
        return invalidDefaultWidgetAssignments.size() > 0;
    }

    public boolean hasDuplicateFieldUsages() {
        return duplicateFieldUsages.size() > 0;
    }

    public boolean hasErrors() {
        return hasUndefinedReferences()
                && hasUnusedQLFieldsInQLS()
                && hasInvalidWidgetAssignments()
                && hasInvalidDefaultWidgetAssignments()
                && hasDuplicateFieldUsages();
    }

    public QLSTypeCheckResults(Set<String> undefinedReferences, Set<String> unusedQLFieldsInQLS,
                               Set<String> invalidWidgetAssignments, Set<WidgetType> invalidDefaultWidgetAssignments,
                               Set<String> duplicateFieldUsages) {
        this.undefinedReferences = undefinedReferences;
        this.unusedQLFieldsInQLS = unusedQLFieldsInQLS;
        this.invalidWidgetAssignments = invalidWidgetAssignments;
        this.invalidDefaultWidgetAssignments = invalidDefaultWidgetAssignments;
        this.duplicateFieldUsages = duplicateFieldUsages;
    }

    private boolean appendStrings(StringBuilder stringBuilder, Set<String> strings) {
        for (String s : strings) {
            stringBuilder.append("- ");
            stringBuilder.append(s);
            stringBuilder.append("\n");
        }
        return strings.size() > 0;
    }

    private boolean appendWidgetTypesAsStrings(StringBuilder stringBuilder, Set<WidgetType> widgetTypes) {
        for (WidgetType widgetType : widgetTypes) {
            final String error = widgetType.asAssignmentError();
            stringBuilder.append("- ");
            stringBuilder.append(error);
            stringBuilder.append("\n");
        }
        return widgetTypes.size() > 0;
    }

    private void sayNoneIfNotAppended(StringBuilder stringBuilder, boolean hasAppended) {
        if (!hasAppended) {
            stringBuilder.append("- None!\n");
        }
    }

    private void appendUndefinedReferences(StringBuilder stringBuilder) {
        stringBuilder.append("Undefined reference errors:\n");
        final boolean hasAppended = appendStrings(stringBuilder, undefinedReferences);
        sayNoneIfNotAppended(stringBuilder, hasAppended);
        stringBuilder.append("\n");
    }

    private void appendUnusedQLFieldsInQLS(StringBuilder stringBuilder) {
        stringBuilder.append("Undefined ql fields in qls errors:\n");
        final boolean hasAppended = appendStrings(stringBuilder, unusedQLFieldsInQLS);
        sayNoneIfNotAppended(stringBuilder, hasAppended);
        stringBuilder.append("\n");
    }

    private void appendInvalidWidgetAssignments(StringBuilder stringBuilder) {
        stringBuilder.append("Invalid widget assignment errors:\n");
        final boolean hasAppended = appendStrings(stringBuilder, invalidWidgetAssignments);
        sayNoneIfNotAppended(stringBuilder, hasAppended);
        stringBuilder.append("\n");
    }

    private void appendInvalidDefaultWidgetAssignments(StringBuilder stringBuilder) {
        stringBuilder.append("Invalid default widget assignment errors:\n");
        final boolean hasAppended = appendWidgetTypesAsStrings(stringBuilder, invalidDefaultWidgetAssignments);
        sayNoneIfNotAppended(stringBuilder, hasAppended);
        stringBuilder.append("\n");
    }

    private void appendDuplicateFieldUsages(StringBuilder stringBuilder) {
        stringBuilder.append("Duplicate field usages:\n");
        final boolean hasAppended = appendStrings(stringBuilder, duplicateFieldUsages);
        sayNoneIfNotAppended(stringBuilder, hasAppended);
        stringBuilder.append("\n");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        appendUndefinedReferences(stringBuilder);
        appendUnusedQLFieldsInQLS(stringBuilder);
        appendInvalidWidgetAssignments(stringBuilder);
        appendInvalidDefaultWidgetAssignments(stringBuilder);
        appendDuplicateFieldUsages(stringBuilder);
        return stringBuilder.toString();
    }
}
