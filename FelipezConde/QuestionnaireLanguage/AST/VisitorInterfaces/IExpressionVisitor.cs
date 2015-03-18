using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;
using AST.Nodes.Literals;

namespace AST.VisitorInterfaces
{
    public interface IExpressionVisitor<T>
    {
        T Visit(Id node);
        T Visit(And node);
        T Visit(Or node);
        T Visit(Equal node);
        T Visit(NotEqual node);
        T Visit(GreaterThan greaterThan);
        T Visit(GreaterThanOrEqual greaterThanOrEqual);
        T Visit(LessThan lessThan);
        T Visit(LessThanOrEqual lessThanOrEqual);
        T Visit(Add add);
        T Visit(Subtract subtract);
        T Visit(Multiply multiply);
        T Visit(Divide divide);

        T Visit(Negate node);
        T Visit(Priority priority);

        T Visit(Bool node);
        T Visit(Int node);
        T Visit(AST.Nodes.Literals.String node);

    }
}
