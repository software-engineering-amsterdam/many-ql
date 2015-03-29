using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;

namespace UvA.SoftCon.Questionnaire.QLS
{
    /// <summary>
    /// Provides a default top down traversel visitor for the style sheet AST.
    /// </summary>
    public abstract class TopDownStyleSheetVisitor<T> : IStyleSheetVisitor<T>
    {
        public virtual T VisitStyleSheet(StyleSheet styleSheet)
        {
            foreach (var page in styleSheet.Pages)
            {
                page.Accept(this);
            }
            return default(T);
        }

        public virtual T VisitPage(Page page)
        {
            foreach (var section in page.Sections)
            {
                section.Accept(this);
            }
            foreach (var defaultStyle in page.DefaultStyles)
            {
                defaultStyle.Accept(this);
            } 
            return default(T);
        }

        public virtual T VisitSection(Section section)
        {
            foreach (var questionRef in section.QuestionReferences)
            {
                questionRef.Accept(this);
            }
            foreach (var defaultStyle in section.DefaultStyles)
            {
                defaultStyle.Accept(this);
            }
            return default(T);
        }

        public virtual T VisitQuestionReference(QuestionReference questionRef)
        {
            questionRef.Id.Accept(this);

            foreach (var styleAttr in questionRef.StyleAttributes)
            {
                styleAttr.Accept(this);
            }
            return default(T);
        }

        public virtual T VisitIdentifier(Identifier identifier)
        {
            return default(T);
        }

        public virtual T VisitDefaultStyle(DefaultStyle defaultStyle)
        {
            foreach (var styleAttr in defaultStyle.StyleAttributes)
            {
                styleAttr.Accept(this);
            }
            return default(T);
        }

        public virtual T VisitColorStyle(ColorStyle colorStyle)
        {
            return default(T);
        }

        public virtual T VisitFontName(FontName fontName)
        {
            return default(T);
        }

        public virtual T VisitFontSize(FontSize fontSize)
        {
            return default(T);
        }

        public virtual T VisitCalendar(Calendar calendar)
        {
            return default(T);
        }

        public virtual T VisitCheckBox(CheckBox checkBox)
        {
            return default(T);
        }

        public virtual T VisitDropDown(DropDown dropDown)
        {
            return default(T);
        }

        public virtual T VisitRadioButtons(RadioButtons radioButtons)
        {
            return default(T);
        }

        public virtual T VisitSpinBox(SpinBox spinBox)
        {
            return default(T);
        }

        public virtual T VisitTextBox(TextBox textBox)
        {
            return default(T);
        }
    }
}
