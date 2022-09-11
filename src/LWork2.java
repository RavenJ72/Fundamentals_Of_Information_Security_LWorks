public class LWork2 {

    public static String encrypt(String[] alphabet,String[][] key,String[] message,String param){
        String result = "";
        int keyChanger = 0;
        boolean flag = false;


        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if(param.equalsIgnoreCase("encrypt")){
                    if(message[i].equalsIgnoreCase(alphabet[j])){
                        result += Character.isUpperCase(message[i].charAt(0)) ? key[keyChanger][j].toUpperCase() : key[keyChanger][j];
                        keyChanger++;
                        if(keyChanger>3) keyChanger = 0;
                        flag = true;
                        break;
                    }
                }else if(param.equalsIgnoreCase("decrypt")){
                    if(message[i].equalsIgnoreCase(key[keyChanger][j])){
                        result += Character.isUpperCase(message[i].charAt(0)) ? alphabet[j].toUpperCase() : alphabet[j];
                        keyChanger++;
                        if(keyChanger>3) keyChanger = 0;
                        flag = true;
                        break;
                    }
                }else{
                    return "";
                }
            }
            if(!flag) result += message[i];
            flag = false;
        }
        return result;
    }


    public static void main(String[] args) {
        String[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя,№$)('>< ".split("");
        String[][] key  =  {
                "ьаебх)лгпш№нй>дюмкщъ,'эы$зоучвтфёия(<црсж|".split(""),
                "мжаэ'лк>я,двю|нчьецёзбъыт)щ<ги№пшоусй$(фрх".split(""),
                "lbъiбeatоmuqf)ns№wитcгkdшzhyoj<ыrущgп|зvpx".split(""),
                "d№tsmпjaq)ыiгтъ<шозr exиczlщkbofvуwhnyбupg".split(""),
        };

        String[] message = "История - самый лучший учитель, у которого самые плохие ученики.".split("");

        message = encrypt(alphabet,key,message,"encrypt").split("");

        System.out.println("Зашифрованное сообщение: \n" + message + "\nСообщение после дешифровки: \n" + encrypt(alphabet,key,message,"decrypt"));
    }
}
