using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model
{
    public abstract class Node : INode
    {
        public TextPosition Position
        {
            get;
            private set;
        }

        protected Node(TextPosition position)
        {
            Position = position;
        }

        public abstract void Accept(IQLVisitor visitor);

        public abstract T Accept<T>(IQLVisitor<T> visitor);
    }
}
