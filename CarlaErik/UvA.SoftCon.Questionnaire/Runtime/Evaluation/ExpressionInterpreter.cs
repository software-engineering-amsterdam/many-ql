using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation
{
    internal class ExpressionInterpreter : QLVisitor<Value>
    {
        protected IDictionary<string, Value> Context
        {
            get;
            private set;
        }

        internal ExpressionInterpreter(IDictionary<string, Value> context)
        {
            Context = context;
        }

        #region Visit Literals

        public override Value Visit(BooleanLiteral literal)
        {
            return new BooleanValue(literal.GetValue());
        }

        public override Value Visit(IntegerLiteral literal)
        {
            return new IntegerValue(literal.GetValue());
        }

        public override Value Visit(StringLiteral literal)
        {
            return new StringValue(literal.GetValue());
        }

        public override Value Visit(DateLiteral literal)
        {
            return new DateValue(literal.GetValue());
        }

        #endregion

        #region Visit Identifier

        public override Value Visit(Identifier identifier)
        {
            if (Context.ContainsKey(identifier.Name))
            {
                return Context[identifier.Name];
            }
            else
            {
                return new Undefined();
            }
        }

        #endregion

        #region Visit Unary Expressions

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
            Value right = add.Right.Accept(this);

            return left.Plus(right);
        }

        public override Value Visit(And and)
        {
            Value left = and.Left.Accept(this);
            Value right = and.Right.Accept(this);

            return left.And(right);
        }

        public override Value Visit(Divide divide)
        {
            Value left = divide.Left.Accept(this);
            Value right = divide.Right.Accept(this);

            return left.DividedBy(right);
        }

        public override Value Visit(EqualTo equalTo)
        {
            Value left = equalTo.Left.Accept(this);
            Value right = equalTo.Right.Accept(this);

            return left.IsEqualTo(right);
        }

        public override Value Visit(GreaterThan greaterThan)
        {
            Value left = greaterThan.Left.Accept(this);
            Value right = greaterThan.Right.Accept(this);

            return left.IsGreaterThan(right);
        }

        public override Value Visit(GreaterThanOrEqualTo greaterThanOrEqualTo)
        {
            Value left = greaterThanOrEqualTo.Left.Accept(this);
            Value right = greaterThanOrEqualTo.Right.Accept(this);

            return left.IsGreaterThanOrEqualTo(right);
        }

        public override Value Visit(LessThan lessThan)
        {
            Value left = lessThan.Left.Accept(this);
            Value right = lessThan.Right.Accept(this);

            return left.IsLessThan(right);
        }

        public override Value Visit(LessThanOrEqualTo lessThanOrEqualTo)
        {
            Value left = lessThanOrEqualTo.Left.Accept(this);
            Value right = lessThanOrEqualTo.Right.Accept(this);

            return left.IsLessThanOrEqualTo(right);
        }

        public override Value Visit(Multiply multiply)
        {
            Value left = multiply.Left.Accept(this);
            Value right = multiply.Right.Accept(this);

            return left.MultipliedBy(right);
        }

        public override Value Visit(NotEqualTo notEqualTo)
        {
            Value left = notEqualTo.Left.Accept(this);
            Value right = notEqualTo.Right.Accept(this);

            return left.IsNotEqualTo(right);
        }

        public override Value Visit(Or or)
        {
            Value left = or.Left.Accept(this);
            Value right = or.Right.Accept(this);

            return left.Or(right);
        }

        public override Value Visit(Substract substract)
        {
            Value left = substract.Left.Accept(this);
            Value right = substract.Right.Accept(this);

            return left.Minus(right);
        }

        #endregion
    }
}
