package com.lee.demo.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo06 {

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<String>> list = new LinkedList<Future<String>>();
		for (int i=0 ; i< 10 ; i++){
			list.add(service.submit(new TaskWithResult(i)));
		}
		for (Future<String> fs : list) {
			try {
				// get方法会�?�许返回值?��如果任务尚未执行结束?��会�?直等�??���??成阻�?
				// 可以用isDone方法来判断?��任务是否执行结束
				System.out.println("future done? " + fs.isDone());
				System.out.println(fs.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				return;
			} finally {
				service.shutdown();
			}
		} 
	}
}

class TaskWithResult implements Callable<String> {

	private int id;
	public TaskWithResult (int id) {
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}
}
