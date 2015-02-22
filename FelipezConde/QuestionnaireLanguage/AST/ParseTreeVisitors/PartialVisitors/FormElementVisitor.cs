using AST.Factory;
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

namespace AST.ParseTreeVisitors.PartialVisitors
{
    public class FormElementVisitor : BaseVisitor
    {
        public override IASTNode VisitForm(QLMainParser.FormContext context)
        {
            IASTNode ast = new Form();

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitFormSection(QLMainParser.FormSectionContext context)
        {
            IASTNode ast = new FormSection();

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitQuestion(QLMainParser.QuestionContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitConditional(QLMainParser.ConditionalContext context)
        {
            IASTNode ast = new Conditional();

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }
    }
}
