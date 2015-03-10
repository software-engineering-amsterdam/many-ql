form taxOfficeExample {
	firstValue: integer {
		"First value:"
	}
	secondValue: integer {
		"Second value:"
	}
	assignedValue: integer {
		"Addition of first and second value:"
		assign(firstValue + secondValue)
	}
	
	booleanValue: boolean {
		"Are you awesome?"
	}
	
	booleanValueCopy: boolean {
		"Copies the question above"
		assign(booleanValue)
	}
			
	if (booleanValue || firstValue == 10) {
		sellingPrice: money {
			"What was the selling price?"
		}
		privateDebt: money {
			"Private debts for the sold house:"
		}
		
		valueResidue: integer {
			"Value residue:"
			assign(sellingPrice - privateDebt)
		}
	
		if(firstValue == 100) {
			lol: string {
				"is this IF active??"
			}
		}
	}
	else {
		lol2: string {
			"This is the else"
		}
		lol3: integer {
			"This is the else second"
		}
	}
}