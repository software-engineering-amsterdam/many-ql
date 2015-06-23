using Evaluation;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.FormObjects
{
    public abstract class FormObject
    {
        public virtual EventUpdateValue EventUpdateValue { get; set; }
        public abstract StackPanel InsertInUIParent(StackPanel Parent);
        public abstract SymbolTable RegisterInSymbolTable(SymbolTable symbolTable);
    }
}
