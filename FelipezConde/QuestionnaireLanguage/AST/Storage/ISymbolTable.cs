using AST.Nodes.Expression;
using AST.Nodes.Values;
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
        Value GetValue(Id id);
        void SetValue(Id id, Value newValue);
        
    }
}
