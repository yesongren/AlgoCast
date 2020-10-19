package solutions;

/**
 * Created by yesongren on 2020/10/20
 * 050. Pow(x, n)
 */
public class P010_Pow_x_n {
    public double myPow(double x, int n) {
        int tmp_n = n;
        double ans = 1.0;
        while (n != 0) {
            if ((n & 1) == 1) ans *= x;
            x *= x;
            n /= 2;
        }
        return tmp_n > 0 ? ans : 1 / ans;
    }
}
