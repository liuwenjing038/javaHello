package Day5;

import java.util.HashSet;

public class 快乐数 {
    /*
    *
    * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
    * */
    public boolean isHappy(int n) {
        //最终能算成1 说明中间没有重复的数字,否则会死循环
        HashSet<Integer>set = new HashSet<>();
        while (n!=1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        //这里n=1或者死循环的值
        return n==1;
    }

    public int getNext(int n){
       int sum = 0;
       while(n>0){
           int temp = n%10;
           sum += temp*temp;
           n = n/10;
       }
       return sum;
    }

}
