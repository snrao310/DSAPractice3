public class MultiplyStringsLeetCode {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int n = num1.length(), m = num2.length();
        StringBuilder prod = new StringBuilder("0");
        for (int i = m - 1; i >= 0; i--) {
            int carry = 0, dig = m - i - 1;
            StringBuilder p = new StringBuilder("");
            for (int k = 0; k < dig; k++) {
                p.append("0");
            }
            for (int j = n - 1; j >= 0; j--) {
                int s = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;
                carry = s / 10;
                s = s % 10;
                p.insert(0, s);
            }
            if (carry != 0)
                p.insert(0, carry);
            prod = add(prod, p);
        }
        return prod.toString();
    }

    public static StringBuilder add(StringBuilder a, StringBuilder b) {
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        StringBuilder res = new StringBuilder("");
        for (; i >= 0 && j >= 0; i--, j--) {
            int adig = a.charAt(i) - '0';
            int bdig = b.charAt(j) - '0';
            int c = adig + bdig + carry;
            carry = c / 10;
            c = c % 10;
            String g = String.valueOf(c);
            res.insert(0, String.valueOf(c));
        }
        if (i < 0) {
            while (j >= 0) {
                int c = b.charAt(j) - '0' + carry;
                carry = c / 10;
                c = c % 10;
                res.insert(0, String.valueOf(c));
                j--;
            }
        } else if (j < 0) {
            while (i >= 0) {
                int c = a.charAt(i) - '0' + carry;
                carry = c / 10;
                c = c % 10;
                res.insert(0, String.valueOf(c));
                i--;
            }
        }
        if (carry != 0)
            res.insert(0, "1");
        return res;
    }

    public static void main(String[] args) {
        String num1 = "33", num2 = "44";
        System.out.println(multiply(num1, num2));
    }

}
