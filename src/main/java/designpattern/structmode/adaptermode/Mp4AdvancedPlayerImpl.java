package designpattern.structmode.adaptermode;

/**
 * @author yuxianhui
 * @create 2019-08-14 17:19
 **/
public class Mp4AdvancedPlayerImpl implements AdvancedPlayer {
    @Override
    public void playVl(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("play mp4");
    }
}
