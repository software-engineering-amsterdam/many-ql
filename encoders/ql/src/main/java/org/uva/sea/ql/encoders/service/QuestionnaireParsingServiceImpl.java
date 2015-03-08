package org.uva.sea.ql.encoders.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.uva.sea.ql.encoders.EncodersQLLexer;
import org.uva.sea.ql.encoders.EncodersQLParser;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.operator.AddOperator;
import org.uva.sea.ql.encoders.ast.operator.BinaryOperator;
import org.uva.sea.ql.encoders.ast.operator.MulOperator;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.ast.type.QLBoolean;
import org.uva.sea.ql.encoders.ast.type.QLInteger;
import org.uva.sea.ql.encoders.ast.type.QLString;
import org.uva.sea.ql.encoders.validation.SyntaxValidation;
import org.uva.sea.ql.encoders.validation.TypeCheckerVisitor;
import org.uva.sea.ql.encoders.validation.Validation;

/**
 * Implementation for {@link QuestionnaireParsingService}.
 */
public class QuestionnaireParsingServiceImpl implements QuestionnaireParsingService {

	public List<Validation> validations = new ArrayList<Validation>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Questionnaire parse(String location) throws IOException {
		EncodersQLLexer lexer = new EncodersQLLexer(new ANTLRFileStream(location));
		EncodersQLParser parser = new EncodersQLParser(new CommonTokenStream(lexer));

		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
					String msg, RecognitionException e) {
				validations.add(new SyntaxValidation(msg, new TextLocation(line, charPositionInLine)));
			}
		});

		QuestionnaireContext parseTree = parser.questionnaire();
		Map<String, BinaryOperator> operatorTable = getOperatorTable();
		Map<String, DataType> dataTypeTable = getDataTypeTable();
		QuestionnaireVisitor visitor = new QuestionnaireVisitor(operatorTable, dataTypeTable);
		Questionnaire questionnaire = (Questionnaire) visitor.visit(parseTree);

		TypeCheckerVisitor typeChecker = new TypeCheckerVisitor(questionnaire.getQuestions());
		validations.addAll(typeChecker.checkTypes());

		return questionnaire;
	}

	private Map<String, DataType> getDataTypeTable() {
		Map<String, DataType> operatorTable = new HashMap<>();
		operatorTable.put("boolean", new QLBoolean(null));
		operatorTable.put("string", new QLString(null));
		operatorTable.put("int", new QLInteger(null));
		return operatorTable;
	}

	private Map<String, BinaryOperator> getOperatorTable() {
		Map<String, BinaryOperator> operatorTable = new HashMap<>();
		operatorTable.put("*", new MulOperator());
		operatorTable.put("+", new AddOperator());
		return operatorTable;
	}

	@Override
	public List<Validation> getTypeValidations() {
		return validations;
	}
}
