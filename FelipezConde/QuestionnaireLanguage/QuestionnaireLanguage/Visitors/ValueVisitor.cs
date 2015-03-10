using QuestionnaireLanguage.Visitors.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Visitors
{
    public class ValueVisitor : IValueVisitor
    {
        public string Visit(AST.Nodes.Values.String question)
        {
            throw new NotImplementedException();
        }

        public int Visit(AST.Nodes.Values.Int conditional)
        {
            throw new NotImplementedException();
        }

        public bool Visit(AST.Nodes.Values.Bool conditional)
        {
            throw new NotImplementedException();
        }
    }
}
