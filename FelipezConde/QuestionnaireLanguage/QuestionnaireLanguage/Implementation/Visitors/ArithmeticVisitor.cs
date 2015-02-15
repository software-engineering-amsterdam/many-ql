using GrammarProject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Implementation.Visitors
{
    public class ArithmeticVisitor
    {
        RoseTree IQLMainVisitor<RoseTree>.VisitArithmetic(QLMainParser.ArithmeticContext context)
        {
            throw new NotImplementedException();
        }

    }
}
