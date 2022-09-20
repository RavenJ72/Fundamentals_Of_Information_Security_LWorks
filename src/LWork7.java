import java.util.Scanner;
public class LWork7 {

    public static String toBinary(int a) {
        int i, b;
        StringBuilder result = new StringBuilder();
        while (a != 0) {
            b = a % 2;
            result.append(b);
            a = a / 2;
        }
        return result.reverse().toString();
    }

    public static String fineXOR(String x,String y){

        String result = "";
        if(x.length()!=y.length()){
            String helpLine = "";
            for (int i = 0; i < Math.abs(x.length()-y.length()); i++) {
                helpLine += "0";
            }
            if(x.length()<y.length()){
                x =  helpLine + x;
            }else{
                y = helpLine + y;
            }
        }

        for (int i = 0; i <x.length(); i++) {
            if(x.charAt(i) != y.charAt(i)){
                result += "1";
            }else{
                result += "0";
            }
        }

        return String.valueOf((char)Integer.parseInt(result,2));
    }

    public static String scaling(String message,String key){
        int keyChanger = 0;
        String result = "";
        for (int i = 0; i < message.length(); i++,keyChanger++) {
            if(keyChanger>key.length()-1){keyChanger = 0;}
            result += fineXOR(toBinary(message.charAt(i)),toBinary(key.charAt(keyChanger)));


        }
        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Добрый день, введите ,пожалуста, ключ(слово) по которому будет произведена зашифровка.");
        String key = in.nextLine();
        System.out.println("Теперь, введите сообщение, которое нужно зашифровать.");
        String message = in.nextLine();
        String result = scaling(message,key);

        System.out.println("Зашифрованное сообщение: " + result);
        System.out.println("Дешифрованное сообщение: " + scaling(result,key));
    }
}
