using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST
{
    /// <summary>
    /// Represents the root of a questionnaire AST.
    /// </summary>
    public sealed class Questionnaire : Node
    {
        public IReadOnlyList<IStatement> Statements
        {
            get;
            private set;
        }

        public Questionnaire(IReadOnlyList<IStatement> statements)
        {
            Statements = statements;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }
    }
}
