using System.Windows.Controls;
using QL.AST.Nodes.Branches;

namespace QL.UI.Controls
{
    /// <summary>
    /// Forms the UI Framework base class for widgets and holds the related model class from the AST.
    /// This allows us to use databinding for UI elements to these model classess (UnitBase's)
    /// </summary>
    public abstract class WidgetBase : UserControl
    {
        protected internal UnitBase Unit { get; set; }

        protected WidgetBase(UnitBase unit)
        {
            Unit = unit;
            
            // by setting the widget's datacontext to the unit, we enable WPF's binding listeners
            DataContext = unit;
        }
    }

}
