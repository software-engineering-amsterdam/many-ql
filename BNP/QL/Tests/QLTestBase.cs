using Antlr4.Runtime;
using QL.Grammar;
using QL.Hollywood.DataHandlers.ASTCreation;
using QLLexer = QL.Grammar.QLLexer;

namespace Tests
{
    public abstract class QLTestBase
    {
        protected AntlrInputStream Inputstream;
        protected QLLexer Lexer;
        protected CommonTokenStream Tokenstream;
        protected QLParser Parser;
        protected QLListener Listener;

        protected void Build(string input)
        {
            Inputstream = new AntlrInputStream(input);
            Lexer = new QLLexer(Inputstream);
            Tokenstream = new CommonTokenStream(Lexer);
            Parser = new QLParser(Tokenstream);

        }
    }
}
