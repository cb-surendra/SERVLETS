public class IncomeTax {
    float taxableIncome;

    public IncomeTax(float taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    float taxForMaleEmployee(){
        float totalTax = 0;
        if(this.taxableIncome > 10){
            float t = this.taxableIncome;
            totalTax += 2.5*0.05;
            totalTax += 5*0.2;
            totalTax += (t-7.5)*0.3;
        }
        else if(this.taxableIncome > 5 &&  this.taxableIncome <= 10){
            float t = this.taxableIncome;
            totalTax += 2.5*0.05;
            totalTax += (t-2.5)*0.2;
        }
        else if(this.taxableIncome > 2.5 && this.taxableIncome <= 5){
            float t = this.taxableIncome;
            totalTax += (t-2.5)*0.05;
        }
        else{
            totalTax = 0;
        }
        return totalTax;
    }

    float taxForFemaleEmplpyee(){
        float totalTax = 0;
        if(this.taxableIncome > 10){
            float t = this.taxableIncome;
            totalTax += 2.5*0.03;
            totalTax += 5*0.15;
            totalTax += (t-7.5)*0.2;
        }
        else if(this.taxableIncome > 5 &&  this.taxableIncome < 10){
            float t = this.taxableIncome;
            totalTax += 2.5*0.03;
            totalTax += (t-2.5)*0.15;
        }
        else{
            float t = this.taxableIncome;
            totalTax += (t-2.5)*0.03;
        }
        return totalTax;
    }
}
