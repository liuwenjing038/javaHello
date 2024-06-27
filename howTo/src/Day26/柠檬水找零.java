package Day26;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }else if (bills[i] == 10) {
                five--;
                ten++;
            }else {
                if (ten > 0) {
                    ten--;
                    five--;
                }else {
                    five -= 3;
                }
            }
            //需要注意一定要每一步都判断  只最后判断可以回中间负了后面又加回去了
            if (five < 0 || ten < 0) return  false;
        }
        return true;
    }
}
