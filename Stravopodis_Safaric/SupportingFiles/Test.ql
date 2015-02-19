form HouseSelling {
    
    question hasSoldHouse typeof boolean {
        hasSoldHouse = "Did you sold an house?";
        hasSoldHouse = false;
    }
    question hasRentHouse typeof boolean {
        hasRentHouse = "Did you rent a house?";
        hasRentHouse = false;
    }
    if (hasSoldHouse == true){
        question hasBoughtHouse typeof int {
            hasBoughtHouse = "What was the price of the house?"; 
        }
        question houseCalculation typeof string {
            houseCalculation = "The price of the house";
            houseCalculation = hasBoughtBouse * 100;
        }
    }
}
