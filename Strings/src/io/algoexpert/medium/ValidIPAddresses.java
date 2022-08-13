package io.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddresses {

    public static List<String> validIpAddresses(String string) {
        List<String> ipAddressesFound = new ArrayList<>();

        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] ipAddressesParts = new String[]{"", "", "", ""};

            ipAddressesParts[0] = string.substring(0, i);
            if (!isIpPartValid(ipAddressesParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                ipAddressesParts[1] = string.substring(i, j);
                if (!isIpPartValid(ipAddressesParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    ipAddressesParts[2] = string.substring(j, k);
                    ipAddressesParts[3] = string.substring(k);

                    if (isIpPartValid(ipAddressesParts[2]) && isIpPartValid(ipAddressesParts[3])) {
                        ipAddressesFound.add(String.join(".", ipAddressesParts));
                    }
                }
            }
        }
        return ipAddressesFound;
    }

    private static boolean isIpPartValid(String string) {
        int integerOfIp = Integer.parseInt(string);
        if (integerOfIp > 255) {
            return false;
        }
        // to eliminate any leading zeroes
        return string.length() == String.valueOf(integerOfIp).length();
    }

    public static void main(String[] args) {
        String string = "1921680";
        List<String> ipAddresses = validIpAddresses(string);
        System.out.println("All the Valid Ip Addresses are: " + ipAddresses);
    }
}
