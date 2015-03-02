using System.Collections.Generic;
using System.Linq;
using QL.Evaluation;
using QL.Exceptions;

namespace QL.Model
{
    public class AstHandler
    {
        public ElementBase RootNode { get; private set; }//TODO change to form
        public IList<QLError> TypeCheckerExceptions { get; private set; }
        public IList<QLError> EvaluationExceptions { get; private set; }

        public AstHandler(ElementBase root)
        {
            RootNode = root;
            TypeCheckerExceptions = new List<QLError>();
            EvaluationExceptions = new List<QLError>();
        }
        
        public bool CheckType()
        {
            var typeChecker = new TypeCheckerVisitor();
            RootNode.Accept(typeChecker);

            TypeCheckerExceptions = typeChecker.Errors;
            return typeChecker.Errors.Any();
        }

        public bool Evaluate()
        {
            EvaluatorVisitor evaluator = new EvaluatorVisitor();
            RootNode.Accept(evaluator);

            EvaluationExceptions = evaluator.Errors;
            return evaluator.Errors.Any();
        }
    }
}
