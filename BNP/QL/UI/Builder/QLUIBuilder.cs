using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.AST;

namespace QL.UI.Builder
{
    public sealed class QLUIBuilder : QLBuilder
    {
        public void RegisterGenericAndUIDataHandlers()
        {
            RegisterGenericDataHandlers();
            RegisterRenderer(new Renderer());
            //private readonly IList<WidgetBase> _elementsToDisplay;
        
        }
    }
}
