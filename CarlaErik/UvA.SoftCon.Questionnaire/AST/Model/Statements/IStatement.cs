using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Statements
{
    public interface IStatement : INode
    {
        void AppendQuestions(ICollection<Question> questions);
    }
}
