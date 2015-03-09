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

        public QuestionUnit(Identifier identifier, IResolvableTerminalType dataType, string displayText, bool required, params string[] parameters)
        {
            Identifier = identifier; 
            DataType = dataType;
            DisplayText = displayText;
            Required = required;
            Parameters = parameters;
        }

        public QuestionUnit(Identifier identifier, Text displayText, bool required)
        {
            Required = required;
            Identifier = identifier;
            DisplayText = displayText.ToString();
        }        
    }
}
