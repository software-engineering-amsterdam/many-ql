﻿using System;
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
        public References ValueReference;

        

        private DataContext()
        {
            ASTHandlerExceptions = new ObservableCollection<QLBaseException>();
            TypeReference = new Dictionary<Identifier, Type>();
            ValueReference = new References();
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
