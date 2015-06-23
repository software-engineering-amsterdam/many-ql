using System;
using System.Collections.Generic;
using System.Linq;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation
{
    /// <summary>
    /// Traverses the style sheet AST and determines the complete style attribute set for each question.
    /// </summary>
    internal class QuestionStyleEvaluator : TopDownStyleSheetVisitor<object>
    {
        private DataTypeStyleCollection _currentDataTypeStyles = DataTypeStyleCollection.Default;
        private QuestionStyleCollection _questionStyles = new QuestionStyleCollection();
        private IEnumerable<Question> _questions;
        
        internal QuestionStyleEvaluator()
        {
        }

        private QuestionStyleEvaluator(DataTypeStyleCollection dataTypeStyles, QuestionStyleCollection questionStyles, IEnumerable<Question> questions)
        {
            _currentDataTypeStyles = dataTypeStyles;
            _questionStyles = questionStyles;
            _questions = questions;
        }

        internal QuestionStyleCollection GetQuestionStyles(StyleSheet styleSheet, IEnumerable<Question> qlQuestions)
        {
            _questions = qlQuestions;
            VisitStyleSheet(styleSheet);
            return _questionStyles;
        }

        public override object VisitPage(Page page)
        {
            var dataTypeStyles = _currentDataTypeStyles.GetCopy();
            dataTypeStyles.OverrideStyles(page.DefaultStyles);

            var childStyleEvaluator = new QuestionStyleEvaluator(dataTypeStyles, _questionStyles,_questions);

            foreach (var section in page.Sections)
            {
                section.Accept(childStyleEvaluator);
            }

            return null;
        }

        public override object VisitSection(Section section)
        {
            var dataTypeStyles = _currentDataTypeStyles.GetCopy();
            dataTypeStyles.OverrideStyles(section.DefaultStyles);

            var childStyleEvaluator = new QuestionStyleEvaluator(dataTypeStyles, _questionStyles, _questions);

            foreach (var questionRef in section.QuestionReferences)
            {
                questionRef.Accept(childStyleEvaluator);
            }

            return null;
        }


        public override object VisitQuestionReference(QuestionReference questionRef)
        {
            var question = _questions.Where(q => q.Name == questionRef.Name).SingleOrDefault();
            
            if (question != null)
            {
                StyleSet dataTypeStyleSet = _currentDataTypeStyles.GetStyleSet(question.DataType);
                
                StyleSet questionStyleSet = dataTypeStyleSet.GetCopy();
                questionStyleSet.OverrideStyles(questionRef.StyleAttributes);

                _questionStyles.AddStyleSet(question.Name, questionStyleSet);

                return null;
            }
            else
            {
                throw new ApplicationException("Question not found.");
            }
        }
    }
}
