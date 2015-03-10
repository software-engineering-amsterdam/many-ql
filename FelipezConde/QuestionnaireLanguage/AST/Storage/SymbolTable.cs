using AST.Nodes.Expression;
using AST.Nodes.Values;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Storage
{
    public class SymbolTable : ISymbolTable
    {
        Dictionary<Id, Value> table;

        public SymbolTable() { table = new Dictionary<Id, Value>(); }

        public bool IsInTable(Id id)
        {
            return table.ContainsKey(id);
        }

        public Value GetValue(Id id)
        {
            return table[id];
        }

        public void SetValue(Id id, Value newValue)
        {
            table[id] = newValue; 
        }
    }


}

