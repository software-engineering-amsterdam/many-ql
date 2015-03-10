using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using QL.Errors;
using QL.Evaluation;
using QL.Model.Terminals;
using System;
using QL.Grammars;
using QL.Infrastructure;
using Antlr4.Runtime;
using System.IO;

namespace QL.Model
{
    public class AstHandler
    {
        public Form RootNode { get; private set; }

        public ObservableCollection<QLException> ASTHandlerExceptions { get; private set; }
        public IList<QLException> EvaluationErrors { get; private set; }        // TODO | maybe merge warnings & errors
        public IList<QLWarning> EvaluationWarnings { get; private set; }    // TODO | after UI has completed

        public IDictionary<Identifier, Type> TypeReference { get; private set; }
        public IDictionary<ITypeResolvable, TerminalWrapper> ReferenceLookupTable { get; private set; } // a lookup of references to terminals
        public IDictionary<Identifier, ITypeResolvable> IdentifierTable;
        string Input;
        Stream InputStream;

        bool AstBuilt;
        bool TypeChecked;
        bool Evaluated;

        private AstHandler()
        {
            ASTHandlerExceptions = new ObservableCollection<QLException>();
            TypeReference = new SortedDictionary<Identifier, Type>();
            ReferenceLookupTable = null;
            AstBuilt = TypeChecked = Evaluated = false;
        }

        public AstHandler(string input) : this()
        {
            Input = input;
        }

        public AstHandler(Stream input) : this()
        {
            InputStream = input;
        }

        public bool BuildAST()
        {
            ASTHandlerExceptions.Clear();

            AntlrInputStream inputStream;
            if (Input != null)
            {
                inputStream = new AntlrInputStream(Input);
            }
            else if (InputStream != null)
            {
                inputStream = new AntlrInputStream(InputStream);
            }
            else
            {
                throw new Exception("no input");
            }

            QLLexer lexer = new QLLexer(inputStream);
            lexer.AddErrorListener(new LexerErrorHandler(ASTHandlerExceptions));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            parser.AddErrorListener(new ParserErrorHandler(ASTHandlerExceptions));
            QLListener listener = new QLListener(ASTHandlerExceptions);
            parser.AddParseListener(listener);
            parser.formBlock();            // parses the input as a formBlock(cos it's on the top)
            RootNode = listener.GetAstRootNode();
            AstBuilt = !ASTHandlerExceptions.Any();
            return AstBuilt;
        }


        public bool CheckType()
        {
            if (!AstBuilt)
            {
                throw new QLException("Ast is not built");
            }

            TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(TypeReference, ASTHandlerExceptions);
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
                ASTHandlerExceptions.Add(ex);
            }

            TypeChecked = !ASTHandlerExceptions.Any();
            return TypeChecked;
        }

        public bool Evaluate()
        {
            if (!TypeChecked)
            {
                throw new Exception("Not type checked");
            }

            EvaluationErrors = new List<QLException>();
            EvaluationWarnings = new List<QLWarning>();
            ReferenceLookupTable = new Dictionary<ITypeResolvable, TerminalWrapper>();
            IdentifierTable= new Dictionary<Identifier, ITypeResolvable>();
            EvaluatorVisitor evaluator = new EvaluatorVisitor(EvaluationErrors, EvaluationWarnings, ReferenceLookupTable, IdentifierTable);
            try
            {
                RootNode.AcceptBottomUp(evaluator);
            }
            catch (QLError ex)
            {
                EvaluationErrors.Add(ex);
            }

            Evaluated = !EvaluationErrors.Any();
            return Evaluated;
        }
    }
}
