package designpattern.structmode.adaptermode;

/**
 * @author yuxianhui
 * @create 2019-08-14 17:10
 **/
public class OrdinaryPlayerAdapter implements OrdinaryPlayer {

    private AdvancedPlayer advancedPlayer;

    public void OrdinaryPlayerAdapter(String playType) {
        if(playType.equals("vl")){
            advancedPlayer = new VLAdvancedPlayerImpl();
        }
        if(playType.equals("mp4")){
            advancedPlayer = new Mp4AdvancedPlayerImpl();
        }
    }

    @Override
    public void play(String playType,String fileName) {
        if(playType.equals("vl")) {
            advancedPlayer.playVl(fileName);
        }
        if(playType.equals("mp4")) {
            advancedPlayer.playMp4(fileName);
        }
        System.out.println("adapter play ");
    }
}
