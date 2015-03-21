namespace QL.AST.Nodes.Terminals
{
    /// <summary>
    /// A marker interface indicating the terminal can be used as a type indicator
    /// </summary>
    public interface IResolvableTerminalType : ITerminalType, ITypeStatic
    {
       
    }
}
