namespace QL.Errors
{
    public class TypeCheckerWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Typechecker warning"; }
        }

    }
}
