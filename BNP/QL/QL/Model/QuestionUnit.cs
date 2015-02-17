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

        public QuestionUnit(Identifier id, string displayText, params string[] parameters)
        {
            Parameters = parameters;
            Id = id; 
            DisplayText = displayText;
        }
    }
}
