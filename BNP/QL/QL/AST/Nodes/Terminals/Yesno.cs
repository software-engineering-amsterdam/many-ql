using QL.Exceptions.Errors;
using System;

namespace QL.AST.Nodes.Terminals
{
    public class Yesno : ElementBase, IStaticReturnType, ITerminal
    {

        public bool? Value { get; set; }

        public Yesno()
        { }


        public Yesno(string unparsedValue)
        {
            switch (UnwrapQuotes(unparsedValue).ToLowerInvariant())
            {
                case "yes":
                    Value = true;
                    break;
                case "no":
                    Value = false;
                    break;
                default:
                    throw new QLError("Cannot parse the value:" + unparsedValue);
            }
        }

        public Yesno(string unparsedValue, SourceLocation sourceLocation)
            : this(unparsedValue)
        {
            SourceLocation = sourceLocation;
        }

        public Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (!Value.HasValue) throw new QLError("Attempted to convert Yesno to a string representation but it has no value");
            return Value.Value ? "yes" : "no";
        }
    }
}
