using System;
using System.Collections.Generic;
using System.IO;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.GenericDataHandlers;

namespace QL
{
    /// <summary>
    /// This is the god class.
    ///  After putting source as into the constructor, this class accumulates all the information
    ///  made by evaluator, type checker ...
    ///  Is this good, bad? 
    /// </summary>
    public class QLBuilder
    {
        protected IList<IExecutable> _initializers;
        protected IList<IExecutable> _astBuilders;
        protected IList<IExecutable> _typeCheckers;
        protected IList<IExecutable> _evaluators;
        protected IList<IExecutable> _renderers;
        protected IList<IExecutable> _exporters;
        public readonly DataContext DataContext;//needs to be public because of tests

        public IList<Exception> Errors { get; private set; }


        public QLBuilder()
        {
            _initializers = new List<IExecutable>();
            _astBuilders = new List<IExecutable>();
            _typeCheckers = new List<IExecutable>();
            _evaluators = new List<IExecutable>();
            _renderers = new List<IExecutable>();
            _exporters = new List<IExecutable>();

            Errors = new List<Exception>();
            DataContext = new DataContext();
        }

        public QLBuilder(string input)
            : this()
        {
            SetInput(input);
        }
        public QLBuilder(Stream input)
            : this()
        {
            SetInput(input);
        }
        public void registerInitializer(IExecutable handler)
        {
            _initializers.Add(handler);
        }
        public void registerAstBuilder(IExecutable handler)
        {
            _astBuilders.Add(handler);
        }
        public void registerTypeChecker(IExecutable handler)
        {
            _typeCheckers.Add(handler);
        }
        public void registerEvaluator(IExecutable handler)
        {
            _evaluators.Add(handler);
        }
        public void registerRenderer(IExecutable handler)
        {
            _renderers.Add(handler);
        }
        public void registerExporter(IExecutable handler)
        {
            _exporters.Add(handler);
        }


        bool runOneLevel(IEnumerable<IExecutable> thisLevelHandlers)
        {
            bool successfulExecution = true;

            foreach (IExecutable handler in thisLevelHandlers)
            {
                try
                {
                    successfulExecution = handler.execute(DataContext);
                }
                catch (QLException e)
                {
                    DataContext.ASTHandlerExceptions.Add(e);
                    successfulExecution = false;

                }
                catch (Exception e)
                {
                    //not known exception!
                    Errors.Add(e);
                    successfulExecution = false;

                }

                if (!successfulExecution)
                {
                    break;
                }
            }

            return successfulExecution;
        }
        public bool runInit()
        {
            DataContext.InputSet = runOneLevel(_initializers);
            return DataContext.InputSet;

        }
        public bool runAstBuild()
        {
            if (!DataContext.InputSet)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }

            DataContext.AstBuilt = runOneLevel(_astBuilders);
            return DataContext.AstBuilt;

        }
        public bool runTypeCheck()
        {

            if (!DataContext.AstBuilt)
            {

                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            DataContext.TypeChecked = runOneLevel(_typeCheckers);
            return DataContext.TypeChecked;

        }
        public bool runEvaluate()
        {

            if (!DataContext.TypeChecked)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            DataContext.Evaluated = runOneLevel(_evaluators);
            return DataContext.Evaluated;

        }
        public bool runRender()
        {

            if (!DataContext.Evaluated)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            DataContext.Rendered = runOneLevel(_renderers);
            return DataContext.Rendered;

        }
        public bool runExport()
        {

            if (!DataContext.Evaluated)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("Evaluation not completed successfuly"));
                return false;
            }
            return runOneLevel(_exporters);

        }

        public void registerGenericDataHandlers()
        {
            registerInitializer(new Initializer());
            registerAstBuilder(new AstBuilder());
            registerTypeChecker(new TypeChecker());
            registerEvaluator(new Evaluator());



        }


        public void SetInput(string input)
        {
            DataContext.Input = input;

        }

        public void SetInput(Stream input)
        {
            DataContext.InputStream = input;

        }
    }
}
