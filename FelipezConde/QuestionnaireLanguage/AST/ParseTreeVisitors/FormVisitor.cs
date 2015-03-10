using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Grammar;
using AST.Nodes;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Helpers;

namespace AST.ParseTreeVisitors
{

    public class FormVisitor : QLMainBaseVisitor<Form>
    {
        public override Form VisitForm(QLMainParser.FormContext context)
        {
            List<IFormObject> formObjects = context.formSection()
                                                       .formObject()
                                                       .Select(child => child.Accept(new FormObjectVisitor()))
                                                       .ToList();

            return new Form(formObjects,
                            context.GetText(),
                            Position.PositionFormParserRuleContext(context)
                            );
        }

    }
}
