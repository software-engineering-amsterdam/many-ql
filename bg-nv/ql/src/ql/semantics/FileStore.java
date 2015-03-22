package ql.semantics;

import ql.ast.form.Form;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

    public FileStore(Form ast, ValueTable valueTable)
    {
        super(ast, valueTable);
    }

    @Override
    public void store()
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("questionnaire");
            doc.appendChild(rootElement);

            for (String questionId : this.storeItems)
            {
                Element questionElem = this.createElementForQuestion(doc, questionId);
                rootElement.appendChild(questionElem);
            }

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

    private Element createElementForQuestion(Document doc, String questionId)
    {
        String question = this.storeItems.getLabel(questionId);
        String answer = this.storeItems.getAnswer(questionId);

        Element questionElem = doc.createElement("question");
        questionElem.setAttribute("text", question);
        questionElem.setAttribute("answer", answer);

        return questionElem;
    }
}
