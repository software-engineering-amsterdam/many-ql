
namespace AST.Types.Visitors
{
    public interface ITypeVisitable
    {
        T Accept<T>(ITypeVisitor<T> visitor);
    }
}
