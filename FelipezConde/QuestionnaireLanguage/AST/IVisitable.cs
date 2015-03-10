using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST
{
    public interface IVisitable
    {
        void Accept(IVisitor visitor);
        T Accept<T>(IVisitor<T> visitor);
    }
}
