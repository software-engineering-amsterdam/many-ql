using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Nodes.Values
{
    public class Null : Value
    {
        public Null(){}

        public override Resources.Types GetType(Storage.ISymbolTable lookup)
        {
            throw new NotImplementedException();
        }

        public override Value Equal(Value value)
        {
            throw new NotImplementedException();
        }

        public override Value NotEqual(Value value)
        {
            throw new NotImplementedException();
        }

        public override string MakeString()
        {
            return "null";
        }
    }
}
