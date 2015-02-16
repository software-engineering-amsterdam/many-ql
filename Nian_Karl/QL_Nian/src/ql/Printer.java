package ql;

import org.antlr.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import ql.antlr.QLParser;

public class Printer extends QLParser{
	public Printer(TokenStream input) {
		super(input);
		// TODO Auto-generated constructor stub
	}

	public void echo(Token id){
		System.out.println("Hello world!!!!!!!!!!!" + id.getText());
	}

}
