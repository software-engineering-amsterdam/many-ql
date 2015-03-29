form TestForm {
	
	question integer someQuestion ("This is some question");
	
	question integer anotherQuestion ("This is an another question"){
		anotherQuestion : someQuestion * 100;
	}
	
	question money thirdQuestion ("This is the third, and last question"){
		thirdQuestion : anotherQuestion + false * 100;
	}
	
	question boolean invalidBooleanOperands("Some boolean question"){
		invalidBooleanOperands : (thirdQuestion * 2) >= true;
	}
}