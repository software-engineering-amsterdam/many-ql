using System;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;

namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    /// <summary>
    /// Holds the complete set of style attributes that can apply to a particular data type or question.
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
                styleAttribute.OverrideStyle(this);
            }
        }

        internal void OverrideColor(string color)
        {
            Color = color;
        }

        internal void OverrideFontName(string fontName)
        {
            FontName = fontName;
        }

        internal void OverrideFontSize(int fontSize)
        {
            FontSize = fontSize;
        }

        internal void OverrideWidget(WidgetStyle widgetStyle)
        {
            WidgetStyle = widgetStyle;
        }
    }
}
