using AST.VisitorInterfaces;
using Ast = AST.Nodes.FormObjects;
using QLGui.FormObjects;

namespace QLGui.ASTVisitors
{
    public class FormObjectVisitor : IFormObjectVisitor<FormObject>
    {
        public FormObject Visit(Ast.Conditional node)
        {
            return new ConditionalObject(node);
        }

        public FormObject Visit(Ast.Question node)
        {
            return new QuestionObject(node);
        }
    }
}
