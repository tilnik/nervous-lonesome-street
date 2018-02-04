package si.tilnik.nls.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class PasswdUtil
{
    public static String md5base63Encode(String passwd)
    {
        return md5base63Encode(passwd.toCharArray());
    }

    public static String md5base63Encode(char[] passwd)
    {
        MessageDigest digest = null;

        try
        {
            digest = MessageDigest.getInstance("MD5");

            digest.update(toBytes(passwd));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        byte[] rawData = digest.digest();

        String asB64 = Base64.getEncoder().encodeToString(rawData);
        return asB64;
    }

    private static byte[] toBytes(char[] chars)
    {
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                byteBuffer.position(), byteBuffer.limit());
        Arrays.fill(charBuffer.array(), '\u0000'); // clear sensitive data
        Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
        return bytes;
    }
}
