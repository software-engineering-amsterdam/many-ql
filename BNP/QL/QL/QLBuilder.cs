using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using Antlr4.Runtime;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Exceptions.Warnings;
using QL.Visitors;
using QL.Grammars;
using QL.Infrastructure;
using QL.Model;
using QL.Model.Terminals;
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
        IList<IList<IExecutable>> _handlerContainer;
        public DataContext dataContext;//needs to be public because of tests

        public IList<Exception> Errors { get; private set; }


        public QLBuilder()
        {          
        _initializers=new List<IExecutable>();
        _astBuilders=new List<IExecutable>();
        _typeCheckers=new List<IExecutable>();
        _evaluators=new List<IExecutable>();
        _renderers=new List<IExecutable>();
        _exporters=new List<IExecutable>();
        _handlerContainer = new List<IList<IExecutable>>();

        _handlerContainer.Add(_initializers);
        _handlerContainer.Add(_astBuilders);
        _handlerContainer.Add(_typeCheckers);
        _handlerContainer.Add(_evaluators);
        _handlerContainer.Add(_renderers);
        _handlerContainer.Add(_exporters);

        Errors = new List<Exception>();
        dataContext = new DataContext();

        }

        public QLBuilder(string input):this()
        {
            SetInput(input);
        }
        public QLBuilder(Stream input): this()
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
       

        bool runOneLevel(IList<IExecutable> thisLevelHandlers)
        {
            bool successfulExecution = true;

            foreach (IExecutable handler in thisLevelHandlers)
            {
                try
                {
                    successfulExecution = handler.execute(dataContext);
                }
                catch (QLException e)
                {
                    dataContext.ASTHandlerExceptions.Add(e);
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
            dataContext.InputSet = runOneLevel(_initializers);
            return dataContext.InputSet;

        }
        public bool runAstBuild()
        {
            if (!dataContext.InputSet)
            {
                dataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }

            dataContext.AstBuilt= runOneLevel(_astBuilders);
            return dataContext.AstBuilt;

        }
        public bool runTypeCheck()
        {

            if (!dataContext.AstBuilt)
            {

                dataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            dataContext.TypeChecked = runOneLevel(_typeCheckers);
            return dataContext.TypeChecked;

        }
        public bool runEvaluate()
        {

            if (!dataContext.TypeChecked)
            {
                dataContext.ASTHandlerExceptions.Add(new QLError("previous step not completed successfuly"));
                return false;
            }
            dataContext.Evaluated= runOneLevel(_evaluators);
            return dataContext.Evaluated;

        }
        public bool runRender()
        {

            if (!dataContext.Evaluated)
            {
                dataContext.ASTHandlerExceptions.Add( new QLError("previous step not completed successfuly"));
                return false;
            }
            dataContext.Rendered = runOneLevel(_renderers);
            return dataContext.Rendered;

        }
        public bool runExport()
        {

            if (!dataContext.Evaluated)
            {
                dataContext.ASTHandlerExceptions.Add(new QLError("Evaluation not completed successfuly"));
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
            dataContext.Input = input;
            
        }

        public void SetInput(Stream input)
        {
            dataContext.InputStream = input;
            
        }
    }
}
