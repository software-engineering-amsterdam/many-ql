package ql.semantics;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ql.ast.statement.Question;
import ql.semantics.values.Value;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Nik on 09-03-2015
 */
public class FileStore extends DataStore
{
    private final File file;

    public FileStore(CondQuestionTable condQuestionTable, ValueTable valueTable, File file)
    {
        super(condQuestionTable, valueTable);
        this.file = file;
    }

    @Override
    public void save() throws Exception
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = this.createDocument(docBuilder);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(this.file);

        transformer.transform(source, result);
    }

    private Document createDocument(DocumentBuilder docBuilder)
    {
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("questionnaire");
        doc.appendChild(rootElement);

        for (Question question : this.getQuestions())
        {
            Element questionElem = this.createElementForQuestion(doc, question);
            rootElement.appendChild(questionElem);
        }
        return doc;
    }

    private Element createElementForQuestion(Document doc, Question question)
    {
        Value answer = this.getAnswer(question.getId());
        Element questionElem = doc.createElement("question");
        questionElem.setAttribute("text", question.getLabel());
        questionElem.setAttribute("answer", answer.toString());

        return questionElem;
    }
}
