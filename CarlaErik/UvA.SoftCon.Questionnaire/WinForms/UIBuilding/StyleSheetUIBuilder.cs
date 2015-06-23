using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    /// <summary>
    /// Creates a UI control tree based on the style sheet AST.
    /// </summary>
    internal class StyleSheetUIBuilder : TopDownStyleSheetVisitor<Control>
    {
        private QuestionStyleCollection _questionStyles;
        private QuestionForm _questionForm;
        private OutputWindow _outputWindow;
        private ICollection<QuestionWidget> _questionWidgets;

        public Control BuildUI(StyleSheet styleSheet, QuestionStyleCollection questionStyles, QuestionForm questionForm, OutputWindow outputWindow)
        {
            _questionStyles = questionStyles;
            _questionForm = questionForm;
            _outputWindow = outputWindow;
            _questionWidgets = new List<QuestionWidget>();

            return VisitStyleSheet(styleSheet);
        }

        public override Control VisitStyleSheet(StyleSheet styleSheet)
        {
            var pageControls = new List<PageControl>();

            foreach (var page in styleSheet.Pages)
            {
                pageControls.Add((PageControl)page.Accept(this));
            }

            return new StyledQuestionFormControl(_questionForm, pageControls, _questionWidgets, _outputWindow);
        }

        public override Control VisitPage(Page page)
        {
            var sectionControls = new List<SectionControl>();

            foreach (var section in page.Sections)
            {
                sectionControls.Add((SectionControl)section.Accept(this));
            }

            return new PageControl(sectionControls);
        }

        public override Control VisitSection(Section section)
        {
            var questionWidgets = new List<QuestionWidget>();

            foreach (var questionRef in section.QuestionReferences)
            {
                questionWidgets.Add((QuestionWidget)questionRef.Accept(this));
            }

            return new SectionControl(section.Title, questionWidgets);
        }


        public override Control VisitQuestionReference(QuestionReference questionRef)
        {
            var question = _questionForm.GetAllQuestions().Where(q => q.Name == questionRef.Name).SingleOrDefault();
            
            if (question != null)
            {
                StyleSet questionStyles = _questionStyles.GetStyleSet(question.Name);

                QuestionWidget questionWidget = (QuestionWidget)questionStyles.WidgetStyle.CreateWidgetControl(new WidgetFactory(question));

                questionWidget.ApplyStyles(questionStyles);

                _questionWidgets.Add(questionWidget);

                return questionWidget;
            }
            else
            {
                throw new ApplicationException("Question not found in the questionnaire AST.");
            }
        }
    }
}
