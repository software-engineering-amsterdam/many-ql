package org.uva.qls.main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.qls.antlr.QLSLexer;
import org.uva.qls.antlr.QLSParser;
import org.uva.qls.ast.builder.QLSImplVisitor;
import org.uva.qls.ast.sheet.Page;
import org.uva.qls.ast.sheet.Question;
import org.uva.qls.ast.sheet.Section;
import org.uva.qls.ast.sheet.Sheet;
import org.uva.qls.ast.sheet.Style;
import org.uva.qls.ast.style.StyleProperty;
import org.uva.qls.typechecker.TypeChecker;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

public class Main {

	public static void main(String[] args) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream("scripts/qls/style1.qls");
		QLSLexer lexer = new QLSLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLSParser parser = new QLSParser(tokens);
		ParseTree tree = parser.sheet();
		QLSImplVisitor visitor = new QLSImplVisitor();
		Sheet sheet = (Sheet) tree.accept(visitor);
		System.out.println();
		System.out.println("omg");
		printSheet(sheet);
		System.out.println("TYPECHECKER.");
		TypeChecker checker = new TypeChecker();
		System.out.println(checker.visit(sheet));
		checker.print();
	}

	private static void printSheet(Sheet sheet) {
		System.out.println("Identifier for sheet = " + sheet.toString());
		for (Page page : sheet.getPageList()) {
			System.out.println("Identifier for page = " + page.toString());
			for (Section section : page.getSectionList()) {
				printSection(section);
			}
			for (Style style : page.getStyleList()) {
				printStyle(style);
			}
		}
	}

	private static void printSection(Section section) {
		System.out.println("Section = " + section.toString());
		for (Question question : section.getQuestionList()) {
			printQuestion(question);
		}

		for (Style style : section.getStyleList()) {
			printStyle(style);
		}
	}

	private static void printStyle(Style style) {
		System.out.println("Style type = " + style.getType());
		for (StyleProperty prop : style.getStyleProperties()) {
			printProp(prop);
		}

	}

	private static void printProp(StyleProperty prop) {
		System.out.println("Style property = " + prop.toString());
	}

	private static void printQuestion(Question question) {
		System.out.println("Question = " + question.toString());
	}
}
