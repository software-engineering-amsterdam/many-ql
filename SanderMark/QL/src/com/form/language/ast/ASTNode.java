package com.form.language.ast;

import com.form.language.issue.QLToken;

public abstract class ASTNode {
    protected QLToken tokenInfo;

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
