using Antlr4.Runtime;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Model;
using QL.Model.Terminals;
using QL.Visitors;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL
{
    public class DataContext
    {
        public string Input;
        public Stream InputStream;
        public AntlrInputStream AntlrInput;

        /// <summary>
        /// The main form (i.e. entry point) in the AST
        /// </summary>
        public Form RootNode;

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

        public bool InputSet;
        public bool AstBuilt;
        public bool TypeChecked;
        public bool Evaluated;
        public bool Rendered;
        public DataContext(){
            InputSet = AstBuilt = TypeChecked = Evaluated = Rendered = false;
            ASTHandlerExceptions = new ObservableCollection<QLException>();
            TypeReference = new Dictionary<Identifier, Type>();
            ReferenceLookupTable = new Dictionary<ITypeResolvable, ITerminalWrapper>();
            IdentifierTable = new Dictionary<Identifier, ITypeResolvable>();

        }
        public DataContext(string input):this()
        {
            Input=input;        
        }
        public DataContext(Stream input):this()
        {
            InputStream=input;
        }

        
       
        public ITerminalWrapper GetWrappedValue(string IdentifierName)
        {
            //convenience method for getting the Terminal wrapper based on identifier name. 
            return GetWrappedValue(new Identifier(IdentifierName));
        }
        public ITerminalWrapper GetWrappedValue(Identifier i)
        {
            //convenience method for getting the Terminal wrapper based on Identifier node. 
            if (!Evaluated)
            {
                throw new Exception("AST not evaluated");
            }
            if (IdentifierTable.ContainsKey(i) && ReferenceLookupTable.ContainsKey(IdentifierTable[i]))
            { 
                return ReferenceLookupTable[IdentifierTable[i]];
            }
            else
            {
                throw new EvaluationError("unintialized variable");
            }
        }

    }
}
