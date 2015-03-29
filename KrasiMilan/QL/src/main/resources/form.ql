form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you by a house in 2010?" boolean
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean(hasSoldHouse || hasBoughtHouse)

	if (hasSoldHouse) {
		sellingPrice: "Price the house was sold for:" number
		privateDebt: "Private debts for the sold house:" number
		valueResidue: "Value residue:" number(sellingPrice + privateDebt)
	}

	color: "Enter a color:" string
	anotherColor: "Enter another color:" string
	matchingColors: "Matching colors:" boolean(color == anotherColor)
}