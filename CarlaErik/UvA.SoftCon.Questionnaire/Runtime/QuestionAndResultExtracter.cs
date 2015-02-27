using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime
{
    internal class QuestionAndResultExtracter : ASTVisitor
    {
        private List<IQuestionResult> _allQuestions = new List<IQuestionResult>();

        public IReadOnlyCollection<IQuestionResult> QuestionsAndResults
        {
            get
            {
                return _allQuestions;
            }
        }

        public override void Visit(Question question)
        {
            _allQuestions.Add(question);
        }

        public override void Visit(Result result)
        {
            _allQuestions.Add(result);
        }
    }
}
