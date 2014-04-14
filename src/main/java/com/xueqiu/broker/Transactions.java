package com.xueqiu.broker;

import com.google.gson.Gson;
import com.xueqiu.Xueqiu;
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
public class Transactions extends Xueqiu {

    private static final long serialVersionUID = -1578269281627777721L;

    public boolean sync(List<Transaction> tlist, boolean isShare) {

        Gson gson = new Gson();
        String json = gson.toJson(tlist);

        return sync(json, isShare);
    }

    public boolean sync(String json, boolean isShare) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("data", json);
        params.put("is_share", isShare ? "1" : "0");
        params.put("access_token", this.getAccessToken());

        String ret = HttpClientUtil.sendPost(Config.getValue("api_root_url") + "/broker/sync/transaction.json", params, "utf-8");
        System.out.println(ret);

        return true;
    }

    public static void main(String[] args) {
        List<Transaction> tlist = new ArrayList<Transaction>();
        for(int i=0; i<1; i++) {
            Transaction t = new Transaction();
            t.setStockType("stock");
            t.setUniqueId("M0000000" + i);
//            t.setUniqueId("M0000000");
            t.setTransType(1);
            t.setTime(1394791330620L);
            t.setSymbol(map.get(i));
            t.setPrice(3.86 + i);
            t.setShares(20000D);
            t.setTax(0.1);
            t.setTaxRate(0D);
            t.setCommission(0.1);
            t.setCommissionRate(0D);
            t.setOtherfee(0.1);
            t.setOtherfeeRate(0D);
            t.setComment("看好目标价到"+t.getPrice()*1.2);
            tlist.add(t);
        }
        Transactions ts = new Transactions();
        //TODO set access_token
        ts.setAccessToken("");
        ts.sync(tlist, true);
    }

    public final static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "SH600000");
        map.put(1, "SH600004");
        map.put(2, "SH600005");
        map.put(3, "SH600006");
        map.put(4, "SH600007");
        map.put(5, "SH600008");
        map.put(6, "SH600009");
        map.put(7, "SH600010");
        map.put(8, "SH600011");
        map.put(9, "SH600012");
        map.put(10, "SH600015");
        map.put(11, "SH600016");
        map.put(12, "SH600017");
        map.put(13, "SH600018");
        map.put(14, "SH600019");
        map.put(15, "SH600020");
        map.put(16, "SH600021");
        map.put(17, "SH600022");
        map.put(18, "SH600023");
        map.put(19, "SH600026");
        map.put(20, "SH600027");
        map.put(21, "SH600028");
        map.put(22, "SH600029");
        map.put(23, "SH600030");

    }

}
