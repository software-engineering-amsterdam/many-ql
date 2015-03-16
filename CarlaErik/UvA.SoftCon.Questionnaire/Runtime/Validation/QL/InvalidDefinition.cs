using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    public class InvalidDefinition
    {
        public DataType TargetType
        {
            get;
            private set;
        }

        public DataType ExpressionType
        {
            get;
            private set;
        }

        public Expression Expression
        {
            get;
            private set;
        }

        public Identifier Id
        {
            get;
            private set;
        }

        public InvalidDefinition(Identifier id, Expression expression, DataType targetType, DataType expressionType)
        {
            Id = id;
            Expression = expression;
            TargetType = targetType;
            ExpressionType = expressionType;
        }
    }
}
