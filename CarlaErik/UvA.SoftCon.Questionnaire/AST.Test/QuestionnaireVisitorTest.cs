using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;
using Antlr4.Runtime;
using UvA.SoftCon.Questionnaire.Parsing;
using UvA.SoftCon.Questionnaire.AST;

namespace AST.Test
{
    /// <summary>
    /// Provides test methods for the <see cref="UvA.SoftCon.Questionnaire.AST.QuestionnaireVisitor"/> class.
    /// </summary>
    [TestClass]
    public class QuestionnaireVisitorTest
    {
        [TestMethod]
        public void TestVisitQuestionnaire()
        {
            using (var reader = new StreamReader(@"C:\Users\Erik\Desktop\House.ql"))
            {
                // Arrange
                AntlrInputStream inputStream = new AntlrInputStream(reader);

                QLLexer lexer = new QLLexer(inputStream);

                CommonTokenStream tokens = new CommonTokenStream(lexer);

                QLParser parser = new QLParser(tokens);

                QuestionnaireVisitor visitor = new QuestionnaireVisitor();

                Questionnaire form = visitor.Visit(parser.questionnaire());
            }
        }
    }
}
