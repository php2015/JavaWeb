package com.kestrelcjx.system.shiro;

import com.kestrelcjx.common.utils.CommonUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义验证类
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String password = String.valueOf(utoken.getPassword());
        Object pwd = CommonUtils.password(password).getBytes();
        Object accountCredentials = getCredentials(info);
        return equals(pwd, accountCredentials);
    }
}

