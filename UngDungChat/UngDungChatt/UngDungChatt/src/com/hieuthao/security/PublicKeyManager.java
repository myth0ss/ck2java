
package com.hieuthao.security;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MinhHieu
 */
public class PublicKeyManager {
    private static PublicKeyManager instance;
    private Map<Integer, PublicKey> publicKeys;

    private PublicKeyManager() {
        publicKeys = new HashMap<>();
    }

    public static synchronized PublicKeyManager getInstance() {
        if (instance == null) {
            instance = new PublicKeyManager();
        }
        return instance;
    }

    public void addPublicKey(int userID, PublicKey publicKey) {
        publicKeys.put(userID, publicKey);
    }

    public PublicKey getPublicKey(int userID) {
        return publicKeys.get(userID);
    }
}
