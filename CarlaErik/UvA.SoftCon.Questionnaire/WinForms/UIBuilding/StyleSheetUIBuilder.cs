using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    /// <summary>
    /// Creates a UI control tree based on the style sheet AST.
    /// </summary>
    internal class StyleSheetUIBuilder : QLSVisitor<Control>
    {
        private QuestionForm _questionForm;
        private OutputWindow _outputWindow;
        private ICollection<QuestionWidget> questionWidgets = new List<QuestionWidget>();

        public Control BuildUi(StyleSheet styleSheet, QuestionForm form, OutputWindow outputWindow)
        {
            _questionForm = form;
            _outputWindow = outputWindow;

            return VisitStyleSheet(styleSheet);
        }


        public override Control VisitStyleSheet(StyleSheet styleSheet)
        {
            var pageControls = new List<PageControl>();

            foreach (var page in styleSheet.Pages)
            {
                pageControls.Add((PageControl)page.Accept(this));
            }

            return new StyledQuestionFormControl(_questionForm, pageControls, questionWidgets, _outputWindow);
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
            var questionControls = new List<QuestionWidget>();

            foreach (var questionRef in section.QuestionReferences)
            {
                questionControls.Add((QuestionWidget)questionRef.Accept(this));
            }

            return new SectionControl(section.Title, questionControls);
        }

        public override Control VisitQuestionReference(QuestionReference questionRef)
        {
            return base.VisitQuestionReference(questionRef);
        }
    }
}
