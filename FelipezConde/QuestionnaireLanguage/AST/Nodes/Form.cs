using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Interfaces;
using AST.Representation;


namespace AST.Nodes
{
    public class Form : ASTNode, IFormObjectContainer
    {
        private List<IFormObject> body;
        private string parsedString;

        public Form(List<IFormObject> body, string parsedString , PositionInText position)
            : base(position)
        {
            this.body = body;
            this.parsedString = parsedString;
        }
        
        public IList<IFormObject> GetBody() { return body; }

        public override string GetParsedString()
        { return parsedString; }

        //Visitor Methods
        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }


    }

}
