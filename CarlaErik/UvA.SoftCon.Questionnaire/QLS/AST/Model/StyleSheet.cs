using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire style sheet AST.
    /// </summary>
    public class StyleSheet : QLSNode
    {
        public IEnumerable<Page> Pages
        {
            get;
            private set;
        }

        internal StyleSheet(IEnumerable<Page> pages, TextPosition position)
            : base(position)
        {
            Pages = pages;
        }
    }
}
