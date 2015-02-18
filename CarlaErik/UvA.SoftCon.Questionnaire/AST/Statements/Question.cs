using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Statements
{
    public class Question : IStatement
    {
        public string Type
        {
            get;
            private set;
        }

        public string Id
        {
            get;
            private set;
        }

        public string Label
        {
            get;
            private set;
        }

        public Question(string type, string id, string label)
        {
            Type = type;
            Id = id;
            Label = label;
        }

        public override string ToString()
        {
            return String.Format(@"{0} {1} ""{2}""", Type, Id, Label);
        }
    }
}
