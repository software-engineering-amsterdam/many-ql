using AST.Nodes.Interfaces;
using AST.Representation;
using System.Collections.Generic;

namespace AST.Nodes.FormObject
{
    public class Conditional : FormObject, IFormObjectContainer
    {
        private IList<FormObject> body;
        public IExpression Condition { get; private set; }

        public Conditional(IExpression condition, IList<FormObject> body, PositionInText positionInText) 
            : base(positionInText)
        {
            this.Condition = condition;
            this.body = body;
        }

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public IList<FormObject> GetBody()
        {
            return this.body;
        }
    }
}
