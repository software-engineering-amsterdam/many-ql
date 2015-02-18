using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Statements
{
    public class IfStatement : IStatement
    {
        public IExpression Condition
        {
            get;
            private set;
        }

        public ICollection<IStatement> IfTrue
        {
            get;
            private set;
        }

        public ICollection<IStatement> IfFalse
        {
            get;
            private set;
        }

        public IfStatement(IExpression condition, ICollection<IStatement> ifTrue) 
        {
            Condition = condition;
            IfTrue = ifTrue;
        }

        public IfStatement(IExpression condition, ICollection<IStatement> ifTrue, ICollection<IStatement> ifFalse)
            : this(condition, ifTrue)
        {
            IfFalse = ifFalse;
        }

        public override string ToString()
        {
            var result = new StringBuilder();

            result.AppendFormat("if ({0})", Condition.ToString());
            result.AppendLine();
            result.AppendLine("{");

            foreach (var statement in IfTrue)
            {
                result.AppendLine(statement.ToString());
            }

            result.AppendLine("}");

            if (IfFalse.Count > 0)
            {
                result.AppendLine("else");
                result.AppendLine("{");
                foreach (var statement in IfFalse)
                {
                    result.AppendLine(statement.ToString());
                }
                result.AppendLine("}");
            }

            return result.ToString();
        }
    }
}
