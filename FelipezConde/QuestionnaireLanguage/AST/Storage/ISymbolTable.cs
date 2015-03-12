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
        void SetUpdateValue(Id id, Value value);
        void AddValue(Id id, Value value);
        
    }
}
