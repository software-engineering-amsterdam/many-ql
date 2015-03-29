form testForm {
	
	question integer a ("a");
	
	question integer b ("b");
	
	question integer c ("c");
	
	question integer d ("d");
	
	question integer e ("e"){
		e : 100 * f;
	}
	
	question integer f ("f"){
		f : 100 * e;
	}
	
}