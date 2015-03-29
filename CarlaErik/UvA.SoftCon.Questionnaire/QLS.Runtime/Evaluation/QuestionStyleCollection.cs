using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation
{
    /// <summary>
    /// Contains the style sets for a collection of questions.
    /// </summary>
    public class QuestionStyleCollection
    {
        private IDictionary<string, StyleSet> _questionStyles = new Dictionary<string, StyleSet>();

        public StyleSet GetStyleSet(string questionName)
        {
            return _questionStyles[questionName];
        }

        public void AddStyleSet(string questionName, StyleSet styleSet)
        {
            _questionStyles.Add(questionName, styleSet);
        }
    }
}
