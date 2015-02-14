package org.uva.student.calinwouter.ql.interpreter.components;

/**
 * This interface provides callback methods for specific types.
 */
public interface TypeCallback<T> {

    void usesBoolean();

    void usesInteger();

    void usesString();

}
