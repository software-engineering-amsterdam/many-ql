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
    public sealed class QLBuilder
    {
        protected IList<IExecutable> _initializers;
        protected IList<IExecutable> _astBuilders;
        protected IList<IExecutable> _typeCheckers;
        protected IList<IExecutable> _evaluators;
        protected IList<IExecutable> _renderers;
        protected IList<IExecutable> _exporters;
        IList<IList<IExecutable>> _handlerContainer;
        protected DataContext _dataContext;

        IList<Exception> Errors { public get; private set; }


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
            return successfulExecution;
        }


       
        public ITerminalWrapper GetWrappedValue(string IdentifierName)
        {
            //convenience method for getting the Terminal wrapper based on identifier name. 
            return GetWrappedValue(new Identifier(IdentifierName));
        }
        public ITerminalWrapper GetWrappedValue(Identifier i)
        {
            //convenience method for getting the Terminal wrapper based on Identifier node. 
            if (!_evaluated)
            {
                throw new Exception("Expressions not evaluated");
            }

            return ReferenceLookupTable[IdentifierTable[i]];
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
