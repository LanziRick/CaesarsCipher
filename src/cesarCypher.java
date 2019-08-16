import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class cesarCypher {

    public HashMap<Integer, Character> alphabet;

    //Konstruktor der die Nachricht in Array verwandelt
    public cesarCypher() {
        alphabet = new HashMap<>();
    }
    //initialisiert ein Alphabet
    public void initAlphabet(Character [] abc, Integer index){
        for(Character letter: abc) { // fueg jeden Buchstaben hinzu und erhöhe den Index
            alphabet.put(index, letter);
            index=index+1;
        }
    }


    //getKey gibts nich also iterativ suchen mit foreach
    public int getKey (Map <Integer,Character> map, char wanted){

        //Durchsucht das Set Entry nach dem Value und gibt den Key zurück
        for(Map.Entry<Integer,Character> entry: map.entrySet()){
            if(entry.getValue().equals(wanted)){
                return entry.getKey();
            }
        }
        throw  new NoSuchElementException("Buchstabe nicht im Alphabet enthalten.");
    }

    // Verschluesselt den index mit faktor k
    public int isEncIndex(char letter, int k){
        int key = getKey(alphabet,letter); // damit nicht der key der Map veraendert wird
        return (key+k)%27;
    }

    public String encrypt (int k,String message){
    //direk das messageArr benutzen
        int encIndex=0;
        char [] encMessage = message.toCharArray();// noch ist nix verschluesselt
        for (int i=0; i<encMessage.length; i++) {
            encIndex=isEncIndex(encMessage[i],k); // speicher verschluesselten index
            encMessage[i]=alphabet.get(encIndex);   //such den zugehoerigen buchstaben
        }
        return new String(encMessage); //die verschlüsselte nachricht als String
    }

    public int isDecIndex(char letter, int k){
        return (getKey(alphabet,letter)-k)%27;
    }

    public String decrypt (String encMessage,int k){
        //direk das messageArr benutzen
        int decIndex=0;
        char [] decMessage = encMessage.toCharArray();// noch ist nix verschluesselt
        for (int i=0; i<decMessage.length;i++) {
            decIndex=isDecIndex(decMessage[i],k); // speicher verschluesselten index
            decMessage[i]=alphabet.get(decIndex);   //such den zugehoerigen buchstaben
        }
        return new String(decMessage); //die verschlüsselte nachricht als Array
    }

}
