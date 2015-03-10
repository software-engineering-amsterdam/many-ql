package nl.uva.se.interpretation;

import nl.uva.se.ast.form.Form;
import nl.uva.se.evaluation.Evaluator;
import nl.uva.se.evaluation.ValueTable;
import nl.uva.se.interpretation.error.ErrorList;
import nl.uva.se.typechecking.SymbolTable;
import nl.uva.se.typechecking.TypeChecker;

public class Interpreter {
	
	private Interpreter() {
	}

	public static Result<ValueTable> interpret(Form form) {
		Result<SymbolTable> result = TypeChecker.check(form);
		ErrorList errorList = result.getErrorList();
		
		if (!errorList.hasErrors()) {
			SymbolTable symbolTable = result.getResult();
			ValueTable valueTable = Evaluator.evaluate(form);
			
			// TODO: Remove this!
			result.getErrorList().printAll();
			System.out.println("symbolTable");
			System.out.println(symbolTable);
			System.out.println("valueTable");
			System.out.println(valueTable);
			
			return new Result<ValueTable>(errorList, valueTable);
		}
		
		result.getErrorList().printAll();
		
		return new Result<ValueTable>(errorList, null);
	}
	
}
