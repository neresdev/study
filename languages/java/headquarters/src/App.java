import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int linhaAnaliza, colunaAnaliza;
        Integer numeroEsquerda = 0, numeroDireita = 0, numeroCima = 0, numeroBaixo = 0;
        
        System.out.println("Digite quantas linhas a matriz vai ter");
        int qtdLinha = sc.nextInt();
        
        System.out.println("Digite quantas colunas a matriz vai ter");
        int qtdColuna = sc.nextInt();
        
        int[][] myMat = new int[qtdLinha][qtdColuna];
        
        for(int x = 0; x < myMat.length; x++ ) {
            for(int y = 0; y < qtdColuna; y++){
                System.out.println(
                        String.format("Número a ser colocado "
                                + "na linha %d, na coluna %d", x, y
                                )
                        );
                myMat[x][y] = sc.nextInt();
            }
        }
        System.out.println("-----------------------");
        
        for(int x = 0; x < myMat.length; x++ ) {
            
            for(int y = 0; y < qtdColuna; y++) {
                if(y == (qtdColuna-1) ) {
                    System.out.print(String.format("|%d|",myMat[x][y]));
                }else {
                    System.out.print(String.format("|%d",myMat[x][y]));
                }
                
            }
            System.out.println();
            
        }
        System.out.println("-----------------------");
        
        System.out.println("Digite a linha a ser analizada");
        linhaAnaliza = sc.nextInt(); 
        
        System.out.println("Digite a coluna a ser analizada");
        colunaAnaliza = sc.nextInt();
        
        for(int x = 0; x < myMat.length; x++ ) {
            for(int y = 0; y < qtdColuna; y++) {
                if((x == linhaAnaliza) && (y == colunaAnaliza)) {
                    try {
                        numeroEsquerda = myMat[x][y -1];
                    }catch(Exception e) {
                        numeroEsquerda = null;
                    }
                    
                    try {
                        numeroDireita = myMat[x][y +1];
                    }catch(Exception e) {
                        numeroDireita = null;
                    }
                    
                    try {
                        numeroCima = myMat[x - 1][y];
                    }catch(Exception e) {
                        numeroCima = null;
                    }
                    
                    try {
                        numeroBaixo = myMat[x + 1][y];
                    }catch(Exception e) {
                        numeroBaixo= null;
                    }
                }
            }
            
            
            
        }

        System.out.println("********* INFORMAÇÕES *********");
        if(numeroEsquerda != null) {
            System.out.println(String.format("Número que está a esquerda: %d", numeroEsquerda));
        }else {
            System.out.println("O número do lado esquerdo não existe.");
        }
        
        if(numeroDireita != null) {
            System.out.println(String.format("Número que está a direita: %d", numeroDireita));
        }else {
            System.out.println("O número do lado direito não existe.");
        }
        
        if(numeroCima != null) {
            System.out.println(String.format("Número que está em cima é: %d", numeroCima));
        }else {
            System.out.println("Não existe número em cima.");
        }
        
        if(numeroBaixo != null) {
            System.out.println(String.format("Número que está em baixo é: %d", numeroBaixo));
        }else {
            System.out.println("Não existe número em baixo.");
        }
        sc.close();
    }
}
