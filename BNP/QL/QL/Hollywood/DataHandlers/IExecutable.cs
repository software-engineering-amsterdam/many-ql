namespace QL.Hollywood.DataHandlers
{
    public interface IExecutable
        /* All data handlers that want to be registered to QLBuilder are required to be of this type.
         * Context with all relevant (and unrelevant) data is provided.
         * Hollywood
         */
    {
        bool execute(DataContext context);
    }
}
