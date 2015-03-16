using AST.Nodes.Expressions;
using AST.Nodes.Interfaces;
using AST.Nodes.Labels;

namespace AST.Nodes.FormObjects
{
    public class Question : FormObject, IHasType
    {
        public Label Label {get; private set;}
        public BaseExpression Computation {get; private set;}
        public Id Identifier {get; private set;}
        private Types.Type type;

        public Question(Id identifier,
                        Types.Type type,
                        Label label,
                        BaseExpression computation,
                        PositionInText positionInText)
            : base(positionInText)
        {
            this.Identifier = identifier;
            this.type = type;
            this.Label = label;
            this.Computation = computation;
        }
        public override T Accept<T>(ASTVisitors.Interfaces.IFormObjectVisitor<T> visitor)
        { return visitor.Visit(this); }


        public Types.Type RetrieveType()
        {
            return this.type;
        }
    }
}
