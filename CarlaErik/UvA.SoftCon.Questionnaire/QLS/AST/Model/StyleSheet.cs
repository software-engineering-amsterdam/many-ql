using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire style sheet AST.
    /// </summary>
    public class StyleSheet : QLSNode
    {
        public ICollection<Page> Pages
        {
            get;
            private set;
        }

        public StyleSheet(ICollection<Page> pages, TextPosition position)
            : base(position)
        {
            Pages = pages;
        }
    }
}
