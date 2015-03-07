using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public interface IStatement : IQLNode
    {
        void AppendQuestions(ICollection<Question> questions);
    }
}
