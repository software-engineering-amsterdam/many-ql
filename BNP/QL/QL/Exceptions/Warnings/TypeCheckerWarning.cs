namespace QL.Exceptions.Warnings
{
    public class TypeCheckerWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Typechecker warning"; }
        }
    }
}
