package org.uva.student.calinwouter.qlqls.qls.abstractions;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IModel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// TODO check if invoking this model fails the interpreter.

/**
 * Models are used for representing the internal state of a QLS interpretation.
 *
 * The models are instantiated using the apply-functions.
 */
public abstract class AbstractModel {

    /**
     * Get the list of all the fields this model (and child models) uses on QL, and their widget types.
     * @return the list of all the fields this model (and child models) uses on QL, and their widget types.
     */
    public List<FieldWidget> getFieldUses() {
        return new LinkedList<FieldWidget>();
    }

    public abstract void apply(IModel iModel);
}
