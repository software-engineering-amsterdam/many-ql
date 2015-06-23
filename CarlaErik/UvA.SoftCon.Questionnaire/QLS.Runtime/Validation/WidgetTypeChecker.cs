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
        private readonly IEnumerable<Question> _questions;
        private DataType _currentDataType = DataType.Undefined;

        internal WidgetTypeChecker(IEnumerable<Question> questions)
        {
            _questions = questions;
        }

        public override object VisitQuestionReference(QuestionReference questionRef)
        {
            // Look up the referred QL question.
            var question = _questions.Where(q => q.Name == questionRef.Name).SingleOrDefault();

            if (question != null)
            {
                _currentDataType = question.DataType;

                foreach (var styleAttr in questionRef.StyleAttributes)
                {
                    styleAttr.Accept(this);
                }
            }
            return null;
        }

        public override object VisitDefaultStyle(DefaultStyle defaultStyle)
        {
            _currentDataType = defaultStyle.DataType;

            foreach (var styleAttr in defaultStyle.StyleAttributes)
            {
                styleAttr.Accept(this);
            }

            return null;
        }

        public override object VisitDropDown(DropDown dropDown)
        {
            if (!dropDown.SupportsDataType(_currentDataType))
            {
                Report.AddError(dropDown.Position, MessageFormat, "dropdown", StringEnum.GetStringValue(_currentDataType));
            }
            return null;
        }

        public override object VisitCalendar(Calendar calendar)
        {
            if (!calendar.SupportsDataType(_currentDataType))
            {
                Report.AddError(calendar.Position, MessageFormat, "calendar", StringEnum.GetStringValue(_currentDataType));
            }
            return null;
        }

        public override object VisitCheckBox(CheckBox checkBox)
        {
            if (!checkBox.SupportsDataType(_currentDataType))
            {
                Report.AddError(checkBox.Position, MessageFormat, "checkbox", StringEnum.GetStringValue(_currentDataType));
            }
            return null;
        }

        public override object VisitRadioButtons(RadioButtons radioButtons)
        {
            if (!radioButtons.SupportsDataType(_currentDataType))
            {
                Report.AddError(radioButtons.Position, MessageFormat, "radiobuttons", StringEnum.GetStringValue(_currentDataType));
            }
            return null;
        }

        public override object VisitSpinBox(SpinBox spinBox)
        {
            if (!spinBox.SupportsDataType(_currentDataType))
            {
                Report.AddError(spinBox.Position, MessageFormat, "spinbox", StringEnum.GetStringValue(_currentDataType));
            }
            return null;
        }

        public override object VisitTextBox(TextBox textBox)
        {
            if (!textBox.SupportsDataType(_currentDataType))
            {
                Report.AddError(textBox.Position, MessageFormat, "textbox", StringEnum.GetStringValue(_currentDataType));
            }
            return null;
        }
    }
}
