package org.maxwell.designpatterns.snapshot;

import java.util.Stack;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/24 15:36
 */
public class SnapshotHolder {

    private final Stack<Snapshot> snapshots = new Stack<>();


    public Snapshot popSnapshot() {
        return snapshots.pop();
    }


    public void pushSnapshot(Snapshot snapshot) {
        Snapshot frame = new Snapshot(snapshot.text());
        snapshots.push(frame);
    }


}
