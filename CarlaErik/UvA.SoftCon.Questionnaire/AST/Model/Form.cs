using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire AST.
    /// </summary>
    public sealed class Form : Node
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.Form;
            }
        }

        public IReadOnlyList<IStatement> Statements
        {
            get;
            private set;
        }

        public Form(IReadOnlyList<IStatement> statements, TextPosition position)
            : base(position)
        {
            Statements = statements;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }
    }
}
