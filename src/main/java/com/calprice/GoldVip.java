package com.calprice;

/**
 * @author yuxianhui
 * @create 2020-06-18 10:44
 **/
@TotalValidRegion(@ValidRegion(min=3000,order=99))
class GoldVip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }

}