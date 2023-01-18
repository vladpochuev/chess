package Chess;

class Solution {
    public String convertToTitle(int columnNumber) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber>0){
            columnNumber--;
            stringBuilder.append(letters.charAt(columnNumber%26));
            columnNumber /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
