package org.uva.student.calinwouter.qlqls.qls.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * This model is used for storing the type checker's results.
 */
@Data
@AllArgsConstructor
public class QLSTypeCheckResults {
    private final Set<String> undefinedReferences;
    private final Set<String> unusedQLFieldsInQLS;
    private final Set<String> invalidWidgetAssignments;
    private final Set<WidgetType> invalidDefaultWidgetAssignments;
    private final Set<String> duplicateFieldUsages;
}
