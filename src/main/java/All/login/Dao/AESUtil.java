package All.login.Dao;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    public static final String algorithm = "AES";
    // AES/CBC/NOPaddin
    // AES Ĭ��ģʽ
    // ʹ��CBCģʽ, �ڳ�ʼ��Cipher����ʱ, ��Ҫ���Ӳ���, ��ʼ������IV : IvParameterSpec iv = new
    // IvParameterSpec(key.getBytes());
    // NOPadding: ʹ��NOPaddingģʽʱ, ԭ�ĳ��ȱ�����8byte��������
    public static final String transformation = "AES/CBC/NOPadding";
    public static final String key = "1234567812345678";

    /***
     * ����
     * @param original ��Ҫ���ܵĲ�����ע�������16λ��
     * @return
     * @throws Exception
     */
    public  String encryptByAES(String original) throws Exception {
        // ��ȡCipher
        Cipher cipher = Cipher.getInstance(transformation);
        // ������Կ
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // ָ��ģʽ(����)����Կ
        // ������ʼ������
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
        // cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        // ����
        byte[] bytes = cipher.doFinal(original.getBytes());

        return Base64Utils.encodeToString(bytes);
    }

    /**
     * ����
     * @param encrypted ��Ҫ���ܵĲ���
     * @return
     * @throws Exception
     */
    public  String decryptByAES(String encrypted) throws Exception {
        // ��ȡCipher
        Cipher cipher = Cipher.getInstance(transformation);
        // ������Կ
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // ָ��ģʽ(����)����Կ
        // ������ʼ������
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        // cipher.init(Cipher.DECRYPT_MODE, keySpec);
        // ����
        byte[] bytes = cipher.doFinal(Base64Utils.decodeFromString(encrypted));

        return new String(bytes);
    }
}