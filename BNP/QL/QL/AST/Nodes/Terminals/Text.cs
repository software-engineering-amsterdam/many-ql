using System;

namespace QL.AST.Nodes.Terminals
{
    public class Text : ElementBase, IStaticReturnType, ITerminal
    {
        private string _value;

        public string Value
        {
            get { return _value; }
            set { _value = UnwrapQuotes(value); }
        }

        public Text()
        { }

        public Text(string value)
        {
            Value = value;
        }

        public Text(string value, SourceLocation sourceLocation)
            : this(value)
        {
            SourceLocation = sourceLocation;
        }


        public Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (Value == null)
            {
                throw new Exception();
            }

            return Value;
        }
    }
}
