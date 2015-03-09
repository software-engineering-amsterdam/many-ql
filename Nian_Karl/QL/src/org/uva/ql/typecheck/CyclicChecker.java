package org.uva.ql.typecheck;

import java.util.ArrayList;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.typecheck.relation.Relation;
import org.uva.ql.typecheck.message.Error;

public class CyclicChecker {

	private final ArrayList<Relation> relations;
	
	public CyclicChecker() {
		relations = new ArrayList<Relation>();
	}
	
	public void add(Identifier first, Identifier second) {
		Relation rel = new Relation(first, second);
		relations.add(rel);
	}
	
	public ArrayList<Relation> getClosure() {
		return relations;
	}
	
	public boolean hasSameName(Identifier id1, Identifier id2) {
		return id1.toString().equals(id2.toString());
	}
	
	public boolean contains(Relation r) {
		for (Relation i : relations) {
			if (hasSameName(i.getFirst(), r.getFirst()) && hasSameName(i.getSecond(), r.getSecond())) {
				return true;
			}
		}
		return false;
	}
	
	public void process() {
		boolean result = true;
		ArrayList<Relation> copy = new ArrayList<Relation>(relations);
		
		for (Relation i : copy) {
			for (Relation j : copy) {
				if (hasSameName(i.getSecond(), j.getFirst())) {
					Relation t = new Relation(i.getFirst(), j.getSecond());
					if (!contains(t)) {
						relations.add(t);
						result = false;
					}
				}
			}
		}
		
		if (!result) {
			process();
		}
	}
	
	public boolean check(MessageManager mm) {
		boolean result = true;
		process();
		System.out.println(relations.size());
		for (Relation relation : relations) {
			if (relation.isCyclic()) {
				int lineNr1 = relation.getFirst().getPosition().getStartLine();
				//int lineNr2 = relation.getSecond().getPosition().getStartLine();
				//int lineNr = lineNr1 < lineNr2 ? lineNr1 : lineNr2;
				String literal = relation.getFirst().toString();
				mm.addError(new Error(Error.Type.CYCLIC, lineNr1, literal));
				result = false;
			}
		}
		return result;
	}
	
	public void addErros(MessageManager mm) {
		for (Relation relation : relations) {
			if (relation.isCyclic()) {
			}
		}
	}
	
	public void printCyclic() {
		for (Relation relation : relations) {
			if (relation.isCyclic()) {
				System.out.println(relation.getFirst().getPosition().getStartLine());
				System.out.println(relation.getSecond().getPosition().getStartLine());
			}
		}
	}
	
	public void print() {
		for (Relation relation : relations) {
			relation.print();
		}
	}	
	
}
