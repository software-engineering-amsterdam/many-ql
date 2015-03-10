using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Visitors;

namespace AST.Nodes
{
    public abstract class ASTNode : IASTNode
    {
        private readonly PositionInText position;
        protected ASTNode(PositionInText position)
        {
            this.position = position;
        }

        public abstract string GetParsedString();

        public virtual void Accept(IVisitor visitor)
        {
            throw new NotImplementedException();
        }

        public virtual T Accept<T>(IVisitor<T> visitor)
        {
            throw new NotImplementedException();
        }

        public PositionInText GetPosition()
        {
            return position;
        }
    }
}
