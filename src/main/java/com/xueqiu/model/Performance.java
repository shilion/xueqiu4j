/*
 * Copyright (c) 2010, Snowball Finance and/or its affiliates;//All rights reserved.
 * SNOWBALLFINANCE PROPRIETARY/CONFIDENTIAL;//Use is subject to license terms.
 */
package com.xueqiu.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Performance implements Serializable {

    private static final long serialVersionUID = -6958813379576812127L;

    private Integer type;// 收益类型
	private Long time;// 收益日期:yyyy-MM-dd
	private String symbol;// 股票收益的股票代码
	private Double principal;// 本金
	private Double cash;// 现金
	private Double assets;// 总资产
    @SerializedName("market_value")
	private Double marketValue;// 持有市值
    @SerializedName("monetary_unit")
	private String monetaryUnit;// 币种 [示例:CNY、USD 等 可参考:http://www.dzkc.net/money.htm]
	private Double shares;// 持股数
	private Double holdpercent;// 持仓占比
	private Double dilutedcost;// 摊薄成本
	private Double holdcost;// 持仓成本
    @SerializedName("accum_amount")
	private Double accumAmount;// 累计盈亏额
    @SerializedName("accum_rate")
	private Double accumRate;// 累计盈亏率
    @SerializedName("float_amount")
	private Double floatAmount;// 浮动盈亏额
    @SerializedName("float_rate")
	private Double floatRate;// 浮动盈亏率
    @SerializedName("day_amount")
	private Double dayAmount;// 当日盈亏额
    @SerializedName("day_rate")
	private Double dayRate;// 当日盈亏率
    @SerializedName("week_amount")
	private Double weekAmount;// 本周盈亏额
    @SerializedName("week_rate")
	private Double weekRate;// 本周盈亏率
    @SerializedName("month_amount")
	private Double monthAmount;// 本月盈亏额
    @SerializedName("month_rate")
	private Double monthRate;// 本月盈亏率

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getAssets() {
        return assets;
    }

    public void setAssets(Double assets) {
        this.assets = assets;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public String getMonetaryUnit() {
        return monetaryUnit;
    }

    public void setMonetaryUnit(String monetaryUnit) {
        this.monetaryUnit = monetaryUnit;
    }

    public Double getShares() {
        return shares;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }

    public Double getHoldpercent() {
        return holdpercent;
    }

    public void setHoldpercent(Double holdpercent) {
        this.holdpercent = holdpercent;
    }

    public Double getDilutedcost() {
        return dilutedcost;
    }

    public void setDilutedcost(Double dilutedcost) {
        this.dilutedcost = dilutedcost;
    }

    public Double getHoldcost() {
        return holdcost;
    }

    public void setHoldcost(Double holdcost) {
        this.holdcost = holdcost;
    }

    public Double getAccumAmount() {
        return accumAmount;
    }

    public void setAccumAmount(Double accumAmount) {
        this.accumAmount = accumAmount;
    }

    public Double getAccumRate() {
        return accumRate;
    }

    public void setAccumRate(Double accumRate) {
        this.accumRate = accumRate;
    }

    public Double getFloatAmount() {
        return floatAmount;
    }

    public void setFloatAmount(Double floatAmount) {
        this.floatAmount = floatAmount;
    }

    public Double getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(Double floatRate) {
        this.floatRate = floatRate;
    }

    public Double getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(Double dayAmount) {
        this.dayAmount = dayAmount;
    }

    public Double getDayRate() {
        return dayRate;
    }

    public void setDayRate(Double dayRate) {
        this.dayRate = dayRate;
    }

    public Double getWeekAmount() {
        return weekAmount;
    }

    public void setWeekAmount(Double weekAmount) {
        this.weekAmount = weekAmount;
    }

    public Double getWeekRate() {
        return weekRate;
    }

    public void setWeekRate(Double weekRate) {
        this.weekRate = weekRate;
    }

    public Double getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Double monthAmount) {
        this.monthAmount = monthAmount;
    }

    public Double getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(Double monthRate) {
        this.monthRate = monthRate;
    }
}
