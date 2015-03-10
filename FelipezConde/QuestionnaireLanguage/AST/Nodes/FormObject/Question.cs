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
using Types = AST.Types;

namespace AST.Nodes.FormObject
{
    public class Question : ASTNode, IFormObject, IHasType
    {
        public ILabel Label {get; private set;}
        public IExpression Computation {get; private set;}
        public string Identifier {get; private set;}
        private Types.Type type;

        public Question(string identifier,
                        Types.Type type,
                        ILabel label,
                        IExpression computation,
                        PositionInText positionInText)
            : base(positionInText)
        {
            this.Identifier = identifier;
            this.type = type;
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

        public Types.Type RetrieveType()
        {
            return this.type;
        }
    }
}
