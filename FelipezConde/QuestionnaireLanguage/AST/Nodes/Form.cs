using AST.Nodes.Interfaces;
using AST.Nodes.FormObjects;
using System.Collections.Generic;


namespace AST.Nodes
{
    public class Form : ASTNode, IFormObjectContainer
    {
        private List<FormObjects.FormObject> body;

        public Form(List<FormObjects.FormObject> body, PositionInText position)
            : base(position)
        {
            this.body = body;
        }
        
        public IList<FormObjects.FormObject> GetBody() { return body; }

        public T Accept<T>(ASTVisitors.Interfaces.IFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }


    }

}
