using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    /// <summary>
    /// Checks for duplicate labels in questions.
    /// </summary>
    public class DuplicateLabelChecker : QLVisitor<object>
    {
        private readonly ICollection<Question> _questions;

        public ICollection<Question> DuplicateLabels
        {
            get ;
            private set;
        }

        public DuplicateLabelChecker()
        {
            _questions = new List<Question>();
            DuplicateLabels = new List<Question>();
        }

        public override object Visit(Question node)
        {
            if (LabelExists(node))
            {
                DuplicateLabels.Add(node);
            }
            _questions.Add(node);
            return null;
        }

        private bool LabelExists(Question question)
        {
            return _questions.Any(q => q.Label == question.Label);
        }
    }
}
