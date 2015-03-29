using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;

namespace QL.AST
{
    /// <summary>
    /// An extended AST visitor that also provides implementation contracts for Terminals and Operators
    /// </summary>
    public interface IExtendedVisitor : ISimpleVisitor
    {
        void Visit(Yesno node);
        void Visit(Number node);
        void Visit(Text node);
        void Visit(Identifier node);

        void Visit(EqualsOperator node);
        void Visit(NotEqualsOperator node);
        void Visit(GreaterThanOperator node);
        void Visit(GreaterThanEqualToOperator node);
        void Visit(LessThanOperator node);
        void Visit(LessThanEqualToOperator node);
        void Visit(MultiplicationOperator node);
        void Visit(DivisionOperator node);
        void Visit(PlusOperator node);
        void Visit(MinusOperator node);
        void Visit(AndOperator node);
        void Visit(OrOperator node);
    }
}