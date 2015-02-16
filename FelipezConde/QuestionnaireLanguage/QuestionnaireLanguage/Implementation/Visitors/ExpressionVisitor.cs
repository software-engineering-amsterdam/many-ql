using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Implementation.Visitors
{
    public class ExpressionVisitor
    {
        RoseTree IQLMainVisitor<RoseTree>.VisitExpression(QLMainParser.ExpressionContext context)
        {
            throw new NotImplementedException();
        }


    }
}
