using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
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

        public TextPosition(int line, int column)
        {
            Line = line;
            Column = column;
        }
    }
}
