package com.klq.ast;

import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.literal.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;

/**
 * Created by juriaan on 2-3-15.
 */
public interface IExpressionVisitor<T>{
    public T visit(StringNode node);
    public T visit(NumberNode node);
    public T visit(DateNode node);
    public T visit(BooleanNode node);
    public T visit(IdentifierNode node);
    public T visit(MultiplyNode node);
    public T visit(DivideNode node);
    public T visit(AddNode node);
    public T visit(SubtractNode node);
    public T visit(GreaterThanNode node);
    public T visit(GreaterEqualsNode node);
    public T visit(LessThanNode node);
    public T visit(LessEqualsNode node);
    public T visit(EqualsNode node);
    public T visit(NotEqualsNode node);
    public T visit(AndNode node);
    public T visit(OrNode node);
}
