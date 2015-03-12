using AST.Nodes.Expression;
using AST.Nodes.Interfaces;
using AST.Nodes.Literals;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST
{
    public interface IASTResult
    {
        void SetValue(string key, ObjectValue value);
        Literal GetValue(Id key);
        bool IsTypeCorrect();

        bool HasDuplicateIdentifiers();
        bool IsCorrect();
    }
}
