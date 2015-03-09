using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model
{
    public interface IQLNode : INode
    {
        void Accept(IQLVisitor visitor);

        T Accept<T>(IQLVisitor<T> visitor);
    }
}
