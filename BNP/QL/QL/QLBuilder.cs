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
        protected IList<IExecutable> Initializers;
        protected IList<IExecutable> ASTBuilders;
        protected IList<IExecutable> TypeCheckers;
        protected IList<IExecutable> Evaluators;
        protected IList<IExecutable> Renderers;
        protected IList<IExecutable> Exporters;

        public readonly DataContext DataContext; //needs to be public because of tests
        public IList<Exception> Errors { get; private set; }
        
        public QLBuilder()
        {
            Initializers = new List<IExecutable>();
            ASTBuilders = new List<IExecutable>();
            TypeCheckers = new List<IExecutable>();
            Evaluators = new List<IExecutable>();
            Renderers = new List<IExecutable>();
            Exporters = new List<IExecutable>();

            DataContext = new DataContext();
            Errors = new List<Exception>();
        }

        public QLBuilder(string input) : this()
        {
            SetInput(input);
        }

        public QLBuilder(Stream input) : this()
        {
            SetInput(input);
        }

        public void RegisterInitializer(IExecutable handler)
        {
            Initializers.Add(handler);
        }

        public void RegisterAstBuilder(IExecutable handler)
        {
            ASTBuilders.Add(handler);
        }

        public void RegisterTypeChecker(IExecutable handler)
        {
            TypeCheckers.Add(handler);
        }

        public void RegisterEvaluator(IExecutable handler)
        {
            Evaluators.Add(handler);
        }

        public void RegisterRenderer(IExecutable handler)
        {
            Renderers.Add(handler);
        }

        public void RegisterExporter(IExecutable handler)
        {
            Exporters.Add(handler);
        }


        private bool RunOneLevel(IEnumerable<IExecutable> thisLevelHandlers)
        {
            bool successfulExecution = true;

            foreach (IExecutable handler in thisLevelHandlers)
            {
                try
                {
                    successfulExecution = handler.execute(DataContext);
                }
                catch (QLException ex)
                {
                    DataContext.ASTHandlerExceptions.Add(ex);
                    successfulExecution = false;

                }
                catch (Exception ex)
                {
                    //not known exception!
                    Errors.Add(ex);
                    successfulExecution = false;

                }

                if (!successfulExecution)
                {
                    break;
                }
            }

            return successfulExecution;
        }

        public bool RunInit()
        {
            DataContext.InputSet = RunOneLevel(Initializers);
            return DataContext.InputSet;
        }

        public bool RunAstBuild()
        {
            if (!DataContext.InputSet)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }

            DataContext.AstBuilt = RunOneLevel(ASTBuilders);
            return DataContext.AstBuilt;
        }

        public bool RunTypeCheck()
        {

            if (!DataContext.AstBuilt)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            DataContext.TypeChecked = RunOneLevel(TypeCheckers);
            return DataContext.TypeChecked;

        }

        public bool RunEvaluate()
        {

            if (!DataContext.TypeChecked)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            DataContext.Evaluated = RunOneLevel(Evaluators);
            return DataContext.Evaluated;

        }

        public bool RunRender()
        {

            if (!DataContext.Evaluated)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            DataContext.Rendered = RunOneLevel(Renderers);
            return DataContext.Rendered;

        }

        public bool RunExport()
        {

            if (!DataContext.Evaluated)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("Evaluation not completed successfuly"));
                return false;
            }
            return RunOneLevel(Exporters);

        }

        public void RegisterGenericDataHandlers()
        {
            RegisterInitializer(new Initializer());
            RegisterAstBuilder(new AstBuilder());
            RegisterTypeChecker(new TypeChecker());
            RegisterEvaluator(new Evaluator());
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
