package com.mybao123.dao;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateKeySpec;

import javax.crypto.Cipher;

import org.springframework.stereotype.Repository;

/**
 * RSA 工具类。提供加密，解密，生成密钥对等方法。
 * 需要到http://www.bouncycastle.org下载bcprov-jdk14-123.jar。
 * 
 */

@Repository
public class RSAUtils
{

	public PrivateKey getPrivateKey(String modulus, String privateExponent)
			throws Exception
	{
		PrivateKey privateKey = null;
		try
		{
			BigInteger m = new BigInteger(modulus);
			BigInteger e = new BigInteger(privateExponent);
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
	@SuppressWarnings("restriction")
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