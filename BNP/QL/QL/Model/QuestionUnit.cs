using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public class QuestionUnit : UnitBase
    {
        public string[] Parameters { get; private set; }
        public bool Required;
        public QuestionUnit(Identifier id, string displayText, params string[] parameters)
        {
            Parameters = parameters;
            Id = id; 
            DisplayText = displayText;
        }
        public QuestionUnit(Identifier id, Text displayText, bool required)
        {
            Required = required;
            Id = id;
            DisplayText = displayText.ToString();
        }
    }
}
