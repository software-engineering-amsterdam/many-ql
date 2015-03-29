using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using Antlr4.Runtime;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals;
using QL.Exceptions;

namespace QL.AST
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
        public ReferenceTables ValueReferenceTable { get; private set; }

        private DataContext()
        {
            ASTHandlerExceptions = new ObservableCollection<QLBaseException>();
            TypeReference = new Dictionary<Identifier, Type>();
            ValueReferenceTable = new ReferenceTables();
        }

        public DataContext(string input) : this()
        {
            Input = input;
        }

        public DataContext(Stream input) : this()
        {
            InputStream = input;
        }
    }
}
