package com.mazad.Diana.utels;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isEditTextEmpty(EditText editText) {
        return isTextEmpty(editText.getText().toString().trim());
    }

    public static boolean isTextEmpty(String text) {
        return text.equals("");
    }

    public static boolean validEmail(String email) {

        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


    public static boolean validPasswordLength(String password) {
        return !(password.length() < 6 || password.length() > 50);
    }
    public static boolean isMatch(String word1, String word2) {
        return word1.equals(word2);
    }

    public static boolean validMobileNumber(String number) {
        return number.length() <= 14 && number.length() >= 11 && number.matches("^[0-9]+$");
    }
    public static boolean validAmountPaid(String totalamount,String paindamount) {
        double total = Double.parseDouble(totalamount);
        double paid = Double.parseDouble(paindamount);
        if (total >=paid)
        {
            return true;
        }else {
            return  false ;
        }
    }

    public static String[]  PaternString(String qrCode) {
        Pattern pattern = Pattern.compile(".,.");
        Matcher matcher = pattern.matcher(qrCode);
        String[] parts = qrCode.split(",");
        if (matcher.find())
            return parts ;
        else
            return  null ;
    }

    public static String checkStringWithZeroBegin(String number,String code) {
        String res = "";
        if (code.equalsIgnoreCase("+20")) {
            if (number.startsWith("0")) {
                res = number.substring(1, number.length());
            } else if (number.equals("20")) {
                res = number.substring(2, number.length());
            } else if (number.equals("+20")) {
                res = number.substring(3, number.length());
            } else {
                res = number;
            }
            return res;
        }
        return number;

    }
    public  static String CheckStringWithCode(String number,String code) {
        String res = "";
        if (number.startsWith(code)) {
            char[] arr = number.toCharArray();
            int codeLength = code.length();
            for (int i = codeLength; i < arr.length; i++) {
                res += arr[i];
            }
        } else {
            res = number;
        }
        return res;
    }


}
