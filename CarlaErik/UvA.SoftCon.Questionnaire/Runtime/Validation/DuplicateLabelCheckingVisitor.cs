using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Checks for duplicate labels in questions.
    /// </summary>
    public class DuplicateLabelCheckingVisitor : ASTVisitor
    {
        private ICollection<Question> _questions;
        
        public ICollection<Question> DuplicateLabels
        {
            get;
            private set;
        }

        public DuplicateLabelCheckingVisitor()
        {
            _questions = new List<Question>();
            DuplicateLabels = new List<Question>();
        }

        public override void Visit(Question node)
        {
            if (LabelExists(node))
            {
                DuplicateLabels.Add(node);
            }
            _questions.Add(node);
        }

        private bool LabelExists(Question question)
        {
            return _questions.Any(q => q.Label == question.Label);
        }
    }
}
