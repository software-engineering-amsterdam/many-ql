using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Labels;
using Values = AST.Nodes.Values;
using AST.Nodes.Values;

namespace AST.Nodes.FormObject
{
    public class Question : ASTNode, IFormObject
    {
        public ILabel Label {get; private set;}
        public IComputation Computation {get; private set;}
        public string Identifier {get; private set;}
        public Values.Value Value { get; private set; }

        public Question(string identifier,
                        Value value,
                        ILabel label,
                        IComputation computation,
                        PositionInText positionInText)
            : base(positionInText)
        {
            this.Identifier = identifier;
            this.Value = value;
            this.Label = label;
            this.Computation = computation;
        }

        public override void Accept(Visitors.IVisitor visitor)
        { visitor.Visit(this); }

        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        { return visitor.Visit(this); }

        public override string GetParsedString()
        {
            throw new NotImplementedException();
        }
    }
}
