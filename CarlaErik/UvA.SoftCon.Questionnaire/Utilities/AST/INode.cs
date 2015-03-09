using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Utilities.AST
{
    public interface INode
    {
        TextPosition Position { get; }
    }
}
