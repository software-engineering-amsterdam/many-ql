package edu.parser;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public interface AbstractNode<T> {

    public AbstractNode accept(T visitor);
}

