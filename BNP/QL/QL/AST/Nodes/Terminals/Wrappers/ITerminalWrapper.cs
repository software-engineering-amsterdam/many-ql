using System.ComponentModel;

namespace QL.AST.Nodes.Terminals.Wrappers
{
    public interface ITerminalWrapper : INotifyPropertyChanged
    {
        void SetValue(object value);
    }

}
