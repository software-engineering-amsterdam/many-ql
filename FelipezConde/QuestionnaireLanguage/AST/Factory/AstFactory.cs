using AST.Nodes;
using AST.Nodes.FormObject;
using AST.Nodes.GenericTypeName;
using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Expression;
using Grammar;
using AST.Nodes.FormSection;
using AST.Nodes.Types;
using AST.Nodes.Comparison;
using AST.Nodes.Arithmetic;
using AST.Nodes.KeyValuePair;

namespace AST.Factory
{
    public static class ASTFactory
    {
        #region FormElements
        public static IASTNode GetNode(QLMainParser.FormContext context)
        {
            return new Form();
        }

        public static IASTNode GetNode(QLMainParser.FormSectionContext context)
        {
            return new FormSection();
        }

        public static IASTNode GetNode(QLMainParser.QuestionContext context)
        {
            return new Question();
        }

        public static IASTNode GetNode(QLMainParser.ConditionalContext context)
        {
            return new Conditional();
        }
        #endregion

        #region Expressions
        public static IASTNode GetNode(QLMainParser.PrimitiveTypeNameContext context)
        {
            return null;
        }

        public static IASTNode GetNode(QLMainParser.GenericTypeNameContext context)
        {
            return new TypeName();
        }

        public static IASTNode GetNode(QLMainParser.PriorityExpressionContext context)
        {
            return new Nodes.Expression.Priority();
        }

        public static IASTNode GetNode(QLMainParser.IdContext context)
        {
            return new Id();
        }

        public static IASTNode GetNode(QLMainParser.ExpressionIdContext context)
        {
            return new Id();
        }


        public static IASTNode GetNode(QLMainParser.AndContext context)
        {
            return new And();
        }

        //public static IASTNode GetNode(QLMainParser.ExpressionTypeContext context)
        //{
        //    return new Bool();
        //}

        internal static IASTNode GetNode(QLMainParser.NegateContext context)
        {
            return new Negate();
        }

        internal static IASTNode GetNode(QLMainParser.OrContext context)
        {
            return new Or();
        }

        internal static IASTNode GetNode(QLMainParser.EqualityContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.EQ:
                    ast = new Equal();
                    break;
                case QLMainParser.NEQ:
                    ast = new NotEqual();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }
        #endregion

        #region Comparison
        internal static IASTNode GetNode(QLMainParser.PriorityComparisonContext context)
        {
            return new Nodes.Comparison.Priority();
        }

        internal static IASTNode GetNode(QLMainParser.ArithmeticComparisonContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.GT:
                    ast = new GreaterThan();
                    break;
                case QLMainParser.LT:
                    ast = new LessThan();
                    break;
                case QLMainParser.GET:
                    ast = new GreaterThanOrEqual();
                    break;
                case QLMainParser.LET:
                    ast = new LessThanOrEqual();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }
        #endregion

        #region Arithmetic
        internal static IASTNode GetNode(QLMainParser.PriorityArithmeticContext context)
        {
            return new Nodes.Arithmetic.Priority();
        }

        internal static IASTNode GetNode(QLMainParser.DivMulContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.MUL:
                    ast = new Multiply();
                    break;
                case QLMainParser.DIV:
                    ast = new Divide();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }

        internal static IASTNode GetNode(QLMainParser.SubAddContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.SUB:
                    ast = new Subtract();
                    break;
                case QLMainParser.ADD:
                    ast = new Add();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }

        internal static IASTNode GetNode(QLMainParser.ArithmeticIdContext context)
        {
            return new Id();
        }
        #endregion

        #region Types
        internal static IASTNode GetNode(QLMainParser.NumIntContext context)
        {
            return new Int();
        }

        internal static IASTNode GetNode(QLMainParser.NumMoneyContext context)
        {
            return new Money();
        }

        internal static IASTNode GetNode(QLMainParser.NumDecimalContext context)
        {
            return new Nodes.Types.Decimal();
        }

        internal static IASTNode GetNode(QLMainParser.BoolValueContext context)
        {
            return new Nodes.Types.Bool();
        }

        internal static IASTNode GetNode(QLMainParser.StringValueContext context)
        {
            return new Nodes.Types.String();
        }

        internal static IASTNode GetNode(QLMainParser.DateValueContext context)
        {
            return new Nodes.Types.Date();
        }

        #endregion

        #region KeyValue
        internal static IASTNode GetNode(QLMainParser.KeyValuePairContext context)
        {
            return new KeyValuePair();
        }
        #endregion

        internal static IASTNode GetNode(QLMainParser.KeyValuePairsContext context)
        {
            return new KeyValuePairs();
        }

        internal static IASTNode GetNode(QLMainParser.ListContext context)
        {
            return new List();
        }
    }
}
