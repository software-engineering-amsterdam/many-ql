using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface IValueVisitor
    {
        string Visit(Values.String question);
        int Visit(Values.Int conditional);
        bool Visit(Values.Bool conditional);
    }
}
