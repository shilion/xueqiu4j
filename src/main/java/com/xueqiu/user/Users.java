package com.xueqiu.user;

import com.google.gson.Gson;
import com.xueqiu.Xueqiu;
import com.xueqiu.model.User;
import com.xueqiu.util.Config;
import com.xueqiu.util.HttpClientUtil;

/**
 * Created by lshi on 6/11/14.
 */
public class Users extends Xueqiu {
    private static final long serialVersionUID = 6407852469964504201L;

    public User get() {

        String ret = HttpClientUtil.sendGet(
                Config.getValue("api_root_url") + "/user/show.json?access_token=" + this.getAccessToken(), "utf-8");
        System.out.println(ret);

        Gson gson = new Gson();
        return gson.fromJson(ret, User.class);
    }

    public static void main(String[] args) {
        Users users = new Users();
        //TODO set access_token
        users.setAccessToken("");
        User user = users.get();
    }
}
