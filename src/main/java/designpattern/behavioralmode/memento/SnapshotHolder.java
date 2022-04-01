package designpattern.behavioralmode.memento;

import java.util.Stack;

/**
 * @author yuxianhui
 * @create 2020-06-19 15:12
 **/
public class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();
    public Snapshot popSnapshot() {
        return snapshots.pop();
    }
    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
