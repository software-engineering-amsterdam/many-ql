form TestForm {
	
	question integer a ("a");	// by default, will be 0
	
	question money b ("b"){
		b : 2;
	}
	
	question integer c ("c"){
		c : (a + 1) * b; 
	}
	
}