
public class MonoalphabeticEx {
    public static String encrypt(String[] alphabet,String[] key,String[] message){
        boolean flag = false;
        String result = "";
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if(message[i].equalsIgnoreCase(alphabet[j])){
                    result += Character.isUpperCase(message[i].charAt(0)) ? key[j].toUpperCase() : key[j];
                    flag = true;
                    break;
                }
            }
            if(!flag) result += message[i];
            flag = false;
        }
        return result;
    }
    public static void main(String[] args) {

        String[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".split("");
        String[] key =      "чкгмопфухаэлбйъдтющвшсяежизынёрць".split("");
        String[] message = "Механизмы электронной подписи используются для реализации служб аутентификации и защиты от отказов.".split("");
        String result = encrypt(alphabet,key,message);
        System.out.println("Зашифрованное сообщение: \n" + result + "\nСообщение после дешифровки: \n" + encrypt(key,alphabet,result.split("")));
    }
}
