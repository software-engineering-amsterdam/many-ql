using AST.VisitorInterfaces;

namespace AST.Nodes.FormObjects
{
    public abstract class FormObject : Node
    {
        public FormObject(PositionInText pos)
            :base(pos)
        { }

        public abstract T Accept<T>(IFormObjectVisitor<T> visitor);

    }
}
