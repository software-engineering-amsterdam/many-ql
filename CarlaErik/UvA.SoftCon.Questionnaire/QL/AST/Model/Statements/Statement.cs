using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public abstract class Statement : QLNode
    {
        protected Statement(TextPosition position)
            : base(position) { }

        internal abstract void AppendQuestions(ICollection<Question> questions);
    }
}
