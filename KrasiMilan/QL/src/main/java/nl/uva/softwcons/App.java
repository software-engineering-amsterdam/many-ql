package nl.uva.softwcons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import nl.uva.softwcons.generated.QLBaseListener;
import nl.uva.softwcons.generated.QLBaseVisitor;
import nl.uva.softwcons.generated.QLLexer;
import nl.uva.softwcons.generated.QLParser;
import nl.uva.softwcons.generated.QLParser.QuestionnaireContext;
import nl.uva.softwcons.generated.QLParser.StringContext;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class App {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		InputStream url = App.class.getResourceAsStream("/form.ql");
		// File sampleForm = new File(url.getFile());
		ANTLRInputStream input = new ANTLRInputStream(url);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.questionnaire();
	}
}
