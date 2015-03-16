
namespace AST.Types
{
    public class StringType : Type
    {
        public override bool IsString()
        {
            return true;
        }

        public override bool IsEqual(Type type)
        {
            return type.IsString();
        }

        //public override void Accept(Visitors.ITypeVisitor visitor)
        //{
        //    visitor.Visit(this);
        //}

        public override T Accept<T>(Visitors.ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string GetString()
        {
            return "string";
        }
    }
}
