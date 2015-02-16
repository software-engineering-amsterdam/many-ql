using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Boolean;

namespace UvA.SoftCon.Questionnaire.AST.Statements
{
    public class IfStatement : IStatement
    {
        public IBooleanExpression Condition
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

        public IfStatement(IBooleanExpression condition, ICollection<IStatement> ifTrue) 
        {
            Condition = condition;
            IfTrue = ifTrue;
        }

        public IfStatement(IBooleanExpression condition, ICollection<IStatement> ifTrue, ICollection<IStatement> ifFalse)
            : this(condition, ifTrue)
        {
            IfFalse = ifFalse;
        }
    }
}
