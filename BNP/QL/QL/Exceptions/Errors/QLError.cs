using System;
using QL.AST;
using QL.AST.Nodes;

namespace QL.Exceptions.Errors
{
    /// <summary>
    /// Base class for all QL Errors
    /// </summary>
    public class QLError : QLBaseException
    {
        public override string Origin
        {
            get { return GetType().Name; }
        }
        
        public QLError()
        {
        }

        public QLError(string message)
            : base(message)
        { }

        public QLError(string message, SourceLocation sourceLocation)
            : base(message)
        {
            SourceLocation = sourceLocation;
        }

        public QLError(string message, Exception inner)
            : base(message, inner)
        {
        }

        public QLError(string message, ElementBase source)
            : base(message, source)
        {
        }
    }
}
