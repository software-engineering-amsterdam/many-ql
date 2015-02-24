package lang.ql.ast;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.*;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.TypeVisitor;

/**
 * Created by bore on 13/02/15.
 */
public interface AstVisitor<T> extends StatVisitor<T>, ExprVisitor<T>, FormVisitor<T>, TypeVisitor<T>
{

}
