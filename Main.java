/**
 * @autor Sara Guzmán
 *
 * @version 1.4 18/02/2023
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        FactoryStack<String> sFractory = new FactoryStack<String>();
        ArrayList<Character> listaDeCadenas = new ArrayList<Character>();
        IPosfixCalculator myCalculator = new Calculadora(listaDeCadenas);
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el tipo de Stack a utilizar, ej AL(ArrayList), VEC(Vector), LIST(Lista)");
        String opcion = in.nextLine();
        sFractory.getStack(opcion);
        if(opcion.equals("LIST")){
            System.out.println("Elija el tipo de lista, ej: ENC(Encadenada), DENC(Doble Encadenada)");
            String tipo = in.nextLine();
            sFractory.getLista(tipo);
        }
        System.out.println("Ingrese la ruta del archivo ej: C:\\ejemplos\\datos.txt");
        String fpath = in.nextLine();
        if(fpath == ""){
            fpath = "C:\\codigo\\SEMESTRE 3\\Calculator\\datos.txt";
        }

        try{
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (char c : data.toCharArray()){ ;
                listaDeCadenas.add(c);
            }
                System.out.println(data);
            }
            myReader.close();
            try{
                listaDeCadenas = (ArrayList<Character>) myCalculator.infixToPostfix(listaDeCadenas);
                if(opcion.equals("AL")){
                    System.out.println(myCalculator.Calculate(listaDeCadenas));
                } else if (opcion.equals("VEC")) {
                    System.out.println(myCalculator.Calculate(listaDeCadenas));
                } else if (opcion.equals("LIST")) {
                    int resultado = myCalculator.CalculateList(listaDeCadenas);
                    System.out.println(resultado);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
