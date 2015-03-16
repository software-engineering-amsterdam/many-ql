using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Visitors.UIWrappers
{
    public interface IRenderable
    {
        string GetText();//question,statement
        string GetWidgetType();
        bool Editable();
        string GetValue();

    }

}
