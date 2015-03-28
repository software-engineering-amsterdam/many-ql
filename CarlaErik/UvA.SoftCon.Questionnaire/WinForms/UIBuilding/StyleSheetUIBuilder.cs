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
        private QuestionForm _questionForm;
        private OutputWindow _outputWindow;
        private ICollection<QuestionWidget> questionWidgets = new List<QuestionWidget>();

        // Set a default style per data type.
        private StyleSet _currentBooleanStyles = StyleSet.Default;
        private StyleSet _currentDateStyles = StyleSet.Default;
        private StyleSet _currentIntegerStyles = StyleSet.Default;
        private StyleSet _currentStringStyles = StyleSet.Default;

        internal StyleSheetUIBuilder(StyleSheetUIBuilder parent, IEnumerable<DefaultStyle> defaultStyles) 
        {
            _questionForm = parent._questionForm;

        }




        public Control BuildUI(StyleSheet styleSheet, QuestionForm form, OutputWindow outputWindow)
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
            var question = _questionForm.GetAllQuestions().Where(q => q.Name == questionRef.Name).SingleOrDefault();
            
            //questionRef.StyleAttributes

            if (question != null)
            {
                var widgetBuilder = new WidgetBuilder();
                var questionWidget = widgetBuilder.CreateQuestionWidget(question, null);


                return questionWidget;
            }
            else
            {
                throw new ApplicationException("Question not found.");
            }
        }

        //private IEnumerable<StyleAttribute> GetCurrentStyles()


    }
}
