using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation
{
    public class ValueTable
    {
        private IDictionary<string, Value> _valueTable = new Dictionary<string, Value>();

        public void Add(string name, Value value)
        {
            _valueTable.Add(name, value);
        }

        public bool HasValue(string name)
        {
            return _valueTable.ContainsKey(name);
        }

        public Value Get(string name)
        {
            return _valueTable[name];
        }
    }
}
