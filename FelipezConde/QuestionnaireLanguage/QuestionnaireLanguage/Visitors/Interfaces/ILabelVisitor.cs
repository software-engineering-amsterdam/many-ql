using QuestionnaireLanguage.GUI.Widgets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Labels;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface ILabelVisitor
    {
        LabelWidget Visit(Label value);
    }
}
