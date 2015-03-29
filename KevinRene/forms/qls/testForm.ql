form taxOfficeExample {
	firstInteger: integer {
		"First value:"
	}
	booleanValue: boolean {
		"Second value:"
	}
	if (booleanValue || firstInteger == 10) {
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
		if(firstInteger == 100) {
			firstString: string {
				"is this IF active??"
			}
		}		
	}
	else {
		secondString: string {
			"This is the else"
		}
		secondInteger: integer {
			"This is the else second"
		}
	}
 }
