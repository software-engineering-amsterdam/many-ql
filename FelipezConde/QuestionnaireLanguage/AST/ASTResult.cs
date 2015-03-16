using AST.Nodes;
using AST.Representation;
using Notifications;
using System;
using System.Collections.Generic;

namespace AST
{
    public class ASTResult
    {
        public Form Ast { get; private set; } //implicit contract -> This has to be a form object, otherwise things will go wrong!

        public ASTResult(Form tree)
        {
            this.Ast = tree;
        }
    }
}
