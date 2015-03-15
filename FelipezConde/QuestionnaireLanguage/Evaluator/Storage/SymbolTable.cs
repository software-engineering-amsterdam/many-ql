using AST.Nodes.Expression;
using AST.Nodes.Literals;
using System.Collections.Generic;

namespace Evaluator.Storage
{
    public static class SymbolTable
    {
        private static Dictionary<Id, Literal> table = new Dictionary<Id, Literal>();
        
        public static bool IsInTable(Id id)
        {
            return table.ContainsKey(id);
        }

        public static Literal GetValue(Id id)
        {
            return table[id];
        }

        public static void SetUpdateValue(Id id, Literal value)
        {
            if (!IsInTable(id))
            {
                table.Add(id, value);
            }
            else
                table[id] = value;
        }
        public static void AddValue(Id id, Literal value)
        {
            if (!IsInTable(id))
            {
                table.Add(id, value);
            }
        }
    }


}

