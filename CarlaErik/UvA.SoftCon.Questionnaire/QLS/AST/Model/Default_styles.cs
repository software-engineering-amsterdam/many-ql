using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Default_styles: QLSNode
    {
        public IEnumerable<Style_attr> Style_attri
        {
            get;
            private set;
        }

        internal Default_styles(IEnumerable<Style_attr> style_attri, TextPosition position)
            : base(position)
        {
            Style_attri = style_attri;
        }
    }
}
