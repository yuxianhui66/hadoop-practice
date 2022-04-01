package com.calprice;

/**
 * @author yuxianhui
 * @create 2020-06-18 10:44
 **/
@OnceValidRegion(@ValidRegion(min=2000,order=40))
class TwotDFourH implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice - 400;
    }

}
