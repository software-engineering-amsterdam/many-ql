using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Common.AST.Model
{
    public interface INode
    {
        TextPosition Position { get; }
    }
}
