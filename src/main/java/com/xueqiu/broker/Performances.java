package com.xueqiu.broker;

import com.google.gson.Gson;
import com.xueqiu.Xueqiu;
import com.xueqiu.model.Performance;
import com.xueqiu.model.Transaction;
import com.xueqiu.util.Config;
import com.xueqiu.util.HttpClientUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lshi on 3/31/14.
 */
public class Performances extends Xueqiu {

    private static final long serialVersionUID = -6696476761330729358L;

    public boolean sync(List<Performance> plist) {

        Gson gson = new Gson();
        String json = gson.toJson(plist);

        return sync(json);
    }

    public boolean sync(String json) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("data", json);
        params.put("access_token", this.getAccessToken());

        String ret = HttpClientUtil.sendPost(Config.getValue("api_root_url") + "/broker/sync/performance.json", params);
        System.out.println(ret);

        return true;
    }

    public static void main(String[] args) {
        Performance p = new Performance();
        p.setType(2);
        p.setTime(1394791330620L);
        p.setCash(100.0);
        p.setAssets(10000.0);
        p.setPrincipal(5000.0);
        p.setMarketValue(12000.0);
        p.setFloatAmount(5000.0);
        p.setFloatRate(1.38);
        p.setAccumAmount(5000.0);
        p.setAccumRate(1.38);
        p.setDayAmount(100.0);
        p.setDayRate(0.01);
        p.setWeekAmount(500.0);
        p.setWeekRate(0.05);
        p.setMonthAmount(1000.0);
        p.setMonthRate(0.1);
        p.setMonetaryUnit("CNY");
        List<Performance> plist = new ArrayList<Performance>();
        plist.add(p);
        p = new Performance();
        p.setType(10);
        p.setSymbol("SZ000985");
        p.setTime(1394791330620L);
        p.setShares(2000D);
        p.setMarketValue(12000.0);
        p.setHoldpercent(0.3);
        p.setDilutedcost(0.3);
        p.setHoldcost(0.9);
        p.setFloatAmount(5000.0);
        p.setFloatRate(1.38);
        p.setAccumAmount(5000.0);
        p.setAccumRate(1.38);
        p.setDayAmount(100.0);
        p.setDayRate(0.01);
        p.setWeekAmount(500.0);
        p.setWeekRate(0.05);
        p.setMonthAmount(1000.0);
        p.setMonthRate(0.1);
        p.setMonetaryUnit("CNY");
        plist.add(p);
        Performances ps = new Performances();
        //TODO set access_token
        ps.setAccessToken("");
        ps.sync(plist);
    }
}
