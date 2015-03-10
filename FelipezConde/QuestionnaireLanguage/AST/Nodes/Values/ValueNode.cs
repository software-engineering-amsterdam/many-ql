using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Storage;
using AST.Resources;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Values
{
    public abstract class ValueNode<T> : ASTNode, IValue
    {
        public T Value { get; private set; }
        public string parsedString {get; private set;}

        protected ValueNode(string parsedString, T value, PositionInText position)
            : base(position)
        {
            Value = value;
            this.parsedString = parsedString;
        }

        public abstract Types GetType(ISymbolTable lookup);
        public override string GetParsedString() 
        { 
            return parsedString; 
        }

        public string MakeString()
        {
            throw new NotImplementedException();
        }


        public bool IsOfType(IValue type)
        {
            throw new NotImplementedException();
        }
    }
}
