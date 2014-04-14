/*
 * Copyright (c) 2010, Snowball Finance and/or its affiliates. All rights reserved.
 * SNOWBALLFINANCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.xueqiu.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Transaction implements Serializable{

    private static final long serialVersionUID = -488029412774938506L;

    @SerializedName("unique_id")
    private String uniqueId; //券商数据id: 唯一标示券商单条数据
    @SerializedName("stock_type")
	private String stockType; //品类 [stock=股票， exchange_fund=场内基金， money_fund=货币基金]
	private String symbol; //股票代码 [沪深股票、场内基金 在代码前加 SH、SZ； 货币基金在代码前加 MF]
    @SerializedName("trans_type")
	private Integer transType; //成交类型 [股票支持类型：1=买入; 2=卖出; 3=补仓; 4=卖空; 7合股，8拆股; 9 分红派息] [货币基金支持类型：1=买入; 2=卖出; ]
	private Long time; //成交日期 [trans_type=9时，是除权日]
	private Double shares;//成交数量
	private Double price;// 成交价
    @SerializedName("unit_shares")
	private Double unitShares; //合股，拆股，送股 [unit_shares=n. type=7 时,n 股合成 1 股; type=8 时,1 股拆成 n 股]
    @SerializedName("unit_increase_shares")
	private Double unitIncreaseShares; // 转增 [unit_shares=n, type=9 时,10 股转增 n 股]
    @SerializedName("unit_dividend")
	private Double unitDividend; //股息 [type=9 时,10 股红息 n 元]
    private Double commission; // 佣金（金额）
    @SerializedName("commission_rate")
	private Double commissionRate; // 佣金（xx.xx/1000，千分比）
	private Double tax; // 税率（金额）
    @SerializedName("tax_rate")
	private Double taxRate; // 税率（xx.xx/1000,千分比）数据库存的是xx.xx,使用时除1000
	private Double otherfee; //其它费用
    @SerializedName("otherfee_rate")
    private Double otherfeeRate; //其它费率
	private String comment; // 备注
    @SerializedName("earning_type")
	private Integer earningType; //货币基金收益计算类型 [1=赎回日计算,申购日不计 算 2=申购日计算,赎回日不计算]
	private Integer day; //红利再分配日期,每月xx号

    public static void main(String[] args) {
        Gson gson = new Gson();
        Transaction t = new Transaction();
        t.setCommissionRate(1.2);
        System.out.println(gson.toJson(t));
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getShares() {
        return shares;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getUnitShares() {
        return unitShares;
    }

    public void setUnitShares(Double unitShares) {
        this.unitShares = unitShares;
    }

    public Double getUnitIncreaseShares() {
        return unitIncreaseShares;
    }

    public void setUnitIncreaseShares(Double unitIncreaseShares) {
        this.unitIncreaseShares = unitIncreaseShares;
    }

    public Double getUnitDividend() {
        return unitDividend;
    }

    public void setUnitDividend(Double unitDividend) {
        this.unitDividend = unitDividend;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getOtherfee() {
        return otherfee;
    }

    public void setOtherfee(Double otherfee) {
        this.otherfee = otherfee;
    }

    public Double getOtherfeeRate() {
        return otherfeeRate;
    }

    public void setOtherfeeRate(Double otherfeeRate) {
        this.otherfeeRate = otherfeeRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getEarningType() {
        return earningType;
    }

    public void setEarningType(Integer earningType) {
        this.earningType = earningType;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
