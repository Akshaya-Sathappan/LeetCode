class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarBill = 0;
        int tenDollarBill = 0;

        for(int i : bills){
            if(i == 5){
                fiveDollarBill++;
            }
            else if(i == 10){
                tenDollarBill++;
                if(fiveDollarBill > 0){
                    fiveDollarBill--;
                }
                else{
                    return false;
                }
            }
            else{
                if(tenDollarBill >= 1 && fiveDollarBill >= 1){
                    tenDollarBill--;
                    fiveDollarBill--;
                }
                else if(fiveDollarBill >= 3){
                    fiveDollarBill -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}