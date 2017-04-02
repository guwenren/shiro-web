
package com.guwr.shiro.web.realm;


import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class JdbcRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("JdbcRealm.doGetAuthorizationInfo  认证");
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        Set<String> roles = new HashSet<>();
        roles.add("user");
        if (Objects.equals("admin", primaryPrincipal)) {
            roles.add("admin");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("JdbcRealm.doGetAuthorizationInfo  授权");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();

        if ("unknown".equals(username)) {
            throw new UnknownAccountException("用户不存在!");
        }

        if ("monster".equals(username)) {
            throw new LockedAccountException("用户被锁定");
        }

        if (Objects.equals("admin", username)) {

        } else if (Objects.equals("user", username)) {

        } else {
            throw new UnknownAccountException("帐号不存在");
        }

        Object principal = username;
        Object credentials = "928bfd2577490322a6e19b793691467e";
        String realmName = getName();

//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);


        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");

        Object hashedCredentials = credentials;

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
        return info;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        super.setCredentialsMatcher(credentialsMatcher);
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("admin");
        int hashIterations = 2;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}

