package com.calprice;

/**
 * @author yuxianhui
 * @create 2020-06-18 10:43
 **/
@TotalValidRegion(@ValidRegion(min=2000,max=3000,order=99))
class SuperVip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }

}