using System;

namespace QL.AST.Nodes.Terminals
{
    public class Yesno : BinaryTreeElementBase, IResolvableTerminalType
    {
        public bool? Value { get; set; }

        public Yesno()
        { }

        public void SetValue(object value)
        {
            bool parsedValue;
            bool parseSuccess = bool.TryParse(value.ToString(), out parsedValue);
            if (!parseSuccess)
            {
                parsedValue = value.ToString().ToLowerInvariant() == "yes" ? true : false;
            }
            Value = parsedValue;

        }

        public Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (!Value.HasValue)
            {
                throw new Exception();
            }
            

            return Value.Value ? "yes" : "no";
        }
       

    }
}
