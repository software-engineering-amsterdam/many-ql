using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using Binary = AST.Nodes.Expressions.Binary;
using Label = AST.Nodes.Labels;
using Unary = AST.Nodes.Expressions.Unary;
using Values = AST.Nodes.Literals;

namespace AST.ASTVisitors
{
    public interface IVisitor<T>
    {
        T Visit(Form node);
        T Visit(Question question);
        T Visit(Conditional conditional);

        T Visit(Binary.And node);
        T Visit(Binary.Or node);
        T Visit(Binary.Equal node);
        T Visit(Binary.NotEqual node);
        T Visit(Binary.GreaterThan greaterThan);
        T Visit(Binary.GreaterThanOrEqual greaterThanOrEqual);
        T Visit(Binary.LessThan lessThan);
        T Visit(Binary.LessThanOrEqual lessThanOrEqual);
        T Visit(Binary.Add add);
        T Visit(Binary.Subtract subtract);
        T Visit(Binary.Multiply multiply);
        T Visit(Binary.Divide divide);

        T Visit(Unary.Negate node);
        T Visit(Unary.Priority priority);

        T Visit(Id node);

        //Values
        T Visit(Values.Bool node);
        T Visit(Values.Int node);
        T Visit(Values.String node);

    }
}
