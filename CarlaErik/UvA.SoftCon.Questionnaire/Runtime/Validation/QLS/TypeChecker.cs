using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QLS
{
    /// <summary>
    /// Checks whether widget assignments are compatible with their question types.
    /// </summary>
    internal class TypeChecker : QLSVisitor<object>
    {


        public override object VisitQuestionReference(QuestionReference questionRef)
        {
            return null;
        }

        public override object VisitDefaultStyle(DefaultStyle defaultStyle)
        {



            return null;
        }
    }
}
