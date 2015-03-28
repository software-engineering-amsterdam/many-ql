using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QLS
{
    internal abstract class ASTChecker : QLSVisitor<object>
    {
        protected ValidationReport Report
        {
            get;
            set;
        }

        public virtual void Validate(StyleSheet styleSheet, ValidationReport report)
        {
            Report = report;
            VisitStyleSheet(styleSheet);
        }
    }
}
