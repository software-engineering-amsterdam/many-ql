using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Section : QLSNode
    {
        public IEnumerable<QuestionStyle> Question_Styles
        {
            get;
            private set;

        }
        public IEnumerable<Default_styles> Default_styles
        {
            get;
            private set;
        }
        internal Section(TextPosition position)
            : base(position) 
        {
            Question_Styles = Question_Styles;
            Default_styles = Default_styles;
        }
    }
}
