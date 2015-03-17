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
using QL.Visitors.UIWrappers;
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
        protected DataContext _dataContext;

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
       


        public bool run()
        {
            Errors.Clear();
            bool successfulExecution=false;
            foreach (IList<IExecutable> thisLevelHandlers in _handlerContainer)
            {
                foreach (IExecutable handler in thisLevelHandlers)
                {
                    try
                    {
                        successfulExecution = handler.execute(_dataContext);
                    }
                    catch (Exception e)
                    {
                        Errors.Add(e);
                        successfulExecution= false;

                    }
                    if (!successfulExecution)
                    {
                        return successfulExecution;
                    }
                }
            }
            Errors.Union(_dataContext.ASTHandlerExceptions);
            return successfulExecution;
        }
        bool runOneLevel(IList<IExecutable> thisLevelHandlers)
        {
            bool successfulExecution = false;

            foreach (IExecutable handler in thisLevelHandlers)
            {
                try
                {
                    successfulExecution = handler.execute(_dataContext);
                }
                catch (Exception e)
                {
                    Errors.Add(e);
                    successfulExecution = false;

                }
                if (!successfulExecution)
                {
                    return successfulExecution;
                }
            }
            return true;
        }
        public bool runInit()
        {
            return runOneLevel(_initializers);

        }
        public bool runAstBuild()
        {
            return runOneLevel(_astBuilders);

        }
        public bool runTypeCheck()
        {
            return runOneLevel(_typeCheckers);

        }
        public bool runEvaluate()
        {
            return runOneLevel(_evaluators);

        }
        public bool runRender()
        {
            return runOneLevel(_renderers);

        }
        public bool runExport()
        {
            return runOneLevel(_exporters);

        }

        

        
        public void SetInput(string input)
        {
            _dataContext.Input = input;
            
        }

        public void SetInput(Stream input)
        {
            _dataContext.InputStream = input;
            
        }
    }
}
