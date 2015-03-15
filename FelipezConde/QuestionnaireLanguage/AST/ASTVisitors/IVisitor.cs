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
    public interface IVisitor
    {
        void Visit(Form node);
        void Visit(Conditional conditional);
        void Visit(Question question);
        void Visit(IASTNode node);


        void Visit(Binary.And node);
        void Visit(Binary.Or node);
        void Visit(Binary.Equal node);
        void Visit(Binary.NotEqual node);
        void Visit(Binary.GreaterThan greaterThan);


        void Visit(Unary.Negate node);
        void Visit(Unary.Priority priority);

        
        void Visit(Container node);
        void Visit(Id node);


        //Values
        void Visit(Values.Bool node);
        void Visit(Values.Int node);
        void Visit(Values.String node);


        //Label
        void Visit(Label.Label node);
        void Visit(Binary.GreaterThanOrEqual greaterThanOrEqual);
        void Visit(Binary.LessThan lessThan);
        void Visit(Binary.LessThanOrEqual lessThanOrEqual);
        void Visit(Binary.Add add);
        void Visit(Binary.Divide divide);
        void Visit(Binary.Multiply multiply);
        void Visit(Binary.Subtract subtract);
        void Visit(Nodes.Interfaces.IBinary binaryExpression);
        void Visit(Nodes.Interfaces.IUnary unaryExpression);


        void Visit(Values.Undefined undefined);
    }
}
