using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Model.Statements
{
    public class Declaration : Node, IStatement
    {
        public DataType DataType
        {
            get;
            private set;
        }

        public Identifier Id
        {
            get;
            private set;
        }

        public IExpression Initialization
        {
            get;
            private set;
        }

        public Declaration(DataType dataType, Identifier id, IExpression initialization)
        {
            DataType = dataType;
            Id = id;
            Initialization = initialization;
        }
    }
}
