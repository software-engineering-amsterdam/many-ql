using System.Collections.Generic;


namespace AST.Nodes
{
    public class Form : Node, IFormObjectContainer
    {
        private List<FormObjects.FormObject> body;

        public Form(List<FormObjects.FormObject> body, PositionInText position)
            : base(position)
        {
            this.body = body;
        }
        
        public IList<FormObjects.FormObject> GetBody() { return body; }

        public T Accept<T>(VisitorInterfaces.IFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }


    }

}
