using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    /// <summary>
    /// Represents an RGB color.
    /// </summary>
    public class Color
    {
        public int Red
        {
            get;
            private set;
        }

        public int Green
        {
            get;
            private set;
        }

        public int Blue
        {
            get;
            private set;
        }

        public static Color Black
        {
            get
            {
                return new Color(0, 0, 0);
            }
        }

        public Color(int red, int green, int blue)
        {
            Red = red;
            Green = green;
            Blue = blue;
        }

        public Color(string hexCode)
        {
            if (String.IsNullOrEmpty(hexCode)) { throw new ArgumentException("Parameter hexCode can not be null or empty."); }
            if (hexCode.Length != 6) { throw new ArgumentException("Parameter hexCode must contain exactly 6 hexadecimal digits."); }

            int red = Int32.Parse(hexCode.Substring(0, 2), NumberStyles.HexNumber);
            int green = Int32.Parse(hexCode.Substring(2, 2), NumberStyles.HexNumber);
            int blue = Int32.Parse(hexCode.Substring(4, 2), NumberStyles.HexNumber);

            Red = red;
            Green = green;
            Blue = blue;
        }
    }
}
