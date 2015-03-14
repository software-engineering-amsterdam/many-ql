using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.Common.AST.Building;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Section : QLSNode
    {
        public IEnumerable<QuestionStyle> QuestionStyles
        {
            get;
            private set;

        }
        public IEnumerable<DefaultStyle> DefaultStyles
        {
            get;
            private set;
        }

        internal Section(IEnumerable<QuestionStyle> questionStyles, IEnumerable<DefaultStyle> defaultStyles, TextPosition position)
            : base(position) 
        {
            QuestionStyles = questionStyles;
            DefaultStyles = defaultStyles;
        }
    }
}
