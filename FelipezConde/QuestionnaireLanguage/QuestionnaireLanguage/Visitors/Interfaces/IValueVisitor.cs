using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Literals;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface IValueVisitor
    {
        string Visit(Values.String value);
        int Visit(Values.Int value);
        bool Visit(Values.Bool value);
    }
}
