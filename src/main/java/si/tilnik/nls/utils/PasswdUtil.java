package si.tilnik.nls.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import java.util.function.Function;

public class PasswdUtil
{
    //private static final String digestAlgorithm = "MD5";
    private static final String digestAlgorithm = "SHA-256";

    public static void main(String[] args)
    {
        Function<String[], String> f = a -> Optional.ofNullable(a)
                .filter(x -> x.length > 0)
                .map(x -> x[0])
                .orElse("geslo1.");

        String passwd = f.apply(args);
        System.out.println(String.format("%s Base64 encoded %s=%s", digestAlgorithm, passwd, encode(passwd)));
    }

    public static String encode(String passwd)
    {
        return encode(passwd.toCharArray());
    }

    public static String encode(char[] passwd)
    {
        MessageDigest digest = null;

        try
        {
            digest = MessageDigest.getInstance(digestAlgorithm);

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
