package com.xueqiu;

import java.io.Serializable;

/**
 * Created by lshi on 3/26/14.
 */
public class Xueqiu implements Serializable {

    private static final long serialVersionUID = 6668604645160818717L;

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
