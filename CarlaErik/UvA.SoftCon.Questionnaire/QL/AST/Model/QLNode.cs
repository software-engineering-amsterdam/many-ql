using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model
{
    public abstract class QLNode : Node
    {
        protected QLNode(TextPosition position)
            :base(position)
        {
        }

        public abstract T Accept<T>(IQuestionFormVisitor<T> visitor);
    }
}
