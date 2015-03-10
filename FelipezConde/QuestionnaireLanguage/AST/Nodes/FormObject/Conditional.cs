using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.FormObject
{
    public class Conditional : FormElementContainer, IFormObject
    {
        public IList<IFormObject> Body { get; private set; }
        public IExpression Condition { get; private set; }
        public string parsedString;

        public Conditional(IExpression condition, 
                           IList<IFormObject> body, 
                           string parsedString,
                           PositionInText positionInText) : base(positionInText)
        {
            this.Condition = condition;
            this.Body = body;
            this.parsedString = parsedString;
        }

        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override IList<IFormObject> GetBody()
        {
            return this.Body;
        }

        public override string GetParsedString()
        {
            throw new NotImplementedException();
        }
    }
}
