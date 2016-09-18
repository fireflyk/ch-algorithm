package com.codinghero.acm;

public class Tax {

    public static void main(String[] args) {
        System.out.println("Pre tax at China: " + 39000 * 14);
        System.out.println("After tax at China: " + (33000 * 12 + 70000));
        System.out.println();
        System.out.println("Pre tax at US: " + 150000 * 6.5);
        System.out.println("After tax (others guessed): " + 6.5 * 150000 * 0.66);
        System.out.println("After tax (calculate with tax calculator): " + 9300 * 12 * 6.5);
        System.out.println("After tax (calculate with step tax): " + 6.5
                * (150000 - (18550 * 0.1 + (75300 - 18550) * 0.15 + (150000 - 75300) * 0.25) - 1000 * 12));
    }

}
