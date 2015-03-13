using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.widget
{
    public class Checkbox : QLSNode
    {
        public bool IsComputed
        {
            get;
            private set;
        }

    }
}
