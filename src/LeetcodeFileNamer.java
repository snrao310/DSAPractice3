public class LeetcodeFileNamer {

    public static String file_name = "Minimum Window Substring";

    public static void main(String[] args) {
        file_name = file_name.replaceAll("[^A-Za-z0-9 ]", " ");
        String[] words = file_name.split(" ");
        String res = "";
        for (String word : words) {
            char[] wordArray = word.toCharArray();
            wordArray[0] = Character.toUpperCase(wordArray[0]);
            res+= String.valueOf(wordArray);
        }
        System.out.println(res+"LeetCode");
    }
}
