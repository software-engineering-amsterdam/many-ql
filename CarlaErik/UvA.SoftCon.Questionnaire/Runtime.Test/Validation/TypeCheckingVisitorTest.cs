using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.Runtime.Validation;
using UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting;

namespace UvA.SoftCon.Questionnaire.Runtime.Test.Validation
{
    /// <summary>
    /// Provides test methods for the <see cref=""/> class.
    /// </summary>
    [TestClass]
    public class TypeCheckingVisitorTest
    {
        [TestMethod]
        public void Test()
        {
            // Arrange
            var ql = new StringBuilder();
            ql.AppendLine("int age = 36");
            ql.AppendLine("age = age + 5");
            ql.AppendLine("string name = 45");

            ql.AppendLine("if(name > 36)");
            ql.AppendLine("{ }");

            var controller = new ASTController();
            var form = controller.ParseQLString(ql.ToString());

            var visitor = new TypeCheckingVisitor();

            // Act
            visitor.Visit(form);

            var errorReportBuilder = new ErrorReportBuilder();
            errorReportBuilder.GenerateTypeCheckingMessages(visitor);

            string report = errorReportBuilder.GetReport();

        }
    }
}
