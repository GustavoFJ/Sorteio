package com.companyex1;



import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Globo {

    private static Random rnd = new Random(); // Objeto responsavel por gerar numeros aleatorios.

    private static List<Integer> minhaListaBolas = new ArrayList<Integer>(); // Array lista responsavel por armazenar os numeros inteiros

    private static int unidadeBolasSorteadas = 0; // Numero de bolas sorteadas que se inicia em 0.

    private static String letraColuna; // Variavel que representa as letras das colunas do bingo.

    public static void inicializarBolas(){
        for ( int i = 0; i < 75; i++ ){
            minhaListaBolas.add(0);

        }

    } // Função controladora das bolas sorteadas, utilizando " for " para contagem. Com limite em 75.

    public static boolean checkNumber(int number){
        boolean result = true;
        if ( minhaListaBolas.get(number).equals(1) ) {
            result = false;
        }
        return result;
    } // Função responsavel por validar se a bola já foi sorteada ou não. função booleana.

    public static void rodarGlobo() {
        int ramdomNumber = rnd.nextInt(75); // 0 1 2 3 4
        while (!checkNumber(ramdomNumber)) {
            ramdomNumber = rnd.nextInt(75);
        }
        minhaListaBolas.set(ramdomNumber, 1);
        mostraMenssagem(ramdomNumber);
    } // Função que executa o sorteio das bolas e atuando como filtro, Verificando se ela já foi sorteada.

    public static String defineLetraColuna(int number){

        if(number >= 61) {
            letraColuna = " O ";
        } else if (number >= 46){
            letraColuna = " G ";
        } else if (number >= 31) {
            letraColuna = " N ";
        }else if (number >= 16) {
            letraColuna = " I ";
        }else {
            letraColuna = " B ";
        }
        return letraColuna;
    } //  Função que define quais bolas perntecerá a cada letra, baseada em seu valor.

    public static void  mostraMenssagem(int ramdomNumber){

        System.out.println("Bola...");
        System.out.println(defineLetraColuna(ramdomNumber + 1) + (ramdomNumber + 1));
    } // Função para printar as bolas sorteadas.


    public static void main(String[] args) {

        Scanner tcd = new Scanner(System.in);
        boolean cont = true;
        String resp = "";
        inicializarBolas();
        while ( cont ){
            unidadeBolasSorteadas++;
            System.out.println("Tecle algo");
            resp = tcd.next();
            if( unidadeBolasSorteadas == 75) {
                cont = false;
                System.out.println("Fim das Bolas");
            }
            rodarGlobo();
        }

    } // Função que controladora para sorteio de cada bola,atraves de teclas. tTmbem printa as bolas sorteadas e anunciao fim do jogo na ultima bola.
}
