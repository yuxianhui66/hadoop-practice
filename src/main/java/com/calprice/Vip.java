package com.calprice;

/**
 * @author yuxianhui
 * @create 2020-06-18 10:43
 **/
@TotalValidRegion(@ValidRegion(min=1000,max=2000,order=99))
class Vip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }

}
