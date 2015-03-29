package org.uva.student.calinwouter.qlqls.qls.model;

import java.util.Set;

/**
 * This model is used for storing the type checker's results.
 */
public class QLSTypeCheckResults {
    // TODO create functions showing the results of the typechecker ...
    private final Set<String> undefinedReferences;
    private final Set<String> unusedQLFieldsInQLS;
    private final Set<String> invalidWidgetAssignments;
    private final Set<WidgetType> invalidDefaultWidgetAssignments;
    private final Set<String> duplicateFieldUsages;

    public QLSTypeCheckResults(Set<String> undefinedReferences, Set<String> unusedQLFieldsInQLS,
                               Set<String> invalidWidgetAssignments, Set<WidgetType> invalidDefaultWidgetAssignments,
                               Set<String> duplicateFieldUsages) {
        this.undefinedReferences = undefinedReferences;
        this.unusedQLFieldsInQLS = unusedQLFieldsInQLS;
        this.invalidWidgetAssignments = invalidWidgetAssignments;
        this.invalidDefaultWidgetAssignments = invalidDefaultWidgetAssignments;
        this.duplicateFieldUsages = duplicateFieldUsages;
    }
}
