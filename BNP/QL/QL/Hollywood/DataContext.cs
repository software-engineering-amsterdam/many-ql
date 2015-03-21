using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using Antlr4.Runtime;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals;
using QL.AST.ValueWrappers;
using QL.Exceptions;
using QL.Exceptions.Warnings;

namespace QL.Hollywood
{
    public class DataContext
    {
        public string Input;
        public Stream InputStream;
        public AntlrInputStream AntlrInput; //Input used in parser

        public Form RootNode { get; internal set; } //AST root node, entry point for all visitors

        /// <summary>
        /// A collection of all errors and warnings occurring during all stages of interpreting input grammar
        /// </summary>
        public ObservableCollection<QLBaseException> ASTHandlerExceptions { get; private set; }

        /// <summary>
        /// Maps defined identifiers to the datatype of the value they contain
        /// </summary>
        public IDictionary<Identifier, Type> TypeReference { get; private set; }
        /// <summary>
        /// a lookup of references to terminals
        /// </summary>
        public IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable { get; private set; }
        public IDictionary<Identifier, ITypeResolvable> IdentifierTable;

        private DataContext()
        {
            ASTHandlerExceptions = new ObservableCollection<QLBaseException>();
            TypeReference = new Dictionary<Identifier, Type>();
            ReferenceLookupTable = new Dictionary<ITypeResolvable, ITerminalWrapper>();
            IdentifierTable = new Dictionary<Identifier, ITypeResolvable>();
        }

        public DataContext(string input) : this()
        {
            Input = input;
        }

        public DataContext(Stream input) : this()
        {
            InputStream = input;
        }


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
            if (IdentifierTable.ContainsKey(i) && ReferenceLookupTable.ContainsKey(IdentifierTable[i]))
            {
                return ReferenceLookupTable[IdentifierTable[i]];
            }
            
            return null;
        }
    }
}
