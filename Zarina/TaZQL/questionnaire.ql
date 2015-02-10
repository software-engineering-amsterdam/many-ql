FORM firstQ {
	hasSoldHouse [Did you sell a house in 2010?] choice
	hasBoughtHouse [Did you buy a house in 2010?] choice
 	if (hasSoldHouse) {
		sellingPrice [What was the selling price?] digit
		privateDebt [Private debts for the sold house:] digit
		valueResidue [All that left is: ] digit (sellingPrice - valueResidue)
	}	
} END	


