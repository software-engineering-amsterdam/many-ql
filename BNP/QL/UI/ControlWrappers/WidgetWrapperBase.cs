using System.Windows.Controls;
using QL.Model;
using QL.Model.Terminals.Wrappers;

namespace QL.UI.ControlWrappers
{
    public abstract class WidgetWrapperBase
    {
        protected UnitBase Unit;
        protected TerminalWrapper TerminalWrapper;

        public abstract string Identifier { get; }

        /// <summary>
        /// Display text of the widget
        /// </summary>
        public abstract object Text { get; }

        /// <summary>
        /// Holds the value of the widget
        /// </summary>
        public abstract object Value { get; set; }

        /// <summary>
        /// Gets a widget instance for this wrapper
        /// </summary>
        /// <returns></returns>
        public abstract UserControl GetWidget();

        protected WidgetWrapperBase(UnitBase unit)
        {
            Unit = unit;
        }
    }

}
