namespace QL.AST.Nodes.Terminals.Wrappers
{
    public class YesnoWrapper : ITerminalWrapper
    {
        public bool? Value { get; set; }

        public YesnoWrapper(Yesno value)
        {
            if (value != null)
            {
                Value = value.Value;
            }
        }

        public YesnoWrapper(bool value)
        {
            Value = value;
        }

        public void SetValue(object value)
        {
            if (value is bool?) Value = value as bool?;

            switch (value.ToString().ToLower())
            {
                case "yes":
                    Value = true;
                    break;
                case "no":
                    Value = false;
                    break;
                default:
                    Value = null;
                    break;
            }
        }

        public bool ToBool()//TODO change to (bool)
        {
            return Value.GetValueOrDefault(false);
        }

        public static YesnoWrapper operator ==(YesnoWrapper a, YesnoWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value == b.Value);
        }

        public static YesnoWrapper operator !=(YesnoWrapper a, YesnoWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value != b.Value.Value);
        }
        
        public static YesnoWrapper operator &(YesnoWrapper a, YesnoWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value & b.Value.Value);
        }

        public static YesnoWrapper operator |(YesnoWrapper a, YesnoWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value | b.Value.Value);
        }

        public override string ToString()
        {
            return Value.HasValue ? (Value.Value ? "Yes" : "No") : string.Empty;
        }

        public override int GetHashCode()
        {
            string w = "yesnowrapper";
            return 13 * (new { w, Value }.GetHashCode()); //have you heard about those magic numbers?
        }

        public bool Equals(YesnoWrapper obj)
        {
            return Value == obj.Value;
        }

        public override bool Equals(object obj)
        {
            if (obj is YesnoWrapper) return Equals(obj as YesnoWrapper);
            return false;
        }

        protected static bool ContainsNullValue(YesnoWrapper a, YesnoWrapper b)
        {
            return ReferenceEquals(a, null) || ReferenceEquals(b, null) || ReferenceEquals(null, a.Value) || ReferenceEquals(null, b.Value);
        }
    }
}
