using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using AST.Nodes;
using AST.Nodes.Interfaces;
using AST.Nodes.FormObject;
using Binary = AST.Nodes.Expression.Binary;
using Unary  = AST.Nodes.Expression.Unary;
using AST.Nodes.Expression;
using Values     = AST.Nodes.Values;
using Label      = AST.Nodes.Labels;


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
        //void Visit(Values.Unknown node);


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
