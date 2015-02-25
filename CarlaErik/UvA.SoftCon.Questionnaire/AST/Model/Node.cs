using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
    public abstract class Node
    {
        public abstract NodeType Type { get; }

        public TextPosition Position
        {
            get;
            private set;
        }

        protected Node(TextPosition position)
        {
            Position = position;
        }

        public abstract T Accept<T>(IASTVisitor<T> visitor);
    }
}
