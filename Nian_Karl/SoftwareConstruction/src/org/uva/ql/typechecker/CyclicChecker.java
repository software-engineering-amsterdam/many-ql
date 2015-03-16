package org.uva.ql.typechecker;

import java.util.ArrayList;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.typechecker.relation.Relation;
import org.uva.util.message.Error;
import org.uva.util.message.MessageManager;

public class CyclicChecker {

	private final ArrayList<Relation> identifierRelation;
	
	public CyclicChecker() {
		identifierRelation = new ArrayList<Relation>();
	}
	
	public void add(Identifier first, Identifier second) {
		Relation rel = new Relation(first, second);
		identifierRelation.add(rel);
	}
	
	public ArrayList<Relation> getClosure() {
		return identifierRelation;
	}
	
	public boolean hasSameName(Identifier id1, Identifier id2) {
		return id1.toString().equals(id2.toString());
	}
	
	public boolean contains(Relation r) {
		for (Relation i : identifierRelation) {
			if (hasSameName(i.getFirst(), r.getFirst()) && hasSameName(i.getSecond(), r.getSecond())) {
				return true;
			}
		}
		return false;
	}
	
	public void process() {
		boolean result = true;
		ArrayList<Relation> copy = new ArrayList<Relation>(identifierRelation);
		
		for (Relation i : copy) {
			for (Relation j : copy) {
				if (hasSameName(i.getSecond(), j.getFirst())) {
					Relation t = new Relation(i.getFirst(), j.getSecond());
					if (!contains(t)) {
						identifierRelation.add(t);
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
		System.out.println(identifierRelation.size());
		for (Relation relation : identifierRelation) {
			if (relation.isCyclic()) {
				int lineNr1 = relation.getFirst().getPosition().getStartLine();
				String literal = relation.getFirst().toString();
				mm.addError(new Error(Error.Type.CYCLIC, lineNr1, literal));
				result = false;
			}
		}
		return result;
	}
	
	public void addErros(MessageManager mm) {
		for (Relation relation : identifierRelation) {
			if (relation.isCyclic()) {
				// Hello?
			}
		}
	}
	
	public void printCyclic() {
		for (Relation relation : identifierRelation) {
			if (relation.isCyclic()) {
				System.out.println(relation.getFirst().getPosition().getStartLine());
				System.out.println(relation.getSecond().getPosition().getStartLine());
			}
		}
	}
	
	public void print() {
		for (Relation relation : identifierRelation) {
			relation.print();
		}
	}	
	
}
