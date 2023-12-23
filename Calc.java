import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Calc{

    final static String[] meses = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
    final static String[] diasdasemana = {"segunda", "terça", "quarta", "quinta", "sexta", "sabado", "domingo"};
    final static int[] diasdomes = {30, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final String dir = "c:\\dadosvariaveisparaagenda.txt";
    public static Scanner scan = new Scanner(System.in);
    public static int calcincremento = 0;
    public static int diasdasemanaincremento = 0;
    public static int colunas = 0;

    public Calc(){
        System.out.println("digite a quantidade de colunas que voce deseja gerar: ");
        colunas = scan.nextInt();
    }
    public void percorrervetores(){
            try{
            FileWriter arq = new FileWriter(dir);
            PrintWriter print = new PrintWriter(arq);
            for(int i = 0; i < meses.length; i++ ){
                for(int j = 1; j <= diasdomes[i]; j++){
                    print.printf("%s, %d, %s, ",meses[i], j, diasdasemana[diasdasemanaincremento]);
                    calcincremento = calcincremento + 1;
                    diasdasemanaincremento = diasdasemanaincremento + 1;
                    if(calcincremento == colunas){
                        print.printf("\n");
                        calcincremento = 0;
                    }if(diasdasemanaincremento == 7){
                        diasdasemanaincremento = 0;
                    }
                }
            }
            scan.close();
            print.close();
            System.out.printf("gerado com sucesso, o arquivo foi salvo em: %s", dir);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
}