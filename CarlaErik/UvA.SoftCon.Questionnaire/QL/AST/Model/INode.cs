using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model
{
    public interface INode
    {
        TextPosition Position { get; }
        void Accept(IQLVisitor visitor);
        T Accept<T>(IQLVisitor<T> visitor);
    }
}
