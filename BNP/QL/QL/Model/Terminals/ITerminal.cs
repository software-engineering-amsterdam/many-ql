namespace QL.Model.Terminals
{
    public interface ITerminal<T>
    {
        T Value { get; }
    }
}