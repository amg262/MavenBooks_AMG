
package com.thagoondaddy.mavenbooks_amg.model;


import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.io.Serializable;
import java.text.MessageFormat;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Named
@SessionScoped
public class PasswordHasher implements Serializable {
    
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
//        PasswordHasher ph = new PasswordHasher();
//        ph.generateHash("hashcode");
//    }
}
