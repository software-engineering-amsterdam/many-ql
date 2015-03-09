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
        public Form RootNode { get; private set; }
        
        public IList<QLError> TypeCheckerErrors { get; private set; }        // TODO | maybe merge warnings & errors
        public IList<QLWarning> TypeCheckerWarnings { get; private set; }    // TODO | after UI has completed
        public IList<QLError> EvaluationErrors { get; private set; }
        public IList<QLWarning> EvaluationWarnings { get; private set; }
        
        public IDictionary<Identifier, Type> TypeReference { get; private set; }
        public IDictionary<ITypeResolvable, IResolvableTerminalType> ReferenceLookupTable { get; private set; } // a lookup of references to terminals

        // todo add lexer listeners here to store parse errors as well

        public AstHandler(Form root)
        {
            RootNode = root;
            TypeCheckerErrors = new List<QLError>();
            TypeCheckerWarnings = new List<QLWarning>();
            EvaluationErrors = new List<QLError>();
            TypeReference = new SortedDictionary<Identifier, Type>();
            ReferenceLookupTable = null;
        }

        public bool CheckType()
        {
            TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(TypeReference, TypeCheckerErrors, TypeCheckerWarnings);
            try
            {
                RootNode.Accept(typeChecker);
            }
            catch (QLError ex)
            {
                /*
                These exceptions are caught because of something, 
                 * not directly related with type checking,
                 * is preventing from finishing the type checking.
                */
                TypeCheckerErrors.Add(ex);
                return false;
            }

            return !TypeCheckerErrors.Any();
        }

        public bool Evaluate()
        {
            EvaluatorVisitor evaluator = new EvaluatorVisitor(EvaluationErrors, EvaluationWarnings);
            try
            {
                RootNode.Accept(evaluator);
                ReferenceLookupTable = evaluator.GetValuesIfNoErrors();
            }
            catch (QLError ex)
            {
                EvaluationErrors.Add(ex);
                return false;
            }

            return !EvaluationErrors.Any();
        }
    }
}
