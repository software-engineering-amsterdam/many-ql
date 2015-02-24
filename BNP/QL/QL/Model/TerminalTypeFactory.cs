using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Grammars;
using QL.Model.Terminals;

namespace QL.Model
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
