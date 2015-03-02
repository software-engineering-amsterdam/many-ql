using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
    public interface INode
    {
        NodeType Type { get; }
        TextPosition Position { get; }
        void Accept(IASTVisitor visitor);
        T Accept<T>(IASTVisitor<T> visitor);
    }
}
