package src.Compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Teste {
    public static void main(String[] args) {

        String arquivoEntrada, arquivoSaida, linhaCompilada;
//        Scanner sc = new Scanner(System.in);
        RegexCompilador regex = new RegexCompilador();
//
//        arquivoEntrada = sc.next();
//        arquivoSaida = sc.next();
        arquivoEntrada = "arq.txt";
        arquivoSaida = "saida.boolc";



        try(BufferedReader bf = new BufferedReader( new FileReader(arquivoEntrada) )) {
            FileWriter fw;
            fw = new FileWriter(arquivoSaida);

            String linha = bf.readLine();
            while(linha != null){
//                System.out.println(linha);
                linhaCompilada = regex.mainRgex(linha, bf);
//                System.out.println(linhaCompilada + "  7");
                fw.write(linhaCompilada);
                linha = bf.readLine();


            }
            fw.close();

        } catch (Exception e){
            System.out.println("Erro " + e);
        }
        

    }
}
