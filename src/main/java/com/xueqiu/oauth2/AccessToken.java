package com.xueqiu.oauth2;

import java.io.Serializable;

/**
 * Created by lshi on 3/26/14.
 */
public class AccessToken implements Serializable {

    private static final long serialVersionUID = -8902095953714952567L;

    private String accessToken;
    private String expireIn;
    private String refreshToken;
    private String uid;

    public AccessToken(String accessToken, String expireIn, String refreshToken, String uid) {
        this.accessToken = accessToken;
        this.expireIn = expireIn;
        this.refreshToken = refreshToken;
        this.uid = uid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expireIn='" + expireIn + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
