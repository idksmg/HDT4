/**
 * @autor Sara Guzmán
 *
 * @version 0.1 18/02/2023
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args){
        FactoryStack<String> sFractory = new FactoryStack<String>();
        IPosfixCalculator myCalculator = new Calculadora();
        Scanner in = new Scanner(System.in);
        ArrayList<String> listaDeCadenas = new ArrayList<String>();
        System.out.println("Ingrese el tipo de Stack a utilizar, ej AL(ArrayList), VEC(Vector), LIST(Lista)");
        String opcion = in.nextLine();
        sFractory.getStack(opcion);
        System.out.println("Ingrese la ruta del archivo ej: C:\\ejemplos\\datos.txt");
        String fpath = in.nextLine();
        if(fpath == ""){
            fpath = "C:\\codigo\\SEMESTRE 3\\Calculator\\datos.txt";
        }
        try{
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                listaDeCadenas.add(data);
                System.out.println(data);
            }
            myReader.close();
            try{
                Integer resultado = myCalculator.Calculate(listaDeCadenas);
                System.out.println(resultado);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}