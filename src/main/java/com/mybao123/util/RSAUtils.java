package com.mybao123.util;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateKeySpec;

import javax.crypto.Cipher;

/**
 * RSA 工具类。提供加密，解密，生成密钥对等方法。
 * 需要到http://www.bouncycastle.org下载bcprov-jdk14-123.jar。
 * 
 */
public class RSAUtils
{
	/** 
     * 私钥Exponet 
     */   
    private static String privateExponet   = "c4f2f4259062203cd1dab960cfe68ffd57399837a8804d58169e01942fc491dddb31ce29b08a6a393bc8378408fda6201280bbd560a0c68177327d1368a4ba1";
    /** 
     * 私钥module 
     */  
    private static String modulus  = "88f6ae182d92151ed240e0c7f51136144609dd5ced49f28171ef33af1e3b1d64c7b5939bc0b12e22f3a046168f8890371555e933a2a5714f7b3a858946eea17f";
    
	public static PrivateKey getPrivateKey()
			throws Exception
	{
		PrivateKey privateKey = null;
		try
		{
			BigInteger m = new BigInteger(modulus);
			BigInteger e = new BigInteger(privateExponet);
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			privateKey = keyFactory.generatePrivate(keySpec);
			return privateKey;
		} catch (Exception ex)
		{
			return privateKey;
		}
	}

	/**
	 * 数据RSA解密
	 * 
	 * @param enc
	 *            密文
	 * @return 明文
	 */
	public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception
	{
		try
		{
			Cipher cipher = Cipher.getInstance("RSA",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher.init(Cipher.DECRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
			int j = 0;

			while (raw.length - j * blockSize > 0)
			{
				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
				j++;
			}
			return bout.toByteArray();
		} catch (Exception e)
		{
			return null;
		}
	}
}