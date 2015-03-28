using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    /// <summary>
    /// Creates a UI control tree based on the style sheet AST.
    /// </summary>
    internal class StyleSheetUIBuilder : QLSVisitor<Control>
    {
        internal QuestionForm QuestionForm
        {
            get;
            private set;
        }

        internal ICollection<QuestionWidget> QuestionWidgets
        {
            get;
            private set;
        }

        internal StyleLibrary CurrentStyles
        {
            get;
            private set;
        }

        internal OutputWindow OutputWindow
        {
            get;
            private set;
        }

        internal StyleSheetUIBuilder()
        {
            QuestionWidgets = new List<QuestionWidget>();
            CurrentStyles = StyleLibrary.Default;
        }

        internal StyleSheetUIBuilder(StyleSheetUIBuilder parent, IEnumerable<DefaultStyle> defaultStyles) 
        {
            QuestionForm = parent.QuestionForm;
            QuestionWidgets = parent.QuestionWidgets;
            CurrentStyles = parent.CurrentStyles.GetCopy();
            CurrentStyles.OverrideStyles(defaultStyles);
        }

        public Control BuildUI(StyleSheet styleSheet, QuestionForm form, OutputWindow outputWindow)
        {
            QuestionForm = form;
            OutputWindow = outputWindow;

            return VisitStyleSheet(styleSheet);
        }


        public override Control VisitStyleSheet(StyleSheet styleSheet)
        {
            var pageControls = new List<PageControl>();

            foreach (var page in styleSheet.Pages)
            {
                pageControls.Add((PageControl)page.Accept(this));
            }

            return new StyledQuestionFormControl(QuestionForm, pageControls, QuestionWidgets, OutputWindow);
        }

        public override Control VisitPage(Page page)
        {
            var sectionControls = new List<SectionControl>();
            var sectionBuilder = new StyleSheetUIBuilder(this, page.DefaultStyles);

            foreach (var section in page.Sections)
            {
                sectionControls.Add((SectionControl)section.Accept(sectionBuilder));
            }

            return new PageControl(sectionControls);
        }

        public override Control VisitSection(Section section)
        {
            var questionWidgets = new List<QuestionWidget>();
            var questionBuilder = new StyleSheetUIBuilder(this, section.DefaultStyles);

            foreach (var questionRef in section.QuestionReferences)
            {
                questionWidgets.Add((QuestionWidget)questionRef.Accept(questionBuilder));
            }

            return new SectionControl(section.Title, questionWidgets);
        }


        public override Control VisitQuestionReference(QuestionReference questionRef)
        {
            var question = QuestionForm.GetAllQuestions().Where(q => q.Name == questionRef.Name).SingleOrDefault();
            
            if (question != null)
            {
                StyleSet questionStyles = CurrentStyles.GetStyleSet(question.DataType).GetCopy();
                questionStyles.OverrideStyles(questionRef.StyleAttributes);

                var widgetBuilder = new WidgetBuilder();
                var questionWidget = widgetBuilder.CreateQuestionWidget(question, questionStyles.WidgetType);

                return questionWidget;
            }
            else
            {
                throw new ApplicationException("Question not found.");
            }
        }
    }
}
