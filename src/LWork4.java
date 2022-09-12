import java.util.Arrays;
import java.util.stream.Collectors;

public class LWork4 {
    public static String encrypt(String[] message,String[] key,String param){
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        StringBuilder result = new StringBuilder();
        int sPosition;
        int keyChanger = 0;
        int j = 1 ;

        for (int i = 0; i < message.length; i++) {
            if(alphabet.contains(message[i].toLowerCase())){
                if(param.equalsIgnoreCase("decrypt")) j = -1;
                sPosition = alphabet.indexOf(message[i].toLowerCase()) + alphabet.indexOf(key[keyChanger]) * j;
                if(sPosition > 32) sPosition = sPosition - 33;
                if(sPosition < 0) sPosition = 33 + sPosition;
                result.append(Character.isUpperCase(message[i].charAt(0)) ? String.valueOf(alphabet.charAt(sPosition)).toUpperCase() : alphabet.charAt(sPosition));
                keyChanger++;
                if(keyChanger>key.length-1) keyChanger = 0;
            }else{
                result.append(message[i]);
            }
        }
        return result.toString();


    }
    public static void main(String[] args) {


        String[] message = "Важной характеристикой Европейских Критериев является отсутствие априорных требований к условиям, в которых должна работать информационная система.".split("");
        String[] key = "ананасовыйсок".split("");

        message = (encrypt(message,key,"encrypt")).split("");

        System.out.println("Зашифрованное сообщение: \n\n" + Arrays.stream(message).collect(Collectors.joining()));

        System.out.println("\nИсходное сообщение: \n\n " + encrypt(message,key,"decrypt"));







    }
}
