using AST.Nodes;
using AST.Nodes.FormObject;
using AST.Nodes.FormSection;
using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Factory.PartialFactories
{
    internal static class FormElements
    {
        public static IASTNode GetNode(QLMainParser.FormContext context)
        {
            return new Form();
        }

        public static IASTNode GetNode(QLMainParser.FormSectionContext context)
        {
            return new FormSection();
        }

        public static IASTNode GetNode(QLMainParser.QuestionContext context)
        {
            return new Question();
        }

        public static IASTNode GetNode(QLMainParser.ConditionalContext context)
        {
            return new Conditional();
        }

    }
}
