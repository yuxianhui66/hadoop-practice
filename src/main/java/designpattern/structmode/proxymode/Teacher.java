package designpattern.structmode.proxymode;

/**
 * @author yuxianhui
 * @create 2020-06-18 12:06
 **/
public class Teacher implements People{

    @Override
    public String work() {
        System.out.println("老师教书育人...");
        return "教书";
    }

}

