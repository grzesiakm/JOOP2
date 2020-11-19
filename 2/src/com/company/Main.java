package com.company;

import java.math.BigInteger;

class Main {

    public static BigInteger Eu(BigInteger a, BigInteger b) {
        while(b.compareTo(BigInteger.ZERO) != 0){
            BigInteger tmp = a.mod(b);
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        BigInteger p, q, n, phi, d, e;
        int arg1 = Integer.parseInt(args[0]);
        int arg2 = Integer.parseInt(args[1]);
        p = BigInteger.valueOf(arg1);
        q = BigInteger.valueOf(arg2);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger tmp = BigInteger.ZERO;
        for(e = BigInteger.valueOf(3); tmp.compareTo(BigInteger.ONE) != 0; e = e.add(BigInteger.TWO)){
            tmp = Eu(e, phi);
        }
        d = e.modInverse(phi);
        String cipher = args[2];
        System.out.println("Our message -> " + cipher);

        byte[] bytes = cipher.getBytes();
        int[] casts = new int[bytes.length];
        for(int i = 0; i < bytes.length; i++){
            casts[i] = (int)bytes[i];
        }

        BigInteger[] encryption = new BigInteger[bytes.length];
        for(int i = 0; i < bytes.length; i++){
            encryption[i] = BigInteger.valueOf(casts[i]).modPow(e, n);
        }

        BigInteger[] decryption = new BigInteger[bytes.length];
        for(int i = 0; i < bytes.length; i++){
            decryption[i] = encryption[i].modPow(d, n);
        }

        System.out.print("Encrypted: ");
        for(int i = 0; i<bytes.length; i++){
            System.out.print((char)encryption[i].intValue());
        }

        System.out.println();

        System.out.print("Decrypted: ");
        for(int i = 0; i<bytes.length; i++){
            System.out.print((char)decryption[i].intValue());
        }
    }
}