using System.Collections.Generic;
using System.Linq;
using QL.Errors;
using QL.Evaluation;

namespace QL.Model
{
    public class AstHandler
    {
        public ElementBase RootNode { get; private set; }//TODO change to form
        public IList<QLError> TypeCheckerErrors { get; private set; }
        public IList<QLError> EvaluationErrors { get; private set; }

        public AstHandler(ElementBase root)
        {
            RootNode = root;
            TypeCheckerErrors = new List<QLError>();
            EvaluationErrors = new List<QLError>();
        }
        
        public bool CheckType()
        {
            var typeChecker = new TypeCheckerVisitor();
            RootNode.Accept(typeChecker);

            TypeCheckerErrors = typeChecker.Errors;
            return typeChecker.Errors.Any();
        }

        public bool Evaluate()
        {
            EvaluatorVisitor evaluator = new EvaluatorVisitor();
            RootNode.Accept(evaluator);

            EvaluationErrors = evaluator.Errors;
            return evaluator.Errors.Any();
        }
    }
}
