package backEnd;

import java.io.Serializable;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

public class Password implements Printable, Serializable {
    private String password;
    private int length;
    private static final String key = "Bar12345Bar12345";
    private static final Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    private static final int strongPasswordLenght = 12;
    private byte[] encrypted;

    public Password() {
        this.password = encryptPassword(generateStrongPassword());
        this.length = strongPasswordLenght;
    }

    public Password(String password) {
        this.password = encryptPassword(password);
        this.length = password.length();
    }


    private String encryptPassword(String toEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(toEncrypt.getBytes());
            return new String(encrypted);
        } catch (Exception e) {
            return "Encryption failed";
        }
    }

    private String decryptPassword() {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            return new String(cipher.doFinal(encrypted));
        } catch (Exception ex) {
            return "Decryption failed";
        }
    }

    public String generateStrongPassword() {
        String alphabet = "AQWERTYUFHVJX12345678901234678480801@@@CNSJWQPGTMKahsrtyriopsaxbnskdlx[]><!!%^$#&*)(++==)";
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Random random = new Random();
        StringBuilder generatedString = new StringBuilder();
        while (true) {
            for (int i = 0; i < strongPasswordLenght; i++) {
                int index = random.nextInt(alphabet.length());
                generatedString.append(alphabet.charAt(index));
            }
            if (generatedString.toString().matches(regex)) {
                return generatedString.toString();
            } else {
                generatedString.setLength(0);
            }
        }
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    private String getOriginalPassword() {
        return decryptPassword();
    }

    public String getEncryptedPassword() {
        return this.password;
    }

    public int getPasswordLength() {
        return this.length;
    }

    @Override
    public String listData() {
        return "Password: " + getOriginalPassword();
    }
}