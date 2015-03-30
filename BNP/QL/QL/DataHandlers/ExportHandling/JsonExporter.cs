using System.Collections.Generic;
using System.Linq;
using Newtonsoft.Json;
using QL.AST;
using QL.Exceptions.Errors;

namespace QL.DataHandlers.ExportHandling
{
    public class JsonExporter : IExecutableHandler
    {
        public JsonExporter()
        { }

        public bool Execute(DataContext context)
        {
            context.ASTHandlerExceptions.Clear();
            
            IDictionary<string, object> unitsToAnswers = new Dictionary<string, object>();
            ExporterVisitor exporter = new ExporterVisitor(unitsToAnswers);
            
            try
            {
                context.RootNode.Accept(exporter);
            }
            catch (QLError ex)
            {
                // Errors preventing exporter from finishing
                context.ASTHandlerExceptions.Add(ex);
                return false;
            }
            finally
            {
                context.ExportableRepresentation = JsonConvert.SerializeObject(unitsToAnswers, Formatting.Indented);
            }

            return !context.ASTHandlerExceptions.Any();
        }
    }
}
