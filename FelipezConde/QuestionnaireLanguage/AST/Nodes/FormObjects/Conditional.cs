using AST.Nodes.Expressions;
using AST.Nodes.Interfaces;
using System.Collections.Generic;

namespace AST.Nodes.FormObjects
{
    public class Conditional : FormObject, IFormObjectContainer
    {
        private IList<FormObject> body;
        public Expression Condition { get; private set; }

        public Conditional(Expression condition, IList<FormObject> body, PositionInText positionInText) 
            : base(positionInText)
        {
            this.Condition = condition;
            this.body = body;
        }

        public IList<FormObject> GetBody()
        {
            return this.body;
        }

        public override T Accept<T>(VisitorInterfaces.IFormObjectVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
