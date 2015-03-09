package qls.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import ql.ast.expression.Identifier;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import qls.ast.QLSNode;

public class QLSLexer implements QLSTokens {
	private static final Map<String, Integer> KEYWORDS;
	
	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put("stylesheet", STYLESHEET);
		KEYWORDS.put("page", PAGE);
		KEYWORDS.put("section", SECTION);
		KEYWORDS.put("question", QUESTION);
		KEYWORDS.put("default", DEFAULT);
		
		KEYWORDS.put("boolean", BOOLEAN);
		KEYWORDS.put("integer", INTEGER);
		KEYWORDS.put("float", FLOAT);
		KEYWORDS.put("money", MONEY);
		KEYWORDS.put("string", STRING);
	}
	
	
	private int token;
	private int c = ' ';
	
	private QLSNode yylval;
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
					
		    		//yylval = new StringLiteral(string);
		    		return token = STRINGLITERAL;
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
			    			
			    			nextChar(); 
			    		} while (Character.isDigit(c) || (c == '.' && !isFloat));
			    		
			    		//yylval = isFloat ? new FloatLiteral((float)n) : new IntegerLiteral((int)n);
			    		
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
						
			    		//yylval = new Identifier(name);
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

	public QLSNode getSemantic() {
		return yylval;
	}


}
