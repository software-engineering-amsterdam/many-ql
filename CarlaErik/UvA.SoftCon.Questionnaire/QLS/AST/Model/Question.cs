using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Question : QLSNode
    {
        public Question(TextPosition position)
            : base(position)
        {
        }
    }
}
