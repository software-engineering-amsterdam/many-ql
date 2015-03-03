using System.Collections.Generic;
using System.Linq;
using QL.Errors;
using QL.Evaluation;
using QL.Model.Terminals;
using System;

namespace QL.Model
{
    public class AstHandler
    {
        public ElementBase RootNode { get; private set; }//TODO change to form
        public IList<QLError> TypeCheckerErrors { get; private set; }
        public IList<QLError> EvaluationErrors { get; private set; }
        public IDictionary<Identifier, Type> TypeReference;

        public AstHandler(ElementBase root)
        {
            RootNode = root;
            TypeCheckerErrors = new List<QLError>();
            EvaluationErrors = new List<QLError>();
            TypeReference = new Dictionary<Identifier, Type>();
        }
        
        public bool CheckType()
        {
            var typeChecker = new TypeCheckerVisitor(TypeReference);
            try
            {
                RootNode.Accept(typeChecker);
                TypeCheckerErrors = typeChecker.Errors;
            } catch (QLError q) {
                /*
                These exceptions are caught because of something, 
                 * not directly related with type checking,
                 * is preventing from finishing the type checking.
                 
                */
                TypeCheckerErrors.Add(q);
                return true;
            }
            //why the hell c# does not have try-catch-else?
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
