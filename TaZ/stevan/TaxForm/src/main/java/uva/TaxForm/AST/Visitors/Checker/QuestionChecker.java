package uva.TaxForm.AST.Visitors.Checker;

import java.util.LinkedList;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeQuestion.Question;

public class QuestionChecker {
	
	private static LinkedList<Question<?>> questions = new LinkedList<>();
	private static boolean duplicate = false;
	
	public boolean duplicates( Node node ) {
		
		LinkedList<? extends Node> nodes = node.getNodes();
		System.out.println(nodes.size());
		
		for ( int i=0; i<nodes.size(); i++ ) {
			
			if (nodes.get(i).getClass().equals(uva.TaxForm.AST.NodeQuestion.Question.class) ) {
				
				System.out.println( nodes.get(i).toString() );
				questions.add( (Question<?>) nodes.get(i) );
			} else {
				
				duplicates(nodes.get(i));
			}
		}
		
		if ( questions.size() > 0 ) {
			
			duplicate = sameQuestion( questions );
		}
		
		return duplicate;
	}
	
	private boolean sameQuestion( LinkedList<Question<?>> questions ) {
		
		for ( int i=0; i<questions.size(); i++ ) {
			
			Question<?> question = questions.pop();
			
			for ( int j=0; j<questions.size(); j++ ) {
				
				if ( sameLabel( question, questions.get(j) ) )
					duplicate = true;
				/*if ( sameLabel( question, questions.get(j) ) && sameType( question, questions.get(j) ) )
					duplicate = true;*/
			}
		}
		return duplicate;
	}
	
	private boolean sameLabel(Question<?> q1, Question<?> q2) {
		
		return q1.getLabel().equals( q2.getLabel() );
	}

	/*private boolean sameType(Question<?> q1, Question<?> q2) {
		
		System.out.println( q1.getVar().getName() );
		
		return false;
	}*/
}
