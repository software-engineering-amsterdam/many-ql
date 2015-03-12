using AST.Nodes.Expression;
using AST.Nodes.Literals;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Storage
{
    public class SymbolTable : ISymbolTable
    {
        Dictionary<Id, Literal> table;

        public SymbolTable() { table = new Dictionary<Id, Literal>(); }

        public bool IsInTable(Id id)
        {
            return table.ContainsKey(id);
        }

        public Literal GetValue(Id id)
        {
            return table[id];
        }

        public void SetUpdateValue(Id id, Literal value)
        {
            if (!IsInTable(id))
            {
                table.Add(id, value);
            }
            else
                table[id] = value;
        }
        public void AddValue(Id id, Literal value)
        {
            if (!IsInTable(id))
            {
                table.Add(id, value);
            }
        }
    }


}

