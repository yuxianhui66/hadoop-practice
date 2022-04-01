package designpattern.behavioralmode.memento;

/**
 * @author yuxianhui
 * @create 2020-06-19 15:11
 **/
public class Snapshot {
    private String text;
    public Snapshot(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
}
