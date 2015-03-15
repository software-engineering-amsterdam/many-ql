package com.form.language.ast;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.Type;
import com.form.language.memory.Context;

public abstract class ASTNode {
    protected Token tokenInfo;
    public abstract Type getType(Context context);

    protected ASTNode(Token tokenInfo){
	this.tokenInfo = tokenInfo;
    }
    
    public Token getTokenInfo(){
	return tokenInfo;
    }
    public String showTokenInfo() {
	return "line: " + tokenInfo.getLine() + ", column:" + tokenInfo.getCharPositionInLine();
    }
}
