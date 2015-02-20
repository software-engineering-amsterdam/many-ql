using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
    public abstract class Node
    {
        protected Node()
        {
        }

        public abstract void Accept(IASTVisitor visitor);
    }
}
