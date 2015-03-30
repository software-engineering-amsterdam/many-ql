using System.ComponentModel;
using System.Runtime.CompilerServices;
using QL.Annotations;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    /// <summary>
    /// Provides a common ancestor for Questions and Statements with shared properties.
    /// A question is a unit as much as a statement is a unit.
    /// </summary>
    public abstract class UnitBase : ElementBase, INotifyPropertyChanged
    {
        private string _text;

        public event PropertyChangedEventHandler PropertyChanged;
        
        public IStaticReturnType DataType { get; set; }
        public Identifier Identifier { get; set; }

        public string Text
        {
            get { return _text; }
            set
            {
                if (value == _text) return;
                _text = value;
                OnPropertyChanged();
            }
        }
        public abstract object Value { get; set; }

        protected UnitBase()
        { }

        protected UnitBase(Identifier identifier, IStaticReturnType dataType, string displayText)
        {
            Identifier = identifier;
            DataType = dataType;
            Text = UnwrapQuotes(displayText);
        }

        protected UnitBase(Identifier identifier, IStaticReturnType dataType, string displayText, SourceLocation sourceLocation)
            : this(identifier, dataType, displayText)
        {
            SourceLocation = sourceLocation;
        }

        [NotifyPropertyChangedInvocator]
        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            if (PropertyChanged == null) return;
            PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
