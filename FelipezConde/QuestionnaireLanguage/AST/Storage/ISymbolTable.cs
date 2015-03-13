using AST.Nodes.Expression;
using AST.Nodes.Literals;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Storage
{
    public interface ISymbolTable
    {
        bool IsInTable(Id id);
        Literal GetValue(Id id);
        void SetUpdateValue(Id id, Literal value);
        void AddValue(Id id, Literal value);
        
    }
}
