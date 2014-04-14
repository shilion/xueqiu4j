package com.xueqiu.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtil implements java.io.Serializable {

    private static final Logger log = Logger.getLogger(HttpClientUtil.class);

    /**
     * Send get to URL.
     *
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        HttpClient httpClient = new DefaultHttpClient();

        String content = null;
        try {
            if(url.indexOf("https") != -1){
                httpClient = wrapClient(httpClient);
            }
            HttpGet httpGet = new HttpGet(url);
            // 请求超时
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 40000);
            // 读取超时
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 40000);

            httpClient.getParams().setParameter(AllClientPNames.STRICT_TRANSFER_ENCODING,"GBK");

            content = httpClient.execute(httpGet, new BasicResponseHandler());
        } catch (Exception e) {
            log.error("Get url faild, url: " + url, e);
            content = null;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return content;
    }


    public static String sendGet(String url, String encoding){
        return sendGet(url, encoding, null);
    }

    public static String sendGet(String url, String encoding, String ip) {
        HttpClient httpClient = new DefaultHttpClient();

        String content = null;
        try {
            if(url.indexOf("https") != -1){
                httpClient = wrapClient(httpClient);
            }
            HttpGet httpGet = new HttpGet(url);
            if(ip != null){
                httpGet.setHeader("X-Forwarded-For", ip);
            }
            // 请求超时
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 40000);
            // 读取超时
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 40000);
            httpClient.getParams().setParameter(AllClientPNames.STRICT_TRANSFER_ENCODING, encoding);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 使用EntityUtils的toString方法，传递默认编码，在EntityUtils中的默认编码是ISO-8859-1
                content = EntityUtils.toString(entity, encoding);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Get url faild, url: " + url, e);
            content = null;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return content;
    }

    /**
     * Send post to URL.
     *
     * @param url
     * @return
     */
    public static String sendPost(String url) {
        return sendPost(url, (Map<String, String>) null, null);
    }

    /**
     * Send post to URL with parameters.
     *
     * @param url
     * @param parameterMap
     * @return
     */
    public static String sendPost(String url, Map<String, String> parameterMap) {
        return sendPost(url, parameterMap, null);
    }

    public static String sendPost(String url, Map<String, String> parameterMap, String encoding) {
        return sendPost(url, parameterMap, encoding, null, false);
    }

    /**
     * Send post to URL with parameters by given encoding.
     *
     * @param url
     * @param parameterMap
     * @param encoding
     * @return
     */
    public static String sendPost(String url, Map<String, String> parameterMap, String encoding, String ip, boolean isBasicResHandler) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        if(ip != null){
            httpPost.setHeader("X-Forwarded-For", ip);
        }
        //httpPost.setHeader("Host", "api.xueqiu.com");
        if (parameterMap != null && !parameterMap.isEmpty()) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Iterator<Map.Entry<String, String>> it = parameterMap.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String, String> entry = it.next();
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                if (encoding == null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                } else {
                    httpPost.setEntity(new UrlEncodedFormEntity(params, encoding));
                }
            } catch (UnsupportedEncodingException e) {
                log.error("Encode the parameter failed!", e);
            }
        }

        String content = null;
        try {
            if(url.indexOf("https") != -1){
                httpClient = wrapClient(httpClient);
            }
            if(isBasicResHandler){
                content = httpClient.execute(httpPost, new BasicResponseHandler());
            }else{
                HttpResponse httpresponse = httpClient.execute(httpPost);
                content = EntityUtils.toString(httpresponse.getEntity());
            }
        } catch (Exception e) {
            log.error("Get url faild, url: " + url, e);
            content = null;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return content;
    }


    /**
     * Send post to URL with parameters by given encoding.
     *
     * @param url
     * @param params
     * @param encoding
     * @return
     */
    public static String sendPost(String url, List<NameValuePair> params, String encoding) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        String content = null;
        try {
            if(url.indexOf("https") != -1){
                httpClient = wrapClient(httpClient);
            }
            if (params != null && !params.isEmpty()) {
                try {
                    if (encoding == null) {
                        httpPost.setEntity(new UrlEncodedFormEntity(params));
                    } else {
                        httpPost.setEntity(new UrlEncodedFormEntity(params, encoding));
                    }
                } catch (UnsupportedEncodingException e) {
                    log.error("Encode the parameter failed!", e);
                }
            }



            content = httpClient.execute(httpPost, new BasicResponseHandler());
        } catch (Exception e) {
            log.error("Get url faild, url: " + url, e);
            content = null;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return content;
    }

    @SuppressWarnings("deprecation")
    public static HttpClient wrapClient(HttpClient base) throws Exception{
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] xcs,
                                               String string) {
                }

                public void checkServerTrusted(X509Certificate[] xcs,
                                               String string) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = base.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", ssf, 443));
            return new DefaultHttpClient(ccm, base.getParams());
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
            throw ex;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while(true) {
            sendGet("http://baidu.com");
            Thread.sleep(200L);
        }
    }
	
}
