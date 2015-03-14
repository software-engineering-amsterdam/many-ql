using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Page : QLSNode
    {
        public IEnumerable<Section> Sections
        {
            get;
            private set;
        }

        public IEnumerable<DefaultStyle> DefaultStyles
        {
            get;
            private set;
        }

        internal Page(IEnumerable<Section> sections, IEnumerable<DefaultStyle> defaultStyles, TextPosition position)
            : base(position)
        {
            Sections = sections;
            DefaultStyles = defaultStyles;
        }
    }
}
