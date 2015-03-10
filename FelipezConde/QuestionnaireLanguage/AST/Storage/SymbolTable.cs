using AST.Nodes.Expression;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Storage
{
    public class SymbolTable : ISymbolTable
    {
        Dictionary<Id, ObjectValue> table;

        public SymbolTable(){table = new Dictionary<Id, ObjectValue>();}

        public bool InTable(Id Id)
        {
            return table.ContainsKey(Id);
        }

        public ObjectValue GetObjectValue(Id Id)
        {
            return table[Id];
        }

        public void SetObjectValue(Id id, ObjectValue newValue)
        {
            table[id] = newValue; 
        }

        public IEnumerable<Id> GetKeys()
        {
            return table.Keys;
        }

        public bool InTable()
        {
            throw new NotImplementedException();
        }

        public Tuple<Id, ObjectValue> GetFullObject()
        {
            throw new NotImplementedException();
        }

        public ObjectValue GetObjectValue()
        {
            throw new NotImplementedException();
        }

        public void SetObjectValue()
        {
            throw new NotImplementedException();
        }

        public ObjectType GetObjectType()
        {
            throw new NotImplementedException();
        }
    }


}

