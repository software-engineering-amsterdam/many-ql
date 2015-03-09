using System;

namespace QL.Model.Terminals
{
    public class Yesno : BinaryTreeElementBase, ITerminal<bool?>, IResolvableTerminalType
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
        public static bool operator ==(Yesno a, Yesno b) { return a.Value == b.Value; }
        public static bool operator !=(Yesno a, Yesno b) { return a.Value != b.Value; }

       

    }
}
