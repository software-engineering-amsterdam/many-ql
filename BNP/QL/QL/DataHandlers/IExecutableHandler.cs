using QL.AST;

namespace QL.DataHandlers
{
    /// <summary>
    /// All data handlers that want to be registered to QLBuilder are required to be of this type.
    /// Context with all relevant (and unrelevant) data is provided.
    /// </summary>
    public interface IExecutableHandler
    {
        bool Execute(DataContext context);
    }
}
