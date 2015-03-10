using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Storage
{
    public class SymbolTable : ISymbolTable
    {
        Dictionary<Identifier, ObjectValue> table;

        public SymbolTable(){table = new Dictionary<Identifier, ObjectValue>();}

        public bool InTable(Identifier Id)
        {
            return table.ContainsKey(Id);
        }

        public ObjectValue GetObjectValue(Identifier Id)
        {
            return table[Id];
        }

        public void SetObjectValue(Identifier id, ObjectValue newValue)
        {
            table[id] = newValue; 
        }

        public IEnumerable<Identifier> GetKeys()
        {
            return table.Keys;
        }

        public bool InTable()
        {
            throw new NotImplementedException();
        }

        public Tuple<Identifier, ObjectValue> GetFullObject()
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

