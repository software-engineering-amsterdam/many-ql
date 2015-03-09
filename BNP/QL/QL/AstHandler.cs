using System.Collections.Generic;
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

        public IList<Exception> AstBuilderExceptions { get; private set; }


        public IList<QLError> TypeCheckerErrors { get; private set; }        // TODO | maybe merge warnings & errors
        public IList<QLWarning> TypeCheckerWarnings { get; private set; }    // TODO | after UI has completed
        public IList<QLError> EvaluationErrors { get; private set; }
        public IList<QLWarning> EvaluationWarnings { get; private set; }
        
        public IDictionary<Identifier, Type> TypeReference { get; private set; }
        public IDictionary<ITypeResolvable, IResolvableTerminalType> ReferenceLookupTable { get; private set; } // a lookup of references to terminals

        string Input;
        Stream InputStream;

        bool AstBuilt;
        bool TypeChecked;
        bool Evaluated;
        




        
        public AstHandler(string input)        {
            
            TypeReference = new SortedDictionary<Identifier, Type>();
            ReferenceLookupTable = null;
            AstBuilt = TypeChecked = Evaluated = false;
            Input = input;

        }
        public AstHandler(Stream input)
        {

            TypeReference = new SortedDictionary<Identifier, Type>();
            ReferenceLookupTable = null;
            AstBuilt = TypeChecked = Evaluated = false;
            InputStream = input;

        }

        

        public bool BuildAST()
        {

            AstBuilderExceptions = new List<Exception>();
            AntlrInputStream inputStream;
            if (Input!=null){
                inputStream = new AntlrInputStream(Input);
                }
            else if (InputStream!=null){
                inputStream = new AntlrInputStream(InputStream);
                }
            else{
                throw new Exception("no input");
            }

            QLLexer lexer = new QLLexer(inputStream);
            lexer.AddErrorListener(new LexerErrorHandler(AstBuilderExceptions));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            parser.AddErrorListener(new ParserErrorHandler(AstBuilderExceptions));
            QLListener listener = new QLListener(AstBuilderExceptions);
            parser.AddParseListener(listener);
            parser.formBlock();            // parses the input as a formBlock(cos it's on the top)
            RootNode = listener.GetAstRootNode();            
            AstBuilt=!AstBuilderExceptions.Any();
            return AstBuilt;
        }


        public bool CheckType()
        {
            if (!AstBuilt)
            {
                throw new Exception("Ast is not built");
            }

            TypeCheckerErrors = new List<QLError>();
            TypeCheckerWarnings = new List<QLWarning>();
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
            }

            TypeChecked =  !TypeCheckerErrors.Any();
            return TypeChecked;
        }

        public bool Evaluate()
        {
            if (!TypeChecked)
            {
                throw new Exception("Not type checked");
            }

            EvaluationErrors = new List<QLError>();
            EvaluationWarnings = new List<QLWarning>();

            EvaluatorVisitor evaluator = new EvaluatorVisitor(EvaluationErrors, EvaluationWarnings);
            try
            {
                RootNode.Accept(evaluator);
                ReferenceLookupTable = evaluator.GetValuesIfNoErrors();
            }
            catch (QLError ex)
            {
                EvaluationErrors.Add(ex);
            }

            Evaluated= !EvaluationErrors.Any();
            return Evaluated;
        }
    }
}
