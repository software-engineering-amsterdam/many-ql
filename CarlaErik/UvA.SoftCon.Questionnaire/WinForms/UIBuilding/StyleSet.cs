using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    public class StyleSet
    {
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

        public static StyleSet Default
        {
            get
            {
                return new StyleSet("#000000", "Microsoft Sans Serif", 8);
            }
        }

        private StyleSet(string color, string fontName, int fontSize)
        {
            Color = color;
            FontName = fontName;
            FontSize = fontSize;
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
            // Do nothing.
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
    }
}
