using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Identifiers
{
    public class Identifier
    {
        public string Name
        {
            get;
            private set;
        }

        public Identifier(string name)
        {
            Name = name;
        }
    }
}
