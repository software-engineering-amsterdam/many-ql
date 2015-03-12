using AST.Nodes.Expression;
using AST.Nodes.Literals;

namespace Evaluator.Storage
{
    public interface ISymbolTable
    {
        bool IsInTable(Id id);
        Literal GetValue(Id id);
        void SetUpdateValue(Id id, Literal value);
        void AddValue(Id id, Literal value);
        
    }
}
