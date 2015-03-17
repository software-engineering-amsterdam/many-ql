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
        public QuestionUnit()
        { }

        public QuestionUnit(Identifier identifier, Text displayText)
        {
            Identifier = identifier;
            DisplayText = displayText.Value;
        }

        public QuestionUnit(Identifier identifier, Text displayText, IResolvableTerminalType dataType) : this(identifier, displayText)
        {
            DataType = dataType;
        }
    }
}
