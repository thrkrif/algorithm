package dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskScheduler {

    private Deque<Task> tasks;

    public TaskScheduler(){
        tasks = new ArrayDeque<>(); // 객체가 만들어지면 그제서야 덱큐를 생성함.
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getRemainingTasks() {
        return tasks.size();
    }

    public void processNextTask() {
        Task currentTask = tasks.poll();
        if (currentTask != null) currentTask.execute();
    }
}
