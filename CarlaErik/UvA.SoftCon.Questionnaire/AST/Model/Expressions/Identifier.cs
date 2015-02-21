using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public class Identifier : Node, IExpression
    {
        public string Name
        {
            get;
            private set;
        }

        public Identifier(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
