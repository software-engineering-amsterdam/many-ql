using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using Binary = AST.Nodes.Expression.Binary;
using Label = AST.Nodes.Labels;
using Unary = AST.Nodes.Expression.Unary;
using Values = AST.Nodes.Literals;

namespace AST.Visitors
{
    public interface IVisitor<T>
    {
        T Visit(Form node);
        T Visit(IASTNode node);
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


        T Visit(Container node);
        T Visit(Id node);


        //Values
        T Visit(Values.Bool node);
        T Visit(Values.Int node);
        T Visit(Values.String node);


        //Label
        T Visit(Label.Label node);

        T Visit(Nodes.Interfaces.IBinary binaryExpression);
        T Visit(Nodes.Interfaces.IUnary unaryExpression);
        T Visit(Values.Undefined undefined);

    }
}
