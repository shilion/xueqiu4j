package com.xueqiu.oauth2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xueqiu.common.XueqiuException;
import com.xueqiu.util.BareBonesBrowserLaunch;
import com.xueqiu.util.Config;
import com.xueqiu.util.HttpClientUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lshi on 3/26/14.
 */
public class OAuth {

    /**
     * 获取access_token
     *
     * @param code
     * @return
     * @throws XueqiuException
     */
    public AccessToken getAccessTokenByCode(String code) throws XueqiuException {

        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", Config.getValue("client_id"));
        params.put("client_secret", Config.getValue("client_secret"));
        params.put("grant_type", "authorization_code");
        params.put("code", code);

        String json = HttpClientUtil.sendPost(Config.getValue("access_token_url"), params);

        return getAccessTokenFromJson(json);
    }

    /**
     * 获取access_token
     *
     * @param refreshToken
     * @return
     * @throws XueqiuException
     */
    public AccessToken getAccessTokenByRefreshToken(String refreshToken) throws XueqiuException {

        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", Config.getValue("client_id"));
        params.put("client_secret", Config.getValue("client_secret"));
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", refreshToken);

        String json = HttpClientUtil.sendPost(Config.getValue("access_token_url"), params);

        return getAccessTokenFromJson(json);
    }

    /**
     * 取授权页URL
     *
     * @param responseType
     * @return
     * @throws XueqiuException
     */
    public String getAuthorizeUrl(String responseType) throws XueqiuException {
        return Config.getValue("authorize_url").trim()
                + "?client_id=" + Config.getValue("client_id").trim()
                + "&response_type=" + responseType
                + "&redirect_uri=" + Config.getValue("redirect_uri").trim()
                ;
    }

    /**
     * 把json字符串转换成AccessToken对象
     *
     * @param json
     * @return
     */
    private AccessToken getAccessTokenFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> map = gson.fromJson(json, type);

        return map == null ? null : new AccessToken(map.get("access_token"), map.get("expires_in"), map.get("refresh_token"), map.get("uid"));
    }

    public static void main(String[] args) throws XueqiuException, IOException {
        OAuth oAuth = new OAuth();
        String oAuthUrl = oAuth.getAuthorizeUrl("code");
        BareBonesBrowserLaunch.openURL(oAuthUrl);
        System.out.println("oAuthUrl: " + oAuthUrl);
        System.out.print("Input 'code' and hit enter: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        System.out.println("code: " + code);
        AccessToken accessToken = oAuth.getAccessTokenByCode(code);
        System.out.println("--getAccessTokenByCode--");
        System.out.println(accessToken);
        System.out.println("--getAccessTokenByRefreshToken--");
        System.out.println(oAuth.getAccessTokenByRefreshToken(accessToken.getRefreshToken()));
    }
}
