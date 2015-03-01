using System.Collections.Generic;
using System.Linq;
using QL.Evaluation;
using QL.Exceptions;

namespace QL.Model
{
    public class AstHandler
    {
        public ElementBase RootNode { get; private set; }
        public IList<QLException> TypeCheckerExceptions { get; private set; }
        public IList<QLException> EvaluationExceptions { get; private set; }

        public AstHandler(ElementBase root)
        {
            RootNode = root;
            TypeCheckerExceptions = new List<QLException>();
            EvaluationExceptions = new List<QLException>();
        }
        
        public bool CheckType()
        {
            var typeChecker = new TypeCheckerVisitor();
            RootNode.Accept(typeChecker);

            TypeCheckerExceptions = typeChecker.Exceptions;
            return typeChecker.Exceptions.Any();
        }

        public bool Evaluate()
        {
            EvaluatorVisitor evaluator = new EvaluatorVisitor();
            RootNode.Accept(evaluator);

            EvaluationExceptions = evaluator.Exceptions;
            return evaluator.Exceptions.Any();
        }
    }
}
