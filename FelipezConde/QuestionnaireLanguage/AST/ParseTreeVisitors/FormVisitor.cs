using AST.Nodes;
using AST.Nodes.FormObjects;
using Grammar;
using System.Collections.Generic;
using System.Linq;

namespace AST.ParseTreeVisitors
{

    public class FormVisitor : QLMainBaseVisitor<Form>
    {
        public override Form VisitForm(QLMainParser.FormContext context)
        {
            List<FormObject> formObjects = context.formSection()
                                                       .formObject()
                                                       .Select(child => child.Accept(new FormObjectVisitor()))
                                                       .ToList();

            return new Form(formObjects, new PositionInText(context));
        }

    }
}
