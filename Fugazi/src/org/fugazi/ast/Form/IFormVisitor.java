package org.fugazi.ast.Form;

/**
 * Generic Visitor interface for Form.
 * @param <T>
 */
public interface IFormVisitor<T> {
    
    T visit(Form form);
}