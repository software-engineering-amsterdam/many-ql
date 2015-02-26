namespace QL.Model.Terminals
{
    /// <summary>
    /// Identifies a class as a terminal of a given .NET CLR type
    /// </summary>
    /// <typeparam name="T">The .net representation of the terminal's value</typeparam>
    public interface ITerminal<T>
    {
        T Value { get; }
    }
}