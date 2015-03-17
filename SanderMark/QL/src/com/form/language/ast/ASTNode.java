package com.form.language.ast;

import com.form.language.ast.type.Type;
import com.form.language.error.QLToken;
import com.form.language.memory.Context;

public abstract class ASTNode {
    protected QLToken tokenInfo;
    public abstract Type getType(Context context);

    protected ASTNode(QLToken tokenInfo){
	this.tokenInfo = tokenInfo;
    }
    
    public QLToken getTokenInfo(){
	return tokenInfo;
    }
    public String showTokenInfo() {
	return "line: " + tokenInfo.getLine() + ", column:" + tokenInfo.getCharPositionInLine();
    }
}
