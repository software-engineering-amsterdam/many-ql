using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public class FontName : StyleAttribute
    {
        public string Name
        {
            get;
            private set;
        }

        internal FontName(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
