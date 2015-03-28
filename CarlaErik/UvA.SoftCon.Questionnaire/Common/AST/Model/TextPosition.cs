using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Common.AST.Model
{
    /// <summary>
    /// Represents a character position in a text file.
    /// </summary>
    public class TextPosition
    {
        public int Line
        {
            get;
            private set;
        }

        public int Column
        {
            get;
            private set;
        }

        public static TextPosition None
        {
            get
            {
                return new TextPosition();
            }
        }

        private TextPosition()
        {
            Line = -1;
            Column = -1;
        }

        public TextPosition(int line, int column)
        {
            if (line < 0) { throw new ArgumentException("Parameter line must be equal to or greater than zero."); }
            if (column < 0) { throw new ArgumentException("Parameter column must be equal to or greater than zero."); }

            Line = line;
            Column = column;
        }

        public override string ToString()
        {
            if (Line >= 0)
            {
                return String.Format("Line: {0}, column: {1}", Line, Column);
            }
            else
            {
                return String.Empty;
            }
        }
    }
}
