using System;
using System.Collections.ObjectModel;
using System.Linq;
using QL.AST;
using QL.DataHandlers;
using QL.Exceptions.Errors;
using QL.UI.Controls;

namespace QL.UI.Builder
{
    public class Renderer : IExecutableHandler
    {
        private readonly Action _rebuildMethod;
        public ObservableCollection<WidgetBase> ElementsToDisplay { get; private set; }

        public Renderer(ObservableCollection<WidgetBase> elementsToDisplay, Action rebuildMethod)
        {
            _rebuildMethod = rebuildMethod;
            ElementsToDisplay = elementsToDisplay;
        }

        public bool Execute(DataContext context)
        {
            try
            {
                UserInterfaceVisitor visitor = new UserInterfaceVisitor(context.ValueReferenceTable, context.ASTHandlerExceptions, ElementsToDisplay, _rebuildMethod);
                context.RootNode.Accept(visitor);
            }
            catch (QLError ex)
            {
                context.ASTHandlerExceptions.Add(ex);
                return false;
            }

            return !context.ASTHandlerExceptions.Any();
        }
    }
}
