using System;
using QL.Model.Terminals;

namespace QL.Factories
{
    public class TerminalTypeFactory
    {
        private readonly string _type;

        public TerminalTypeFactory(string type)
        {
            _type = type;
        }

        public ITerminalType Create()
        {
            switch (_type)
            {
                case "yesno":
                    return new Yesno();
                case "number":
                    return new Number();
                case "text":
                    return new Text();
                default:
                    throw new ArgumentOutOfRangeException();
            }
        }
    }
}
