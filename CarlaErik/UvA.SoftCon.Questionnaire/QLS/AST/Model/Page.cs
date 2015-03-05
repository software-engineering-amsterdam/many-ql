using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Page : QLSNode
    {
        public ICollection<Section> Sections
        {
            get;
            private set;
        }

        public Page(ICollection<Section> sections, TextPosition position)
            : base(position)
        {
            Sections = sections;
        }
    }
}
