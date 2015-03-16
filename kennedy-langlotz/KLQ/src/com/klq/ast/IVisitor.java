package com.klq.ast;

import com.klq.ast.impl.stmt.ComputedQuestionNode;
import com.klq.ast.impl.stmt.ConditionalNode;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.literal.DateNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.literal.StringNode;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;

/**
 * Created by juriaan on 10-2-15.
 */
public interface IVisitor<T> {
}
