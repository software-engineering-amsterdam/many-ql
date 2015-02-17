using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public class QuestionUnit : UnitBase
    {
        public string[] Parameters { get; private set; }

        public QuestionUnit(string id, string displayText, params string[] parameters)
        {
            Parameters = parameters;
            ID = id;
            DisplayText = displayText;
        }
    }
}
