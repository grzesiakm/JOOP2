import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BigInt {
    private final byte[] arrb;

    public BigInt(byte[] arrb) {
        this.arrb = arrb;
    }

    public BigInt(String arrc) {
        this.arrb = arrc.getBytes();
    }

    public BigInt(BigInt bi) {
        this.arrb = bi.getNum();
    }

    @Override
    public boolean equals(Object obj) {
        byte[] array = obj.toString().getBytes();
        if (Arrays.equals(array, this.toString().getBytes())){
            return true;
        }
        else {
            System.out.println("The values are not the same.");
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < arrb.length; i++){
            s += (char)arrb[i];
        }
        return s;
    }

    public byte[] getNum() {
        return arrb;
    }

    public static BigInt add(BigInt a, BigInt b) {
        BigInteger res  = new BigInteger(a.arrb).add(new BigInteger(b.arrb));
        return new BigInt(res.toString());
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    public static void test1000(){
        for(int i = 0; i < 1000; i++){
            Long a = ThreadLocalRandom.current().nextLong((long)(Math.pow(2, 62)));
            Long b = ThreadLocalRandom.current().nextLong((long)(Math.pow(2, 62)));
            Long res1 = a+b;
            byte[] ba = longToBytes(a);
            byte[] bb = longToBytes(b);
            BigInt A = new BigInt(ba);
            BigInt B = new BigInt(bb);
            BigInt res2 = add(A, B);
            System.out.println("Added long values: " + res1);
            System.out.println("Added BigInt values: " + res2.toString());
            System.out.println();
        }
    }

    private static void test1001() {
        String a = String.valueOf(1L);
        String b = "9999999999999999999";
        BigInteger ba = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger res1 = ba.add(bb);
        BigInt A = new BigInt(a);
        BigInt B = new BigInt(b);
        BigInt res2 = add(A, B);
        System.out.println("Added long values: " + res1);
        System.out.println("Added BigInt values: " + res2.toString());
        System.out.println(res1.equals(res2.toString()));
        if (!res1.equals(res2.toString())) System.exit(-1);
    }

    private static void test1002() {
        String a = "9999999999999999999";
        String b = String.valueOf(1L);
        BigInteger ba = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        BigInteger res1 = ba.add(bb);
        BigInt A = new BigInt(a);
        BigInt B = new BigInt(b);
        BigInt res2 = add(A, B);
        System.out.println("Added long values: " + res1);
        System.out.println("Added BigInt values: " + res2.toString());
        System.out.println(res1.equals(res2.toString()));
        if (!res1.equals(res2.toString())) System.exit(-2);
    }

    public static void main(String[] args) {
        test1000();
        test1001();
        test1002();
    }

}
