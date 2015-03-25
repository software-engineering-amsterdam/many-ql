using System;
using QL.AST;
using QL.AST.Nodes;

namespace QL.Exceptions.Warnings
{
    /// <summary>
    /// Base class for all QL Warnings 
    /// </summary>
    public class QLWarning : QLBaseException
    {
        public override string Origin
        {
            get { return GetType().Name; }
        }

        public QLWarning()
        {
        }

        public QLWarning(string message)
            : base(message)
        {
        }

        public QLWarning(string message, Exception inner)
            : base(message, inner)
        {
        }

        public QLWarning(string message, ElementBase source)
            : base(message, source)
        {
        }

        public QLWarning(string message, SourceLocation source)
            : base(message, source)
        {
        }
    }
}