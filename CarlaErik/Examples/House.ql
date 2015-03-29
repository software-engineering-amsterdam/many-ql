hasBoughtHouse "Did you buy a house in 2010?" bool
hasMaintLoan "Did you enter a loan?" bool
hasSoldHouse "Did you sell a house?" bool

if(hasSoldHouse && hasMaintLoan) 
{
	sellingPrice "What was the selling price?" int
	privateDebt "Private debts for the sold house:" int
	
	result "Your result: " int = sellingPrice - privateDebt
}

