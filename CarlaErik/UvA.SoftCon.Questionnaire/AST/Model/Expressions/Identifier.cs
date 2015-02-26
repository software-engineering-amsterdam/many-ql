using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    /// <summary>
    /// A name that uniquely defines or refers to a variable or question.
    /// </summary>
    public class Identifier : Node, IExpression
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.Identifier;
            }
        }

        public string Name
        {
            get;
            private set;
        }

        public Identifier(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            if (symbolTable.Keys.Contains(Name))
            {
                return symbolTable[Name];
            }
            else
            {
                return null;
            }
        }

        public IValue Evaluate(IDictionary<string, IValue> environment)
        {
            if (environment.Keys.Contains(Name))
            {
                return environment[Name];
            }
            else
            {
                return null;
            }
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
