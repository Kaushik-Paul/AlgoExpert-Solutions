package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonics {

    private Map<Character, Character[]> digitLetters;

    public PhoneNumberMnemonics() {
        digitLetters = new HashMap<>();
        digitLetters.put('0', new Character[]{'0'});
        digitLetters.put('1', new Character[]{'1'});
        digitLetters.put('2', new Character[]{'a', 'b', 'c'});
        digitLetters.put('3', new Character[]{'d', 'e', 'f'});
        digitLetters.put('4', new Character[]{'g', 'h', 'i'});
        digitLetters.put('5', new Character[]{'j', 'k', 'l'});
        digitLetters.put('6', new Character[]{'m', 'n', 'o'});
        digitLetters.put('7', new Character[]{'p', 'q', 'r', 's'});
        digitLetters.put('8', new Character[]{'t', 'u', 'v'});
        digitLetters.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> phoneNumberMnemonics(String phoneNumber) {
        char[] currentMnemonics = new char[phoneNumber.length()];
        List<String> mnemonicsFound = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonics, mnemonicsFound);
        return mnemonicsFound;
    }

    private void phoneNumberMnemonicsHelper(int idx, String phoneNumber, char[] currentMnemonics, List<String> mnemonicsFound) {
        if (idx == phoneNumber.length()) {
            mnemonicsFound.add(new String(currentMnemonics));
            return;
        }
        char digit = phoneNumber.charAt(idx);
        Character[] letters = digitLetters.get(digit);
        for (char ch : letters) {
            currentMnemonics[idx] = ch;
            phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonics, mnemonicsFound);
        }
    }

    public static void main(String[] args) {
        PhoneNumberMnemonics mnemonics = new PhoneNumberMnemonics();
        String phoneNumber = "1905";
        System.out.println("All Possible Mnemonics: " + mnemonics.phoneNumberMnemonics(phoneNumber));
    }
}
