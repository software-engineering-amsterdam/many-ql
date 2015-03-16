using AST.Nodes.Interfaces;
using System.Collections.Generic;

namespace AST.Nodes.FormObjects
{
    public class Conditional : FormObject, IFormObjectContainer
    {
        private IList<FormObject> body;
        public BaseExpression Condition { get; private set; }

        public Conditional(BaseExpression condition, IList<FormObject> body, PositionInText positionInText) 
            : base(positionInText)
        {
            this.Condition = condition;
            this.body = body;
        }

        public IList<FormObject> GetBody()
        {
            return this.body;
        }

        public override T Accept<T>(ASTVisitors.Interfaces.IFormObjectVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
