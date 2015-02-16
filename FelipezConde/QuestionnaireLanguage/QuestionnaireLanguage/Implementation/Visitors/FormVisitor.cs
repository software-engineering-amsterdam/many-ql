using GrammarProject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Implementation.Visitors
{
    public class FormVisitor
    {
        RoseTree IQLMainVisitor<RoseTree>.VisitFormSection(QLMainParser.FormSectionContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitFormObject(QLMainParser.FormObjectContext context)
        {
            throw new NotImplementedException();
        }
        RoseTree IQLMainVisitor<RoseTree>.VisitFormElem(QLMainParser.FormElemContext context)
        {
            throw new NotImplementedException();
        }
        RoseTree IQLMainVisitor<RoseTree>.VisitConditional(QLMainParser.ConditionalContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitFormElemType(QLMainParser.FormElemTypeContext context)
        {
            throw new NotImplementedException();
        }

        RoseTree IQLMainVisitor<RoseTree>.VisitForm(QLMainParser.FormContext context)
        {
            throw new NotImplementedException();
        }
    }
}
