using System;
using QL.AST.Nodes;

namespace QL.Exceptions.Errors
{
    public class TypeCheckerError : QLError
    {
        public override string Origin
        {
            get { return "Type Checker"; }
        }

        public TypeCheckerError()
        { }

        public TypeCheckerError(string message)
            : base(message)
        { }

        public TypeCheckerError(string message, ElementBase source)
            : base(message)
        {
            SourceLocation = source.SourceLocation;
        }

        public TypeCheckerError(string message, Exception inner)
            : base(message, inner)
        { }
    }
}
