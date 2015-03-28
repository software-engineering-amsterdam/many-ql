using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    /// <summary>
    /// Holds the style attribute for a particular data type or question.
    /// </summary>
    public class StyleSet
    {
        private const string DefaultFontName = "Microsoft Sans Serif";

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

        public WidgetType WidgetType
        {
            get;
            private set;
        }

        public static StyleSet Default(DataType dataType)
        {
            WidgetType defaultWidget;

            switch (dataType)
            {
                case DataType.Boolean:
                    defaultWidget = WidgetType.CheckBox;
                    break;
                case DataType.Date:
                    defaultWidget = WidgetType.Calendar;
                    break;
                case DataType.Integer:
                    defaultWidget = WidgetType.SpinBox;
                    break;
                case DataType.String:
                    defaultWidget = WidgetType.TextBox;
                    break;
                default:
                    string message = String.Format("There is no default widget configured for data type '{0}'.", StringEnum.GetStringValue(dataType));
                    throw new NotSupportedException(message);
            }

            return new StyleSet("#000000", DefaultFontName, 8, defaultWidget);
        }

        private StyleSet(string color, string fontName, int fontSize, WidgetType widgetType)
        {
            Color = color;
            FontName = fontName;
            FontSize = fontSize;
            WidgetType = widgetType;
        }

        private StyleSet(StyleSet styleSet)
        {
            Color = styleSet.Color;
            FontName = styleSet.FontName;
            FontSize = styleSet.FontSize;
            WidgetType = styleSet.WidgetType;
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

        private void OverrideStyle(StyleAttribute color)
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
            WidgetType = WidgetType.Calendar;
        }

        private void OverrideStyle(CheckBox checkBox)
        {
            WidgetType = WidgetType.CheckBox;
        }

        private void OverrideStyle(DropDown dropDown)
        {
            WidgetType = WidgetType.DropDown;
        }

        private void OverrideStyle(RadioButtons radio)
        {
            WidgetType = WidgetType.RadioButtons;
        }

        private void OverrideStyle(SpinBox spinBox)
        {
            WidgetType = WidgetType.SpinBox;
        }

        private void OverrideStyle(TextBox textBox)
        {
            WidgetType = WidgetType.TextBox;
        }
    }
}
