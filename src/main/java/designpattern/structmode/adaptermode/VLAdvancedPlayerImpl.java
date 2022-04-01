package designpattern.structmode.adaptermode;

/**
 * @author yuxianhui
 * @create 2019-08-14 17:08
 **/
public class VLAdvancedPlayerImpl implements AdvancedPlayer {
    @Override
    public void playVl(String fileName) {
        System.out.println("play vl");
    }

    @Override
    public void playMp4(String fileName) {

    }
}
