using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation.StyleSets
{
    /// <summary>
    /// Holds all style attributes that apply to a particular data type or question.
    /// </summary>
    public class StyleSet
    {
        private const string DefaultFontName = "Microsoft Sans Serif";
        private const int DefaultFontSize = 8;
        private const string DefaultColor = "#000000"; // Black

        public string Color
        {
            get;
            private set;
        }

        public string FontName
        {
            get;
            private set;
        }

        public int FontSize
        {
            get;
            private set;
        }

        public WidgetStyle WidgetStyle
        {
            get;
            private set;
        }

        public static StyleSet Default(DataType dataType)
        {
            WidgetStyle defaultWidget;

            switch (dataType)
            {
                case DataType.Boolean:
                    defaultWidget = CheckBoxWidgetStyle.Default;
                    break;
                case DataType.Date:
                    defaultWidget = CalendarWidgetStyle.Default;
                    break;
                case DataType.Integer:
                    defaultWidget = SpinBoxWidgetStyle.Default;
                    break;
                case DataType.String:
                    defaultWidget = TextBoxWidgetStyle.Default;
                    break;
                default:
                    string message = String.Format("There is no default widget configured for data type '{0}'.", StringEnum.GetStringValue(dataType));
                    throw new NotSupportedException(message);
            }

            return new StyleSet(DefaultColor, DefaultFontName, DefaultFontSize, defaultWidget);
        }

        private StyleSet(string color, string fontName, int fontSize, WidgetStyle widgetStyle)
        {
            Color = color;
            FontName = fontName;
            FontSize = fontSize;
            WidgetStyle = widgetStyle;
        }

        private StyleSet(StyleSet styleSet)
        {
            Color = styleSet.Color;
            FontName = styleSet.FontName;
            FontSize = styleSet.FontSize;
            WidgetStyle = styleSet.WidgetStyle;
        }

        public StyleSet GetCopy()
        {
            return new StyleSet(this);
        }

        public void OverrideStyles(IEnumerable<StyleAttribute> styleAttributes)
        {
            foreach (var styleAttribute in styleAttributes)
            {
                OverrideStyle(styleAttribute);
            }
        }

        private void OverrideStyle(StyleAttribute styleAttribute)
        {
            throw new InvalidOperationException();
        }

        private void OverrideStyle(ColorStyle color)
        {
            Color = color.RGBCode;
        }

        private void OverrideStyle(FontName fontName)
        {
            FontName = fontName.Name;
        }

        private void OverrideStyle(FontSize fontSize)
        {
            FontSize = fontSize.Size;
        }

        private void OverrideStyle(Calendar calender)
        {
            WidgetStyle = new CalendarWidgetStyle();
        }

        private void OverrideStyle(CheckBox checkBox)
        {
            WidgetStyle = new CheckBoxWidgetStyle();
        }

        private void OverrideStyle(DropDown dropDown)
        {
            WidgetStyle = new DropDownWidgetStyle(dropDown.TrueLabel, dropDown.FalseLabel);
        }

        private void OverrideStyle(RadioButtons radio)
        {
            WidgetStyle = new RadioWidgetStyle(radio.TrueLabel, radio.FalseLabel);
        }

        private void OverrideStyle(SpinBox spinBox)
        {
            WidgetStyle = new SpinBoxWidgetStyle();
        }

        private void OverrideStyle(TextBox textBox)
        {
            WidgetStyle = new TextBoxWidgetStyle();
        }
    }
}
