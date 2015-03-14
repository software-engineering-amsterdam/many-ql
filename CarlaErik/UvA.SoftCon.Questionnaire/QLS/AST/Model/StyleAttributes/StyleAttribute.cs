using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public abstract class StyleAttribute : QLSNode
    {
        protected StyleAttribute(TextPosition position)
            : base(position) { }
    }
}
