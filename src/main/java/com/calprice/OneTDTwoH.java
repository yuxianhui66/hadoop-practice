package com.calprice;

/**
 * @author yuxianhui
 * @create 2020-06-18 10:44
 **/
@OnceValidRegion(@ValidRegion(min=1000,max=2000,order=40))
class OneTDTwoH implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice - 200;
    }

}