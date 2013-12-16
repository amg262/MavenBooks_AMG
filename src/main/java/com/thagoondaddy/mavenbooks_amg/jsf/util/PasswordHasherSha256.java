
package com.thagoondaddy.mavenbooks_amg.jsf.util;


import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.io.Serializable;
import java.text.MessageFormat;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * Utility class that is used to encrypt passwords (or any text).
 * Uses sha-256 bit encryption method that can be called to encrypt 
 * password before writing it to DB
 * 
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Named
@SessionScoped
public class PasswordHasherSha256 implements Serializable {
    
    /**
     *
     * @param password
     * @return
     */
    public String generateHash(String password){
        
        String hash
                = Hashing.sha256()
                .hashString(password, Charsets.UTF_8).toString();

//        String output = MessageFormat.format("{0} hashed to: {1}", password, hash);
//
//        System.out.println(output);
        
        return hash;
    }
    
//    public static void main(String[] args) {
//        PasswordHasherSha256 ph = new PasswordHasherSha256();
//        ph.generateHash("hashcode");
//    }
}
