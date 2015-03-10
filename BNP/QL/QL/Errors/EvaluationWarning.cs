namespace QL.Errors
{
    public class EvaluationWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Evaluation warning"; }
        }
    }
}
