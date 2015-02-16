using System;
using Antlr4.Runtime;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Grammars;

namespace Tests.QLTests
{
    public abstract class SyntaxComplianceTestBase
    {
        protected AntlrInputStream Inputstream;
        protected QLLexer Lexer;
        protected CommonTokenStream Tokenstream;
        protected QLParser Parser;

        protected void Build(string input)
        {
            Inputstream = new AntlrInputStream(input);
            Lexer = new QLLexer(Inputstream);
            Tokenstream = new CommonTokenStream(Lexer);
            Parser = new QLParser(Tokenstream);
        }
    }
}
