using AST.Nodes.Expressions;
using AST.Nodes.Literals;
using Evaluator.Values;
using System.Collections.Generic;

namespace Evaluator.Storage
{
    public class SymbolTable
    {
        private Dictionary<Id, Value> table = new Dictionary<Id, Value>();
        
        public bool IsInTable(Id id)
        {
            return table.ContainsKey(id);
        }

        public Value GetValue(Id id)
        {
            return table[id];
        }

        public void SetUpdateValue(Id id, Value value)
        {
            if (!IsInTable(id))
            {
                table.Add(id, value);
            }
            else
                table[id] = value;
        }
        public void AddValue(Id id, Value value)
        {
            if (!IsInTable(id))
            {
                table.Add(id, value);
            }
        }
    }


}

