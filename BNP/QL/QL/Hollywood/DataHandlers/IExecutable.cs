namespace QL.Hollywood.DataHandlers
{
    /// <summary>
    /// All data handlers that want to be registered to QLBuilder are required to be of this type.
    /// Context with all relevant (and unrelevant) data is provided.
    /// Hollywood
    /// </summary>
    public interface IExecutable
    {
        bool Execute(DataContext context);
    }
}
