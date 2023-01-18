package Chess;

public class Rook extends ChessItem {
    public Rook(int y, int x, char color) {
        super(y, x, color);
    }

    static {
        Rook whiteRook1 = new Rook(1,1,'w');
        Rook whiteRook2 = new Rook(1,8,'w');
        Rook blackRook1 = new Rook(8,1,'b');
        Rook blackRook2 = new Rook(8,8,'b');

        ChessItem.allItems.add(whiteRook1);
        ChessItem.allItems.add(whiteRook2);
        ChessItem.allItems.add(blackRook1);
        ChessItem.allItems.add(blackRook2);
    }


    @Override
    public boolean move(String s) {
        if((Character.getNumericValue(s.charAt(2))==getX() && Character.getNumericValue(s.charAt(3))!=getY())
                || (Character.getNumericValue(s.charAt(2))!=getX() && Character.getNumericValue(s.charAt(3))==getY())){
            setX(Character.getNumericValue(s.charAt(2)));
            setY(Character.getNumericValue(s.charAt(3)));
            return true;
        } else return false;
    }
}
