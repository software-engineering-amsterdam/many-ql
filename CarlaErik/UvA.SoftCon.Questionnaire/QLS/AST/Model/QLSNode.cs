using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public abstract class QLSNode : Node
    {
        protected QLSNode(TextPosition position)
            : base(position)
        {
        }

        public abstract T Accept<T>(IStyleSheetVisitor<T> visitor);
    }
}
