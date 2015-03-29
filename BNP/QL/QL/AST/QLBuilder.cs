using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using QL.AST.ASTCreation;
using QL.DataHandlers;
using QL.DataHandlers.Evaluation;
using QL.DataHandlers.InputHandling;
using QL.DataHandlers.TypeChecking;
using QL.Exceptions;
using QL.Exceptions.Errors;

namespace QL.AST
{
    /// <summary>
    /// This is the god class.
    /// After putting source as into the constructor, this class accumulates all the information
    /// made by evaluator, type checker ...
    /// </summary>
    public class QLBuilder
    {
        protected IList<IExecutableHandler> Initializers { get; set; }
        protected IList<IExecutableHandler> ASTBuilders { get; set; }
        protected IList<IExecutableHandler> TypeCheckers { get; set; }
        protected IList<IExecutableHandler> Evaluators { get; set; }
        protected IList<IExecutableHandler> Renderers { get; set; }
        protected IList<IExecutableHandler> Exporters { get; set; }

        public QLBuilderStateMachine BuilderStateMachine { get; private set; }
        public DataContext DataContext { get; private set; }
        public IList<Exception> UnhandledExceptions { get; private set; }
        public ReadOnlyObservableCollection<QLBaseException> QLExceptions
        {
            get { return new ReadOnlyObservableCollection<QLBaseException>(DataContext.ASTHandlerExceptions); }
        }

        #region Constructors
        protected QLBuilder()
        {
            Initializers = new List<IExecutableHandler>();
            ASTBuilders = new List<IExecutableHandler>();
            TypeCheckers = new List<IExecutableHandler>();
            Evaluators = new List<IExecutableHandler>();
            Renderers = new List<IExecutableHandler>();
            Exporters = new List<IExecutableHandler>();

            BuilderStateMachine = new QLBuilderStateMachine();
            UnhandledExceptions = new List<Exception>();
        }

        public QLBuilder(string input) : this()
        {
            DataContext = new DataContext(input);
        }

        public QLBuilder(Stream input) : this()
        {
            DataContext = new DataContext(input);
        }
        #endregion

        #region Handler level registration
        public void RegisterInitializer(IExecutableHandler handler)
        {
            Initializers.Add(handler);
        }

        public void RegisterASTBuilder(IExecutableHandler handler)
        {
            ASTBuilders.Add(handler);
        }

        public void RegisterTypeChecker(IExecutableHandler handler)
        {
            TypeCheckers.Add(handler);
        }

        public void RegisterEvaluator(IExecutableHandler handler)
        {
            Evaluators.Add(handler);
        }

        public void RegisterRenderer(IExecutableHandler handler)
        {
            Renderers.Add(handler);
        }

        public void RegisterExporter(IExecutableHandler handler)
        {
            Exporters.Add(handler);
        }
        #endregion

        #region Handler level runners
        public bool RunInit()
        {
            BuilderStateMachine.InputIsSet = RunHandlerLevel(Initializers);
            return BuilderStateMachine.InputIsSet;
        }

        public bool RunASTBuilders()
        {
            if (!BuilderStateMachine.InputIsSet)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }

            BuilderStateMachine.ASTIsBuilt = RunHandlerLevel(ASTBuilders);
            return BuilderStateMachine.ASTIsBuilt;
        }

        public bool RunTypeCheckers()
        {
            if (!BuilderStateMachine.ASTIsBuilt)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            BuilderStateMachine.TypeIsChecked = RunHandlerLevel(TypeCheckers);
            return BuilderStateMachine.TypeIsChecked;
        }

        public bool RunEvaluators()
        {
            if (!BuilderStateMachine.TypeIsChecked)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            BuilderStateMachine.IsEvaluated = RunHandlerLevel(Evaluators);
            return BuilderStateMachine.IsEvaluated;
        }

        public bool RunRenderers()
        {
            if (!BuilderStateMachine.IsEvaluated)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            BuilderStateMachine.IsRendered = RunHandlerLevel(Renderers);
            return BuilderStateMachine.IsRendered;
        }

        public bool RunExporters()
        {
            if (!BuilderStateMachine.IsEvaluated)
            {
                DataContext.ASTHandlerExceptions.Add(new QLError("Evaluation not completed successfuly"));
                return false;
            }
            return RunHandlerLevel(Exporters);
        }
        #endregion

        /// <summary>
        /// Runs all registrerd handlers. If any error occurs, returns false but continues running if possible.
        /// </summary>
        public bool RunAllHandlers()
        {
            bool retVal = false;
            retVal |= RunInit();
            retVal |= RunASTBuilders();
            retVal |= RunTypeCheckers();
            retVal |= RunEvaluators();
            retVal |= RunRenderers();
            retVal |= RunExporters();
            return retVal;
        }

        private bool RunHandlerLevel(IEnumerable<IExecutableHandler> levelHandlerList)
        {
            bool successfulExecution = true;

            foreach (IExecutableHandler handler in levelHandlerList)
            {
                try
                {
                    successfulExecution = handler.Execute(DataContext);
                }
                catch (QLBaseException ex)
                {
                    DataContext.ASTHandlerExceptions.Add(ex);
                    successfulExecution = false;
                }
                catch (Exception ex)
                {   //not known exception!
                    UnhandledExceptions.Add(ex);
                    successfulExecution = false;
                }

                if (!successfulExecution)
                {
                    break;
                }
            }
            return successfulExecution;
        }

        public void RegisterGenericDataHandlers()
        {
            RegisterInitializer(new Initializer());
            RegisterASTBuilder(new ASTBuilder());
            RegisterTypeChecker(new TypeChecker());
            RegisterEvaluator(new Evaluator());
        }
    }
}
