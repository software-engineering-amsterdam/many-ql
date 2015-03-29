using System.Collections.Generic;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals;
using QL.Exceptions;

namespace QL.AST
{
    /// <summary>
    /// An AST visitor providing only the most elementary types that need be visited
    /// </summary>
    public interface ISimpleVisitor
    {
        ReferenceTables ReferenceTables { get; }
        IList<QLBaseException> Exceptions { get; }

        void Visit(Form node);
        void Visit(Block node);
        void Visit(ControlUnit node);
        void Visit(StatementUnit node);
        void Visit(QuestionUnit node);
        void Visit(Expression node);
        
        // Fallback visitor
        void Visit(ElementBase elementBase);
    }
}
