using AST.Nodes.Expression;
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
        bool InTable();
        Tuple<Id, ObjectValue> GetFullObject();
        ObjectValue GetObjectValue();
        void SetObjectValue();
        ObjectType GetObjectType();
        
    }
}
