package io.algoexpert.easy;

public class CeeserCipherEncryptor {

    public  String moddedString(String string, int key) {
        key = key % 26;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = getNewLetter(chars[i], key);
        }
        return new String(chars);
    }

    private  char getNewLetter(char ch, int key) {
        int num = ch;
        num = num + key;
        if (num > 122) {
//            num = 96 + (num % 122);
            num = num - 26;
        }
        return (char) (num);
    }

    public static void main(String[] args) {
        CeeserCipherEncryptor input = new CeeserCipherEncryptor();
        String str = "xyz";
        System.out.println("The converted String of " + str + " is : " + input.moddedString(str, 54));
        System.out.println("The converted String of " + str + " is : " + input.moddedString(str, 2));
    }

}
