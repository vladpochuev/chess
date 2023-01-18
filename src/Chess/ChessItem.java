package Chess;

import java.util.ArrayList;

public abstract class ChessItem {
    static ChessItem[][] board = new ChessItem[8][8];
    static ArrayList<ChessItem> allItems = new ArrayList<>();
    private int x;
    private int y;
    private final char color;

    public ChessItem(int y, int x, char color) {
        this.y = y;
        this.x = x;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getColor() {
        return color;
    }

    public abstract boolean move(String str);

    public static void showBoard(){
        identifyItems();
        for (int i = board.length-1; i >= 0; --i) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[j][i]!=null){
                    System.out.print(board[j][i].recognizeItem()); // i , j змінені місцями (x - вертикаль, y - горизонталь)
                } else {
                    System.out.print(((i + j) % 2 == 0 ? '\u2B1C' : '\u2B1B'));
                }
            }
            System.out.println();
        }
    }
    private char recognizeItem(){ // замінити наслідуванням Chess.ChessItem -> Chess.Rook
        if(getClass()==Rook.class&&getColor()=='w'){
            return '\u2656';
        } else if (getClass()==Rook.class&&getColor()=='b') {
            return '\u265C';
        } else return '0';
    }

    private static void identifyItems(){
        for (int i = 0; i < allItems.size(); i++) {
            for (int j = 0; j < allItems.size(); j++) {
                board[(allItems.get(i).getX())-1][(allItems.get(i).getY())-1] = allItems.get(i);
            }
        }
    }
}
