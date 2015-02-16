using QuestionnaireLanguage.AST.Factory;
using QuestionnaireLanguage.AST.Nodes.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.AST.Nodes
{
    internal class NodeFactory : AstFactory
    {

        public static NodeFactory GetNodeFactory()
        {
            return new NodeFactory();
        }

        public override iFormObjectNode GetFormObjectNode(string formObjectName)
        {
            iFormObjectNode formObjectNode;
            if (formObjectName.Equals("question"))
                formObjectNode = new QuestionNode();
            else// if (context.GetText().Equals("question"))
                formObjectNode = new FieldNode();

            return formObjectNode;
        }
    }
}
