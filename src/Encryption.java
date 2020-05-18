import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

    private Cipher cipher;
    private Key key;
    private byte[] text;
    private String bitKey = "asdfgghkluqwerty";

    public Encryption(String t){
        key = new SecretKeySpec(bitKey.getBytes(), "AES");
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            text = cipher.doFinal(t.getBytes());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getText() {
        return new String(text);
    }

    public String decrypt(){
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(text));
        } catch(Exception e){
            return e.getMessage();
        }
    }

    public void setText(String t) {
        try{
            cipher.init(Cipher.ENCRYPT_MODE, key);
            this.text = cipher.doFinal(t.getBytes());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
