package qls.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import ql.ast.QLNode;
import ql.ast.expression.Identifier;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;

public class QLSLexer implements QLSTokens {
	private static final Map<String, Integer> KEYWORDS;
	
	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put("stylesheet", STYLESHEET);
		KEYWORDS.put("page", PAGE);
		KEYWORDS.put("section", SECTION);
		KEYWORDS.put("question", QUESTION);
		KEYWORDS.put("default", DEFAULT);
		KEYWORDS.put("widget", WIDGET);
		
		KEYWORDS.put("boolean", BOOLEAN);
		KEYWORDS.put("integer", INTEGER);
		KEYWORDS.put("float", FLOAT);
		KEYWORDS.put("money", MONEY);
		KEYWORDS.put("string", STRING);
		
		KEYWORDS.put("checkbox", CHECKBOX);
		KEYWORDS.put("spinbox", SPINBOX);
		KEYWORDS.put("radio", RADIO);
		KEYWORDS.put("slider", SLIDER);
		KEYWORDS.put("text", TEXT);
		KEYWORDS.put("dropdown", DROPDOWN);
		KEYWORDS.put("width", WIDTH);
		KEYWORDS.put("height", HEIGHT);
		KEYWORDS.put("font", FONT);
		KEYWORDS.put("fontsize", FONTSIZE);
		KEYWORDS.put("color", COLOR);
	}
	
	
	private int token;
	private int c = ' ';
	
	private QLNode yylval;
	private final Reader input;

	public QLSLexer(Reader input) {
		this.input = input;
		nextChar();
	}
	
	
	private void nextChar() {
		if (c >= 0) {
			try {
				c = input.read();
			}
			catch (IOException e) {
				c = -1;
			}
		}
	}
	
	public int nextToken() {
		boolean inComment = false;
		for (;;) {
			if (inComment) {
				while (c != '*' && c != -1) {
					nextChar();
				}
				if (c == '*') {
					nextChar();
					if (c == '/') {
						nextChar();
						inComment = false;
					}
					continue;
				}
			}
			
			while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
				nextChar();
			}
			
			
			if (c < 0) {
				return token = ENDINPUT;
			}
			
			switch (c) {
			    case '/': {
			    	nextChar();
			    	if (c == '*') {
			    		inComment = true;
			    		nextChar();
			    		continue;
			    	}
			    	else if (c == '/') {
			    		while (c != '\n') {
							nextChar();
						}
			    		continue;
			    	}
			    	return token = '/'; 
			    }
			    case ':': nextChar(); return token = ':';
			    case '}': nextChar(); return token = '}';
			    case '{': nextChar(); return token = '{';
			    case ')': nextChar(); return token = ')';
			    case '(': nextChar(); return token = '(';
			    case ',': nextChar(); return token = ',';
			    case ';': nextChar(); return token = ';';
			    
			    case '"': {
			    	StringBuilder sb = new StringBuilder();
			    	// Skip opening quote.
			    	nextChar();
			    	
			    	// Build a string from everything between the quotes.
			    	while (c != '"') {
			    		// Detected escaped quotes.
			    		if(c == '\\') {
				    		nextChar();
				    		
				    		if(c == '"') {
				    			sb.append((char)c);
				    			nextChar();
				    			continue;
				    		}
				    	}
			    		
			    		sb.append((char)c);
		    			nextChar();
		    		}
			    	
			    	// Skip closing quote.
			    	nextChar();
		    		String string = sb.toString();
					
		    		yylval = new StringLiteral(string);
		    		return token = STRINGLITERAL;
			    }
			    case '#': {
			    	StringBuilder sb = new StringBuilder("0x");
			    	
			    	nextChar();
			    	
			    	while(Character.isDigit(c) || Character.isLetter(c)) {
			    		sb.append((char) c);
			    		nextChar();
			    	}
			    	
			    	// Number is 8: 2 for "0x" and 2 for r, g, and b respectively.
			    	if(sb.length() != 8) {
			    		throw new RuntimeException("Only hexadecimals of 6 numbers allowed: " + sb.toString() + ".");
			    	}
			    	try {
			    		yylval = new IntegerLiteral(Integer.decode(sb.toString()));
			    	} catch(NumberFormatException exception) {
			    		throw new NumberFormatException("Hexadecimal is illegal: " + sb.toString());
			    	}
			    	
			    	return token = INTEGERLITERAL;
			    }
			    default: {
			    	if (Character.isDigit(c)) {
			    		boolean isFloat = false;
			    		double n = 0; 
			    		int decs = 1;
			    		
			    		do {
			    			if(c == '.') {
			    				isFloat = true;
			    				nextChar();
			    				continue;
			    			}
			    			
			    			if(isFloat) {
			    				n = n + (1.0 / (10 * decs)) * (c - '0');
			    				decs *= 10;
			    			} else {
			    				n = 10 * n + (c - '0');
			    			}
			    			
			    			yylval = isFloat ? new FloatLiteral((float)n) : new IntegerLiteral((int)n);
			    			nextChar(); 
			    		} while (Character.isDigit(c) || (c == '.' && !isFloat));
			    		
			    		
			    		return token = isFloat ? FLOATLITERAL : INTEGERLITERAL;
			    	}
			    	if (Character.isLetter(c)) {
			    		StringBuilder sb = new StringBuilder();
			    		
			    		do {
			    			sb.append((char)c);
			    			nextChar();
			    		} while (Character.isLetterOrDigit(c));
			    		
			    		String name = sb.toString();
			    			    		
			    		if (KEYWORDS.containsKey(name)) {
			    			return token = KEYWORDS.get(name);
			    		}
						
			    		yylval = new Identifier(name);
			    		return token = IDENTIFIER;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			}
		}
	}

	
	public int getToken() {
		return token;
	}

	public QLNode getSemantic() {
		return yylval;
	}


}
