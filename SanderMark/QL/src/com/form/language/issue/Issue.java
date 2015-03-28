package com.form.language.issue;

public abstract class Issue {
    protected final QLToken offendingToken;
    protected final String message;
    
    public Issue(QLToken offendingToken, String message) {
	this.offendingToken = offendingToken;
	this.message = message;
    }
    
    @Override
    public abstract String toString();
}
