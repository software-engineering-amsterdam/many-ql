using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Statements
{
    /// <summary>
    /// Represents a question which requires a textual answer.
    /// </summary>
    public class TextQuestion : Question
    {
        public TextQuestion(string id, string label)
            : base(id, label)
        {
        }
    }
}
