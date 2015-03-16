package org.uva.ql.typechecker.dependency;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.expression.literal.Identifier;


public class DependencyList {
	private final List<DependencyPair> dependencyClosure;
	
	public DependencyList() {
		dependencyClosure = new ArrayList<DependencyPair>();
	}
	
	public void add(Identifier dominant, Identifier dependent) {
		DependencyPair pair = new DependencyPair(dominant, dependent);
		dependencyClosure.add(pair);
	}
	
	public List<DependencyPair> getClosure() {
		return dependencyClosure;
	}
	
	private boolean hasSameName(Identifier id1, Identifier id2) {
		return id1.toString().equals(id2.toString());
	}
	
	public boolean contains(DependencyPair r) {
		for (DependencyPair i : dependencyClosure) {
			if (hasSameName(i.getDominant(), r.getDominant()) && hasSameName(i.getDependent(), r.getDependent())) {
				return true;
			}
		}
		return false;
	}
	
//	public void process() {
//		boolean result = true;
//		List<DependencyPair> copy = new ArrayList<DependencyPair>(dependencyClosure);
//		
//		for (DependencyPair i : copy) {
//			for (DependencyPair j : copy) {
//				if (hasSameName(i.getDependent(), j.getDominant())) {
//					DependencyPair t = new DependencyPair(i.getDominant(), j.getDependent());
//					if (!contains(t)) {
//						dependencyClosure.add(t);
//						result = false;
//					}
//				}
//			}
//		}
//		
//		if (!result) {
//			process();
//		}
//	}
	
	private List<DependencyPair> getTransitiveClosure() {
		boolean isComplete = true;
		List<DependencyPair> copy = new ArrayList<DependencyPair>(dependencyClosure);
		
		for (DependencyPair i : copy) {
			for (DependencyPair j : copy) {
				if (hasSameName(i.getDependent(), j.getDominant())) {
					DependencyPair p = new DependencyPair(i.getDominant(), j.getDependent());
					if (!contains(p)) {
						dependencyClosure.add(p);
						isComplete = false;
					}
				}
			}
		}
		
		if (!isComplete) {
			getTransitiveClosure();
		}
		
		return dependencyClosure;
	}
	
	public List<Identifier> getCyclicDependentIdentifiers() {
		List<Identifier> identifiers = new ArrayList<Identifier>();
		for (DependencyPair pair : getTransitiveClosure()) {
			
		}
		
		return identifiers;
	}
	
//	public boolean check(MessageManager mm) {
//		boolean result = true;
//		process();
//		System.out.println(dependencyClosure.size());
//		for (DependencyPair relation : dependencyClosure) {
//			if (relation.isCyclic()) {
//				int lineNr1 = relation.getDominant().getPosition().getStartLine();
//				String literal = relation.getDominant().toString();
//				mm.addError(new Error(Error.Type.CYCLIC, lineNr1, literal));
//				result = false;
//			}
//		}
//		return result;
//	}
//	
//	public void printCyclic() {
//		for (DependencyPair relation : dependencyClosure) {
//			if (relation.isCyclic()) {
//				System.out.println(relation.getDominant().getPosition().getStartLine());
//				System.out.println(relation.getDependent().getPosition().getStartLine());
//			}
//		}
//	}
//	
//	public void print() {
//		for (DependencyPair relation : dependencyClosure) {
//			relation.print();
//		}
//	}	
}
