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
    public abstract class QLSVisitor : IQLSVisitor
    {
        public virtual void VisitStyleSheet(StyleSheet styleSheet)
        {
            foreach (var page in styleSheet.Pages)
            {
                page.Accept(this);
            }
        }

        public virtual void VisitPage(Page page)
        {
            foreach (var section in page.Sections)
            {
                section.Accept(this);
            }
            foreach (var defaultStyle in page.DefaultStyles)
            {
                defaultStyle.Accept(this);
            }
        }

        public virtual void VisitSection(Section section)
        {
            foreach (var questionRef in section.QuestionReferences)
            {
                questionRef.Accept(this);
            }
            foreach (var defaultStyle in section.DefaultStyles)
            {
                defaultStyle.Accept(this);
            }
        }

        public virtual void VisitQuestionReference(QuestionReference questionRef)
        {
            questionRef.Id.Accept(this);

            foreach (var styleAttr in questionRef.StyleAttributes)
            {
                styleAttr.Accept(this);
            }
        }

        public virtual void VisitIdentifier(Identifier identifier)
        {
        }

        public virtual void VisitDefaultStyle(DefaultStyle defaultStyle)
        {
            foreach (var styleAttr in defaultStyle.StyleAttributes)
            {
                styleAttr.Accept(this);
            }
        }

        public virtual void VisitColorStyle(ColorStyle colorStyle)
        {
        }

        public virtual void VisitFontName(FontName fontName)
        {
        }

        public virtual void VisitFontSize(FontSize fontSize)
        {
        }

        public virtual void VisitWidth(Width width)
        {
        }

        public virtual void VisitCalendar(Calendar calendar)
        {
        }

        public virtual void VisitCheckBox(CheckBox checkBox)
        {
        }

        public virtual void VisitDropDown(DropDown dropDown)
        {
        }

        public virtual void VisitRadioButtons(RadioButtons radioButtons)
        {
        }

        public virtual void VisitSpinBox(SpinBox spinBox)
        {
        }

        public virtual void VisitTextBox(TextBox textBox)
        {
        }
    }

    public abstract class QLSVisitor<T> : IQLSVisitor<T>
    {
        public T VisitStyleSheet(StyleSheet styleSheet)
        {
            foreach (var page in styleSheet.Pages)
            {
                page.Accept(this);
            }
            return default(T);
        }

        public T VisitPage(Page page)
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

        public T VisitSection(Section section)
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

        public T VisitQuestionReference(QuestionReference questionRef)
        {
            questionRef.Id.Accept(this);

            foreach (var styleAttr in questionRef.StyleAttributes)
            {
                styleAttr.Accept(this);
            }
            return default(T);
        }

        public T VisitIdentifier(Identifier identifier)
        {
            return default(T);
        }

        public T VisitDefaultStyle(DefaultStyle defaultStyle)
        {
            foreach (var styleAttr in defaultStyle.StyleAttributes)
            {
                styleAttr.Accept(this);
            }
            return default(T);
        }

        public T VisitColorStyle(ColorStyle colorStyle)
        {
            return default(T);
        }

        public T VisitFontName(FontName fontName)
        {
            return default(T);
        }

        public T VisitFontSize(FontSize fontSize)
        {
            return default(T);
        }

        public T VisitWidth(Width width)
        {
            return default(T);
        }

        public T VisitCalendar(Calendar calendar)
        {
            return default(T);
        }

        public T VisitCheckBox(CheckBox checkBox)
        {
            return default(T);
        }

        public T VisitDropDown(DropDown dropDown)
        {
            return default(T);
        }

        public T VisitRadioButtons(RadioButtons radioButtons)
        {
            return default(T);
        }

        public T VisitSpinBox(SpinBox spinBox)
        {
            return default(T);
        }

        public T VisitTextBox(TextBox textBox)
        {
            return default(T);
        }
    }
}
