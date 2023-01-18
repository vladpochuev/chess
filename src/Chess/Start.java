package Chess;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        new Rook(-1, -1, 'c');
        for (boolean gameStatus = true; gameStatus; ) {
            ChessItem.showBoard();
            String pl1; // замінити методами
            System.out.println("white's move");
            while (true) {
                pl1 = verifyString();    //pl1
                if(pl1.substring(0, 2).equals(pl1.substring(2, 4))){
                    System.out.println("wrong move");
                    continue;
                }

                ChessItem pl1Item = ChessItem.board[Character.getNumericValue(pl1.charAt(0)) - 1][Character.getNumericValue(pl1.charAt(1)) - 1];

                if (pl1Item.getColor() == 'w' && pl1Item.move(pl1)){
                    ChessItem.board[Character.getNumericValue(pl1.charAt(0))-1][Character.getNumericValue(pl1.charAt(1))-1] = null;
                    break;
                } else {
                    System.out.println("wrong move");
                }
            }
            ChessItem.showBoard();

            String pl2;
            System.out.println("black's move");
            while (true) {
                pl2 = verifyString();    //pl2
                if(pl2.substring(0, 2).equals(pl2.substring(2, 4))){
                    System.out.println("wrong move");
                    continue;
                }

                ChessItem pl2Item = ChessItem.board[Character.getNumericValue(pl2.charAt(0)) - 1][Character.getNumericValue(pl2.charAt(1)) - 1];

                if (pl2Item.getColor() == 'b' && pl2Item.move(pl2)){
                    ChessItem.board[Character.getNumericValue(pl2.charAt(0))-1][Character.getNumericValue(pl2.charAt(1))-1] = null;
                    break;
                } else {
                    System.out.println("wrong move");
                }
            }
        }
    }

    private static String verifyString(){
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            String string = sc.nextLine();
            if (string.matches("[a-h][1-8] [a-h][1-8]")) {
                result = parseString(string);
                return result;
            } else {
                System.out.println("wrong move");
            }
        }
    }
    private static String parseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current >= 97 & current <= 104) {
                stringBuilder.append((char) (current - 48));
            } else if (current >=49 & current <= 56) {
                stringBuilder.append(current);
            }
        }
        return stringBuilder.toString();
    }

}