using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using Antlr4.Runtime;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Exceptions.Warnings;
using QL.Model.Terminals.Wrappers;
using QL.Visitors;
using QL.Grammars;
using QL.Infrastructure;
using QL.Model;
using QL.Model.Terminals;

namespace QL
{
    /// <summary>
    /// This is the god class.
    ///  After putting source as into the constructor, this class accumulates all the information
    ///  made by evaluator, type checker ...
    ///  Is this good, bad? 
    /// </summary>
    public sealed class ASTHandler
    {
        private readonly string _input;
        private readonly Stream _inputStream;

        /// <summary>
        /// The main form (i.e. entry point) in the AST
        /// </summary>
        public Form RootNode { get; private set; }

        /// <summary>
        /// A collection of all errors and warnings occurring during all stages of interpreting input grammar
        /// </summary>
        public ObservableCollection<QLException> ASTHandlerExceptions { get; private set; }
       
        /// <summary>
        /// Maps defined identifiers to the datatype of the value they contain
        /// </summary>
        public IDictionary<Identifier, Type> TypeReference { get; private set; }
        /// <summary>
        /// 
        /// </summary>
        public IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable { get; private set; } // a lookup of references to terminals
        public IDictionary<Identifier, ITypeResolvable> IdentifierTable;

        bool _astBuilt;
        bool _typeChecked;
        bool _evaluated;
        //bool _uiEvaluated;

        private ASTHandler()
        {
            ASTHandlerExceptions = new ObservableCollection<QLException>();
            TypeReference = new Dictionary<Identifier, Type>();
            ReferenceLookupTable = new Dictionary<ITypeResolvable, ITerminalWrapper>();
            IdentifierTable = new Dictionary<Identifier, ITypeResolvable>();
            _astBuilt = _typeChecked = _evaluated = false;
        }

        public ASTHandler(string input) : this()
        {
            _input = input;
        }

        public ASTHandler(Stream input) : this()
        {
            _inputStream = input;
        }

        public bool BuildAST()
        {
            ASTHandlerExceptions.Clear();

            AntlrInputStream inputStream;
            if (_input != null)
            {
                inputStream = new AntlrInputStream(_input);
            }
            else if (_inputStream != null)
            {
                inputStream = new AntlrInputStream(_inputStream);
            }
            else
            {
                throw new Exception("No proper input provided for building an AST");
            }

            QLLexer lexer = new QLLexer(inputStream);
            lexer.AddErrorListener(new LexerErrorHandler(ASTHandlerExceptions));

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            parser.AddErrorListener(new ParserErrorHandler(ASTHandlerExceptions));
            
            QLListener listener = new QLListener(ASTHandlerExceptions);
            parser.AddParseListener(listener);
            
            // commence parsing the input as a formBlock since it's supposed to be the entry point of the input file
            parser.formBlock();
            RootNode = listener.GetAstRootNode();
            
            _astBuilt = !ASTHandlerExceptions.Any();
            return _astBuilt;
        }


        public bool CheckType()
        {
            if (!_astBuilt)
            {
                throw new QLException("Ast is not built");
            }
            else
            {
                ASTHandlerExceptions.Clear();
            }

            TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(TypeReference, ASTHandlerExceptions);
            try
            {
                RootNode.Accept(typeChecker);
            }
            catch (QLError ex)
            {
                /* Exceptions preventing TypeChecker from finishing */
                ASTHandlerExceptions.Add(ex);
            }

            _typeChecked = !ASTHandlerExceptions.Any();
            return _typeChecked;
        }

        public bool Evaluate()
        {
            if (!_typeChecked)
            {
                throw new Exception("Not type checked");
            }
            else
            {
                ASTHandlerExceptions.Clear();
            }
            EvaluatorVisitor evaluator = new EvaluatorVisitor(ASTHandlerExceptions, ReferenceLookupTable, IdentifierTable);
            try
            {
                RootNode.AcceptBottomUp(evaluator);
            }
            catch (QLException ex)
            {
                /* Exceptions preventing Evaluator from finishing */
                ASTHandlerExceptions.Add(ex);                

            }

            _evaluated = !ASTHandlerExceptions.Any();
            return _evaluated;
            
        }

        //public bool EvaluateUI()
        //{
        //    if (!_evaluated)
        //    {
        //        throw new Exception("Expressions not evaluated");
        //    }
        //    else
        //    {
        //        ASTHandlerExceptions.Clear();
        //    }

        //}

        /// <summary>
        /// convenience method for getting the Terminal wrapper based on identifier name.
        /// </summary>
        public ITerminalWrapper GetWrappedValue(string IdentifierName)
        {
            return GetWrappedValue(new Identifier(IdentifierName));
        }

        /// <summary>
        /// convenience method for getting the Terminal wrapper based on Identifier node.
        /// </summary>
        public ITerminalWrapper GetWrappedValue(Identifier i)
        {
            if (!_evaluated)
            {
                throw new Exception("Expressions not evaluated");
            }

            return ReferenceLookupTable[IdentifierTable[i]];
        }
    }
}
