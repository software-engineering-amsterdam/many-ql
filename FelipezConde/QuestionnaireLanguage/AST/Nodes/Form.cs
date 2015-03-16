using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Nodes.FormObject;
using System.Collections.Generic;


namespace AST.Nodes
{
    public class Form : ASTNode, IFormObjectContainer
    {
        private List<FormObject.FormObject> body;

        public Form(List<FormObject.FormObject> body, PositionInText position)
            : base(position)
        {
            this.body = body;
        }
        
        public IList<FormObject.FormObject> GetBody() { return body; }

        public T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }


    }

}
