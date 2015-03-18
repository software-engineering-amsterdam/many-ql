using AST.Nodes.Expressions;
using AST.Nodes.Interfaces;

namespace AST.Nodes.FormObjects
{
    public class Question : FormObject, IHasType
    {
        public Label Label {get; private set;}
        public Expression Computation {get; private set;}
        public Id Identifier {get; private set;}
        private Types.Type type;

        public Question(Id identifier,
                        Types.Type type,
                        Label label,
                        Expression computation,
                        PositionInText positionInText)
            : base(positionInText)
        {
            this.Identifier = identifier;
            this.type = type;
            this.Label = label;
            this.Computation = computation;
        }
        public override T Accept<T>(VisitorInterfaces.IFormObjectVisitor<T> visitor)
        { return visitor.Visit(this); }


        public Types.Type RetrieveType()
        {
            return this.type;
        }
    }
}
