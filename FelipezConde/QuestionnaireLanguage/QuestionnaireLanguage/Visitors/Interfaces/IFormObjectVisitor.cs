using AST.Nodes.FormObject;
using QuestionnaireLanguage.GUI.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface IFormObjectVisitor
    {
        QuestionObject Visit(Question question);
        ConditionalObject Visit(Conditional conditional);
    }
}
