using AST;
using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using Evaluation;
using QLGui.ValueVisitors;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace QLGui.Controllers
{
    public class ExportFormulaireController : IFormObjectVisitor<IEnumerable<Question>>
    {
        public void ExportAnswers(IList<FormObject> formObjects, SymbolTable symbolTable)
        {
            List<Question> questions = new List<Question>();

            foreach (FormObject formObject in formObjects)
            {
                questions.AddRange(formObject.Accept(this));
            }

            CreateXMLFile(questions, symbolTable);
        }

        private void CreateXMLFile(IList<Question> questions, SymbolTable symbolTable)
        {
            using (XmlWriter writer = XmlWriter.Create(ConfigurationManager.AppSettings["outputPath"]))
            {
                writer.WriteStartDocument();
                writer.WriteStartElement("Form");

                foreach (Question question in questions)
                {
                    writer.WriteStartElement("Question");

                    writer.WriteElementString("Label", question.Label.ToString());
                    writer.WriteElementString("Value", symbolTable.GetValue(question.Identifier).Accept(new ValueToString()));

                    writer.WriteEndElement();
                }

                writer.WriteEndElement();
                writer.WriteEndDocument();
            }
        }
        
        public IEnumerable<Question> Visit(Conditional conditional)
        {
            return conditional.GetBody().SelectMany(x => x.Accept(this));
        }

        public IEnumerable<Question> Visit(Question question)
        {
            return new List<Question>{question};
        }
    }
}
