import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Character [] abc= { 'A','B','C','D','E','F','G','H',
                            'I','J','K','L','M','N','O','P',
                            'Q','R','S','T','U','V','W','X','Y','Z','_'
                        };

        cesarCypher hiddenMessage= new cesarCypher();
        //initialisiert das Alphabet
        hiddenMessage.initAlphabet(abc,0);



        System.out.println(
                hiddenMessage.encrypt(4,"HALLOICHBINPATRICK")
        );

        System.out.println(
                hiddenMessage.encrypt(4,"HALLOICHBINPATRICK")
        );

        String encMessag= hiddenMessage.encrypt(4,"HALLOICHBINPATRICK");

        System.out.println(
                hiddenMessage.decrypt(encMessag,4)
        );

    }
}
