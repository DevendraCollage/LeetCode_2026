import java.util.*;

class Fancy {

    static final long MOD = 1000000007;

    List<Long> values = new ArrayList<>();
    List<Long> mulAtInsert = new ArrayList<>();
    List<Long> addAtInsert = new ArrayList<>();

    long mul = 1;
    long add = 0;

    public Fancy() {
    }

    public void append(int val) {
        values.add((long) val);
        mulAtInsert.add(mul);
        addAtInsert.add(add);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= values.size())
            return -1;

        long val = values.get(idx);
        long m0 = mulAtInsert.get(idx);
        long a0 = addAtInsert.get(idx);

        long mulDiff = mul * modInverse(m0) % MOD;

        long result = (val * mulDiff) % MOD;
        result = (result + (add - a0 * mulDiff % MOD + MOD) % MOD) % MOD;

        return (int) result;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}