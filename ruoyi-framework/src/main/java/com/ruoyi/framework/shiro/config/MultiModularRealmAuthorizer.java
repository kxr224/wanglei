package com.ruoyi.framework.shiro.config;

import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Iterator;

public class MultiModularRealmAuthorizer extends ModularRealmAuthorizer {

    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        this.assertRealmsConfigured();

        Iterator var3 = this.getRealms().iterator();

        Realm realm;
        do {
            if (!var3.hasNext()) {
                return false;
            }


            realm = (Realm)var3.next();
            if (hasRealmFromPrincipals(realm, principals)){
                if(((Authorizer)realm).isPermitted(principals, permission)){
                    break;
                }
            }

        } while(true);

        return true;
    }
    private boolean hasRealmFromPrincipals(Realm realm, PrincipalCollection principals){
        String realmClassName = getStringLeft(realm.getName().toLowerCase(), "_");

        for (String realmNames:principals.getRealmNames()) {
            if (realmNames.toLowerCase().contains(realmClassName)){
                return true;
            }
        }
        return false;
    }

    private static String getStringLeft(String allStr, String tag) {
        int index = allStr.indexOf(tag);
        if (index <= 0 || index > allStr.length()) return "";
        return allStr.substring(0, index);
    }
}
