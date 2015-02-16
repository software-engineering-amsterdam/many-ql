using QuestionnaireLanguage.AST.Nodes;
using QuestionnaireLanguage.AST.Nodes.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.AST.Factory
{
    public abstract class AstFactory
    {
        public static AstFactory GetNodeFactory()
        {
            AstFactory factory = NodeFactory.GetNodeFactory();
            return factory;
        }

        public abstract iFormObjectNode GetFormObjectNode (string formObjectName);

    }
}
