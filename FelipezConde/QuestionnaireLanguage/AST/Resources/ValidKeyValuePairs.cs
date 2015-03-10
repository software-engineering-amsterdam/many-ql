using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Resources
{
    public class ValidKeyValuePairs
    {
        private static Dictionary<string, Types> ValidPairs = new Dictionary<string,Types> {
            { "label" , Types.STRING },
            { "value" , Types.PARENT },
        };

        public bool Exists(string key)
        { return ValidPairs.Keys.Any(x => x == key);}

        public Types getType(string key, Types type)
        {
            return ValidPairs[key];
        }
    }
}
