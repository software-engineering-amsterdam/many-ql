using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    /// <summary>
    /// Creates the UI control tree based on the style sheet AST.
    /// </summary>
    internal class StyleSheetUIBuilder : QLSVisitor<Control>
    {



        public override Control VisitStyleSheet(StyleSheet styleSheet)
        {
            foreach (var page in styleSheet.Pages)
            {

            }

            return null;
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
            var questionControls = new List<QuestionControl>();

            foreach (var questionRef in section.QuestionReferences)
            {
                questionControls.Add((QuestionControl)questionRef.Accept(this));
            }

            return new SectionControl(section.Title, questionControls);
        }

        public override Control VisitQuestionReference(QuestionReference questionRef)
        {
            return base.VisitQuestionReference(questionRef);
        }
    }
}
