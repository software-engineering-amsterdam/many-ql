using GrammarProject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Implementation.Visitors
{
    public class KeyValPairVisitor
    {
        RoseTree IQLMainVisitor<RoseTree>.VisitKeyValPairs(QLMainParser.KeyValPairsContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitKey(QLMainParser.KeyContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitVal(QLMainParser.ValContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitValue(QLMainParser.ValueContext context)
        {
            throw new NotImplementedException();
        }
    }
}
