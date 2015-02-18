form formName {

	question Q1 (string, required) "TEXT";
	statement S1 (string, "show this string") "Label";
	statement S2 (string, (Q1 * 5 + 4 / 3 - 6)) "Label";

	if( condition ) {
		//
		
	} else if (condition) {
		//
		
	} else {
		//
		
	}

}