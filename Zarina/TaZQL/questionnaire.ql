FORM firstQ {
	hasSoldHouse [Did you sell a house in 2010?] boolean
	hasBoughtHouse [Did you buy a house in 2010?] boolean
 	if (hasSoldHouse) {
		sellingPrice [What was the selling price?] integer
		privateDebt [Private debts for the sold house:] integer
		valueResidue [All that left is: ] integer 
	}	
} END	


