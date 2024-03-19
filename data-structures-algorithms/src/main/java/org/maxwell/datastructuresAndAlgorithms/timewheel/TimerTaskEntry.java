package org.maxwell.datastructuresAndAlgorithms.timewheel;

import java.util.TimerTask;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/18 19:41
 */
public class TimerTaskEntry implements Comparable<TimerTaskEntry> {


    volatile TimerTaskList timerTaskList;
    TimerTaskEntry next;
    TimerTaskEntry prev;

    private TimerTask timerTask;
    private long expireMs;


    public TimerTaskEntry(TimerTask timerTask, long expireMs) {
        this.timerTask = timerTask;
        this.expireMs = expireMs;
    }


    public TimerTaskList getTimerTaskList() {
        return timerTaskList;
    }

    public void setTimerTaskList(TimerTaskList timerTaskList) {
        this.timerTaskList = timerTaskList;
    }

    public TimerTask getTimerTask() {
        return timerTask;
    }

    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }


    void remove() {
        TimerTaskList currentList = timerTaskList;
        while (currentList != null){
            timerTaskList.remove(this);
            currentList = timerTaskList;
        }
    }

    @Override
    public int compareTo(TimerTaskEntry o) {
        return (int) (this.expireMs - o.expireMs);
    }
}
