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
        public bool Required;

        public QuestionUnit()
        { }

        public QuestionUnit(Identifier id, ITerminalType dataType, string displayText, bool required, params string[] parameters)
        {
            Id = id; 
            DataType = dataType;
            DisplayText = displayText;
            Required = required;
            Parameters = parameters;
        }

        public QuestionUnit(Identifier id, Text displayText, bool required)
        {
            Required = required;
            Id = id;
            DisplayText = displayText.ToString();
        }
    }
}
