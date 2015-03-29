using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Validation
{
    public class SymbolTable
    {
        private IDictionary<string, DataType> _symbolTable = new Dictionary<string, DataType>();

        public void Add(string name, DataType dataType)
        {
            _symbolTable.Add(name, dataType);
        }

        public bool Contains(string name)
        {
            return _symbolTable.ContainsKey(name);
        }
    }
}
