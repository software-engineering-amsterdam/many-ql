package ql.semantics;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ql.ast.statement.Question;
import ql.semantics.values.Value;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Nik on 09-03-2015
 */
// TODO: handle errors, paths, etc.
public class FileStore extends DataStore
{
    private static final String FILEPATH = "questionnaire.xml";

    public FileStore(CondQuestionTable condQuestionTable, ValueTable valueTable)
    {
        super(condQuestionTable, valueTable);
    }

    @Override
    public void save()
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = this.createDocument(docBuilder);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILEPATH));

            transformer.transform(source, result);
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (TransformerException e)
        {
            e.printStackTrace();
        }
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
