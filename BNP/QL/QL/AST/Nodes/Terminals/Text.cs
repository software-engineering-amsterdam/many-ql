using System;

namespace QL.AST.Nodes.Terminals
{
    public class Text : ElementBase, IStaticReturnType
    {

        public string Value { get; set; }

        public Text()
        { }

        public Text(string value)
        {
            Value = value;
        }

        public Text(string value, AST.SourceLocation sourceLocation):this(value)
        {
            SourceLocation = sourceLocation;
        }


        public Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (Value== null) {
                throw new Exception();
            }
            
            return Value;
        }

        
       
    }
}
