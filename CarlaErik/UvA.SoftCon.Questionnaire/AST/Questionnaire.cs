using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Statements;

namespace UvA.SoftCon.Questionnaire.AST
{
    /// <summary>
    /// Represents a single questionnaire.
    /// </summary>
    public class Questionnaire
    {
        public ICollection<IStatement> Statements
        {
            get;
            private set;
        }

        public Questionnaire(ICollection<IStatement> statements)
        {
            Statements = statements;
        }
    }
}
