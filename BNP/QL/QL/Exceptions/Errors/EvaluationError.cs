namespace QL.Exceptions.Errors
{
    public class EvaluationError : QLError
    {
        public EvaluationError(string message) : base(message)
        { }

        public override string Origin
        {
            get { return "Evaluator"; }
        }
    }
}
