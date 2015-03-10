namespace QL.Errors
{
    public class EvaluationError : QLError
    {
        public override string Origin
        {
            get { return "Evaluator"; }
        }
    }
}
