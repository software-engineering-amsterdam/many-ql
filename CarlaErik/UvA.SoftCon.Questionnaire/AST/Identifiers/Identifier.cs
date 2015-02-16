using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Identifiers
{
    public class Identifier : IExpression
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

        public override string ToString()
        {
            return Name;
        }
    }
}
