using System.Collections.ObjectModel;
using System.IO;
using QL.AST;
using QL.UI.Controls;

namespace QL.UI.Builder
{
    public class QLUIBuilder : QLBuilder
    {
        public ObservableCollection<WidgetBase> ElementsToDisplay { get; protected set; }
        
        public QLUIBuilder(string input) : base(input)
        {
            ElementsToDisplay = new ObservableCollection<WidgetBase>();
        }

        public QLUIBuilder(Stream input) : base(input)
        {
            ElementsToDisplay = new ObservableCollection<WidgetBase>();
        }

        public void RegisterGenericAndUIDataHandlers()
        {
            RegisterGenericDataHandlers();
            RegisterRenderer(new Renderer(ElementsToDisplay));       
        }
    }
}
