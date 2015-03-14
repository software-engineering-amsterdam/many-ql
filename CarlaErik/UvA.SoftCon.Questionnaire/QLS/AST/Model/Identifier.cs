using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    /// <summary>
    /// A name that uniquely defines or refers to a question.
    /// </summary>
    public class Identifier : QLSNode
    {
        public string Name
        {
            get;
            private set;
        }

        internal Identifier(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
