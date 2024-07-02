package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPostition;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while(true){
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPostition source = UI.redChessPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            ChessPostition target = UI.redChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }

        
    }
}
