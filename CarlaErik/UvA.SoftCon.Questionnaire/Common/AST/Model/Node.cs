using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Common.AST.Model
{
    public abstract class Node
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
    }
}
