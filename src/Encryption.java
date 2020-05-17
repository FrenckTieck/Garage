import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

    private Cipher cipher;
    private Key key;
    private String text;
    private String bitKey = "n2r5u8x/A?D(G+Kb";

    public Encryption(String t){
        key = new SecretKeySpec(bitKey.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            text = new String(cipher.doFinal(t.getBytes()));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getText() {
        return text;
    }

    public String decrypt(){
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(text.getBytes()));
        } catch(Exception e){
            return e.getMessage();
        }
    }

    public void setText(String t) {
        try{
            cipher.init(Cipher.ENCRYPT_MODE, key);
            this.text = new String(cipher.doFinal(t.getBytes()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
