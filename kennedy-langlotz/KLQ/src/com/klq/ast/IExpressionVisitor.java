package com.klq.ast;

import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.literal.DateNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.literal.StringNode;
import com.klq.ast.impl.expr.math.*;

/**
 * Created by juriaan on 2-3-15.
 */
public interface IExpressionVisitor<T> extends IVisitor {
    @Override
    public T visit(StringNode node);
    @Override
    public T visit(NumberNode node);
    @Override
    public T visit(DateNode node);
    @Override
    public T visit(IdentifierNode node);
    @Override
    public T visit(ANode node);
    @Override
    public T visit(MultiplyNode node);
    @Override
    public T visit(DivideNode node);
    @Override
    public T visit(AddNode node);
    @Override
    public T visit(SubtractNode node);
    @Override
    public T visit(GreaterThanNode node);
    @Override
    public T visit(GreaterEqualsNode node);
    @Override
    public T visit(LessThanNode node);
    @Override
    public T visit(LessEqualsNode node);
    @Override
    public T visit(EqualsNode node);
    @Override
    public T visit(NotEqualsNode node);
    @Override
    public T visit(AndNode node);
    @Override
    public T visit(OrNode node);
}
