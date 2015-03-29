using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;
using AST.VisitorInterfaces;
using System.Collections.Generic;
using Types = AST.Types;

namespace TypeChecking.Collectors
{
    public class ExpressionTypeCollector : IExpressionVisitor<Types.Type>
    {
        private readonly Dictionary<Id, Types.Type> idToType;

        public ExpressionTypeCollector(Dictionary<Id, Types.Type> idToType)
        {
            this.idToType = idToType;
        }
        #region Id
        public  Types.Type Visit(Id node)
        {
            return idToType[node];
        }

        #endregion
        #region Binary
        public  Types.Type Visit(And node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public  Types.Type Visit(Or node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public  Types.Type Visit(Equal node)
        {
            return VisitBinary(node);
        }

        public  Types.Type Visit(NotEqual node)
        {
            return VisitBinary(node);
        }

        public  Types.Type Visit(GreaterThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  Types.Type Visit(GreaterThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  Types.Type Visit(LessThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  Types.Type Visit(LessThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  Types.Type Visit(Add node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  Types.Type Visit(Subtract node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  Types.Type Visit(Multiply node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  Types.Type Visit(Divide node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }
        #endregion
        #region Unary
        public  Types.Type Visit(Negate node)
        {
            return VisitUnaryExpectedType(node, new Types.BoolType());
        }

        public  Types.Type Visit(Priority node)
        {
            return VisitUnary(node);
        }
        #endregion

        private Types.Type VisitBinaryExpectedType(Binary node, Types.Type expectedType)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);

            if (!left.IsEqual(expectedType) && right.IsEqual(expectedType))
            {
                return new Types.UndefinedType();
            }

            return expectedType;
        }
        private Types.Type VisitBinary(Binary node)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);

            if (!left.IsEqual(right))
            {
                return new Types.UndefinedType();
            }

            return left;
        }
        private Types.Type VisitUnary(Unary node)
        {
            return node.GetChildExpression().Accept(this);
        }
        private Types.Type VisitUnaryExpectedType(Unary node, Types.Type expectedType)
        {
            Types.Type childType = node.GetChildExpression().Accept(this);

            if (childType.IsEqual(expectedType))
            {
                return new Types.UndefinedType();
            }

            return expectedType;
        }

        public Types.Type visit(Id node)
        {
            return idToType[node];
        }

        public Types.Type Visit(AST.Nodes.Literals.Bool node)
        {
            return node.RetrieveType();
        }

        public Types.Type Visit(AST.Nodes.Literals.Int node)
        {
            return node.RetrieveType();
        }

        public Types.Type Visit(AST.Nodes.Literals.String node)
        {
            return node.RetrieveType();
        }
    }
}
