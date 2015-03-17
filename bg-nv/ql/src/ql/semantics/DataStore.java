package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nik on 09-03-2015
 */
// TODO: handle errors, paths, etc.
public class DataStore implements FormVisitor<Void>, StatVisitor<Void>
{
    private static final String FILEPATH = "questionnaire.xml";

    private final Map<String, String> questionToId;
    private final Map<String, Object> answerToQuestion;

    public DataStore(Form ast)
    {
        this.questionToId = new HashMap<>();
        ast.accept(this);
        this.answerToQuestion = new HashMap<>();
    }

    public void store(ValueTable valueTable)
    {
        this.buildAnswerMap(valueTable);

        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("questionnaire");
            doc.appendChild(rootElement);

            for (String question : this.answerToQuestion.keySet())
            {
                Element questionElem = doc.createElement("question");

                questionElem.setAttribute("text", question);
                questionElem.setAttribute("answer", this.answerToQuestion.get(question).toString());

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

    private void buildAnswerMap(ValueTable valueTable)
    {
        for (String questionId : this.questionToId.keySet())
        {
            Object answer = valueTable.getValue(questionId).getValue();
            answerToQuestion.put(questionId, answer);
        }
    }

    @Override
    public Void visit(Form f)
    {
        for (Statement s : f.getBody())
        {
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.questionToId.put(q.getId(), q.getLabel());
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.questionToId.put(q.getId(), q.getLabel());
        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        return null;
    }
}
