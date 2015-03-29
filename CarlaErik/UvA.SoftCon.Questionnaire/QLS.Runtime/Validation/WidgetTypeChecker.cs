using System.Collections.Generic;
using System.Linq;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Validation
{
    /// <summary>
    /// Checks whether widget assignments are compatible with their question types.
    /// </summary>
    internal class WidgetTypeChecker : ASTChecker
    {
        private const string MessageFormat = "Widget '{0}' can not be applied to a question of type '{1}'.";
        private readonly IEnumerable<Question> questions;
        private DataType currentDataType = DataType.Undefined;

        internal WidgetTypeChecker(IEnumerable<Question> qlQuestions)
        {
            questions = qlQuestions;
        }


        public override object VisitQuestionReference(QuestionReference questionRef)
        {
            // Look up the referred QL question.
            var question = questions.Where(q => q.Name == questionRef.Name).SingleOrDefault();

            if (question != null)
            {
                currentDataType = question.DataType;

                foreach (var styleAttr in questionRef.StyleAttributes)
                {
                    styleAttr.Accept(this);
                }
            }
            return null;
        }

        public override object VisitDefaultStyle(DefaultStyle defaultStyle)
        {
            currentDataType = defaultStyle.DataType;

            foreach (var styleAttr in defaultStyle.StyleAttributes)
            {
                styleAttr.Accept(this);
            }

            return null;
        }

        public override object VisitDropDown(DropDown dropDown)
        {
            if (!dropDown.SupportsDataType(currentDataType))
            {
                Report.AddError(dropDown.Position, MessageFormat, "dropdown", StringEnum.GetStringValue(currentDataType));
            }
            return null;
        }

        public override object VisitCalendar(Calendar calendar)
        {
            if (!calendar.SupportsDataType(currentDataType))
            {
                Report.AddError(calendar.Position, MessageFormat, "calendar", StringEnum.GetStringValue(currentDataType));
            }
            return null;
        }

        public override object VisitCheckBox(CheckBox checkBox)
        {
            if (!checkBox.SupportsDataType(currentDataType))
            {
                Report.AddError(checkBox.Position, MessageFormat, "checkbox", StringEnum.GetStringValue(currentDataType));
            }
            return null;
        }

        public override object VisitRadioButtons(RadioButtons radioButtons)
        {
            if (!radioButtons.SupportsDataType(currentDataType))
            {
                Report.AddError(radioButtons.Position, MessageFormat, "radiobuttons", StringEnum.GetStringValue(currentDataType));
            }
            return null;
        }

        public override object VisitSpinBox(SpinBox spinBox)
        {
            if (!spinBox.SupportsDataType(currentDataType))
            {
                Report.AddError(spinBox.Position, MessageFormat, "spinbox", StringEnum.GetStringValue(currentDataType));
            }
            return null;
        }

        public override object VisitTextBox(TextBox textBox)
        {
            if (!textBox.SupportsDataType(currentDataType))
            {
                Report.AddError(textBox.Position, MessageFormat, "textbox", StringEnum.GetStringValue(currentDataType));
            }
            return null;
        }
    }
}
