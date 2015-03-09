using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions
{
    /// <summary>
    /// A name that uniquely defines or refers to a variable or question.
    /// </summary>
    public class Identifier : QLNode, IExpression
    {
        public string Name
        {
            get;
            private set;
        }

        internal Identifier(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override void Accept(IQLVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            if (symbolTable.Keys.Contains(Name))
            {
                return symbolTable[Name];
            }
            else
            {
                return DataType.Undefined;
            }
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
