using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    public class InvalidAssignment
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

        public IExpression Expression
        {
            get;
            private set;
        }

        public Identifier Id
        {
            get;
            private set;
        }

        public InvalidAssignment(Identifier id, IExpression expression, DataType targetType, DataType expressionType)
        {
            Id = id;
            Expression = expression;
            TargetType = targetType;
            ExpressionType = expressionType;
        }
    }
}
