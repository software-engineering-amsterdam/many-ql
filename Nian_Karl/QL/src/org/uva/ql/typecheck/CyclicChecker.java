package org.uva.ql.typecheck;

import java.util.ArrayList;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.typecheck.relation.Relation;

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
		String a = id1.toString();
		String b = id2.toString();
		System.out.println(a+"|||" + b + "="+(a == b));
		return (id1.toString() == id2.toString());
	}
	
	public boolean contains(Relation r) {
		for (Relation i : relations) {
			if (hasSameName(i.getFirst(), r.getFirst()) && hasSameName(i.getSecond(), r.getSecond())) {
				return true;
			}
		}
		return false;
	}
	
	public void check() {
		ArrayList<Relation> copy = new ArrayList<Relation>(relations);
		
		for (Relation i : copy) {
			for (Relation j : copy) {
				System.out.println(hasSameName(i.getSecond(), j.getFirst()));
				if (hasSameName(i.getSecond(), j.getFirst())) {
					Relation t = new Relation(i.getFirst(), j.getSecond());
					if (!contains(t)) {
						System.out.println("ADD");
						relations.add(t);
					}
				}
			}
		}
		
		if (relations.size() != copy.size()) {
			check();
		}
		
		System.out.println(relations.size());
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
