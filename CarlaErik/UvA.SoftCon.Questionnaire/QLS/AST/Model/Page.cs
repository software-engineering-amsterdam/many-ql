using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Page : QLSNode
    {
        public IEnumerable<Section> Sections
        {
            get;
            private set;
        }

        internal Page(IEnumerable<Section> sections, TextPosition position)
            : base(position)
        {
            Sections = sections;
        }
    }
}
