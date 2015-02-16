using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Boolean;

namespace UvA.SoftCon.Questionnaire.AST.Statements
{
    public abstract class Question : IStatement
    {
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

        protected Question(string id, string label)
        {
            Id = id;
            Label = label;
        }
    }
}
