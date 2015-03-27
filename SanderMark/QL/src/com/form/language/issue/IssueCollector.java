package com.form.language.issue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IssueCollector {
    private List<Issue> issueList;

    public IssueCollector() {
	this.issueList = new ArrayList<Issue>();
    }

    public void add(Issue e) {
	issueList.add(e);
    }

    public Iterator<Issue> getErrorCollection() {
	return issueList.iterator();
    }

    public List<String> print() {
	List<String> result = new ArrayList<String>();
	for(Issue e : issueList){
	    result.add(e.toString());
	}
	return result;
    }

    @Override
    public String toString() {
	String result = "";
	for(Issue e : issueList)
	{
		result += e + "\n";
	}
	return result;
    }

    public Boolean isEmpty() {
	return issueList.isEmpty();
    }
}
