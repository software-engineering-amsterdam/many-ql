using GrammarProject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Implementation.Visitors
{
    public class TypeVisitor
    {
        RoseTree IQLMainVisitor<RoseTree>.VisitDate(QLMainParser.DateContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitBool(QLMainParser.BoolContext context)
        {
            throw new NotImplementedException();
        }
        RoseTree IQLMainVisitor<RoseTree>.VisitString(QLMainParser.StringContext context)
        {
            throw new NotImplementedException();
        }
        RoseTree IQLMainVisitor<RoseTree>.VisitYear(QLMainParser.YearContext context)
        {
            throw new NotImplementedException();
        }
        RoseTree IQLMainVisitor<RoseTree>.VisitNum(QLMainParser.NumContext context)
        {
            throw new NotImplementedException();
        }
        RoseTree IQLMainVisitor<RoseTree>.VisitTypeName(QLMainParser.TypeNameContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitType(QLMainParser.TypeContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitId(QLMainParser.IdContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitDay(QLMainParser.DayContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitList(QLMainParser.ListContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitInt(QLMainParser.IntContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitMonth(QLMainParser.MonthContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitMoney(QLMainParser.MoneyContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitDecimal(QLMainParser.DecimalContext context)
        {
            throw new NotImplementedException();
        }

    }
}
