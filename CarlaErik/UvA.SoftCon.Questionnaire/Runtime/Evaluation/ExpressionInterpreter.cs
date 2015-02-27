using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation
{
    internal class ExpressionInterpreter : ASTVisitor<Value>
    {
        #region Visit Literals

        public override Value Visit(BooleanLiteral literal)
        {
            return new BooleanValue(literal.Value);
        }

        public override Value Visit(IntegerLiteral literal)
        {
            return new IntegerValue(literal.Value);
        }

        public override Value Visit(StringLiteral literal)
        {
            return new StringValue(literal.Value);
        }

        #endregion 

        #region Visit Identifier

        public override Value Visit(Identifier identifier)
        {
            return base.Visit(identifier);
        }

        #endregion

        #region Visit Unary Expressions

        public override Value Visit(Increment increment)
        {
            Value operand = increment.Operand.Accept(this);

            return operand.Increment();
        }

        public override Value Visit(Negation negation)
        {
            Value operand = negation.Operand.Accept(this);

            return operand.Negate();
        }

        #endregion

        #region Visit Binary Expressions

        public override Value Visit(Add add)
        {
            Value left = add.Left.Accept(this);
            Value right = add.Left.Accept(this);

            return left.Plus(right);
        }

        public override Value Visit(And and)
        {
            Value left = and.Left.Accept(this);
            Value right = and.Left.Accept(this);

            return left.And(right);
        }

        #endregion
    }
}
