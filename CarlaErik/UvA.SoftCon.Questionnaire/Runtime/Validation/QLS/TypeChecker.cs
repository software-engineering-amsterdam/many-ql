using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QLS
{
    /// <summary>
    /// Checks whether widget assignments are compatible with their question types.
    /// </summary>
    internal class TypeChecker : ASTChecker
    {
        private readonly IEnumerable<Question> questions;
        private DataType currentDataType = DataType.Undefined;

        internal TypeChecker(IEnumerable<Question> qlQuestions)
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
                Report.AddError(dropDown.Position, "Widget dropdown can not be applied to data type '{0}'.", currentDataType);
            }
            return null;
        }

        public override object VisitCalendar(Calendar calendar)
        {
            if (!calendar.SupportsDataType(currentDataType))
            {
                Report.AddError(calendar.Position, "Widget calendar can not be applied to data type '{0}'.", currentDataType);
            }
            return null;
        }

        public override object VisitCheckBox(CheckBox checkBox)
        {
            if (!checkBox.SupportsDataType(currentDataType))
            {
                Report.AddError(checkBox.Position, "Widget calendar can not be applied to data type '{0}'.", currentDataType);
            }
            return null;
        }

        public override object VisitRadioButtons(RadioButtons radioButtons)
        {
            if (!radioButtons.SupportsDataType(currentDataType))
            {
                Report.AddError(radioButtons.Position, "Widget radio buttons can not be applied to data type '{0}'.", currentDataType);
            }
            return null;
        }

        public override object VisitSpinBox(SpinBox spinBox)
        {
            if (!spinBox.SupportsDataType(currentDataType))
            {
                Report.AddError(spinBox.Position, "Widget spinBox can not be applied to data type '{0}'.", currentDataType);
            }
            return null;
        }

        public override object VisitTextBox(TextBox textBox)
        {
            if (!textBox.SupportsDataType(currentDataType))
            {
                Report.AddError(textBox.Position, "Widget textBox can not be applied to data type '{0}'.", currentDataType);
            }
            return null;
        }
    }
}
