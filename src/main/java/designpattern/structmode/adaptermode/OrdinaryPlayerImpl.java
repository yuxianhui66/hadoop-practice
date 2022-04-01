package designpattern.structmode.adaptermode;

/**
 * @author yuxianhui
 * @create 2019-08-14 17:08
 **/
public class OrdinaryPlayerImpl implements OrdinaryPlayer {
    private OrdinaryPlayerAdapter ordinaryPlayerAdapter;

    public OrdinaryPlayerImpl(OrdinaryPlayerAdapter ordinaryPlayerAdapter) {
        this.ordinaryPlayerAdapter = ordinaryPlayerAdapter;
    }

    @Override
    public void play(String playType,String fileName) {
        ordinaryPlayerAdapter.OrdinaryPlayerAdapter(playType);
        ordinaryPlayerAdapter.play(playType,fileName);
        System.out.println(playType+"play"+fileName);
    }
}
