package com.mybao123.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec; 

import javax.crypto.Cipher;

import org.springframework.stereotype.Repository;
 

/** 
 * RSA 工具类。提供加密，解密，生成密钥对等方法。 
 * 需要到http://www.bouncycastle.org下载bcprov-jdk14-123.jar。 
 *  
 */

@Repository
public  class RSAUtils{  
	 
	/** 
     * 私钥 
     */  
    private static  RSAPrivateKey privateKey; 
	/** 
     * 从数据库私钥 
     * @param  
     */  
    public RSAPrivateKey  getPrivateKey(File file) {  
        getKey(file);  
        return privateKey;
    } 
    private void getKey(File file) {  
    	FileInputStream fis;  
        try {  
        	//读取数据  
            fis = new FileInputStream(file);  
            ObjectInputStream ois = new ObjectInputStream(fis);  
            byte [] keybyte = (byte[]) ois.readObject();  
            //关闭资源  
            ois.close();   
            //默认编码  
            KeyFactory keyfactory = KeyFactory.getInstance("RSA");  
            //得到私钥   
            PKCS8EncodedKeySpec pkcs8eks = new PKCS8EncodedKeySpec(keybyte);  
            privateKey = (RSAPrivateKey) keyfactory.generatePrivate(pkcs8eks);   
            
        } catch (Exception ex) {  
        	privateKey = null;
        }         
    }  
    /** 
     * 数据RSA解密 
     * @param enc 密文 
     * @return 明文 
     */
    @SuppressWarnings("restriction")
	public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {  
        try {  
            Cipher cipher = Cipher.getInstance("RSA",  
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());  
            cipher.init(Cipher.DECRYPT_MODE, pk);  
            int blockSize = cipher.getBlockSize();  
            ByteArrayOutputStream bout = new ByteArrayOutputStream(64);  
            int j = 0;  
  
            while (raw.length - j * blockSize > 0) {  
                bout.write(cipher.doFinal(raw, j * blockSize, blockSize));  
                j++;  
            }  
            return bout.toByteArray();  
        } catch (Exception e) {  
        	return null;
        }  
    }   
}