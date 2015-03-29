using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions
{
    /// <summary>
    /// A name that uniquely defines or refers to a variable or question.
    /// </summary>
    public class Identifier : Expression
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

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
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
