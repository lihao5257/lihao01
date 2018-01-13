package com.lee.demo.lambda;

import java.util.function.BiConsumer;

public class Unit1ExercistWithLambdaWithException {

	public static void main(String args[]) {
		int [] someNumbers = {1,2,3,4};
		int key = 0;
		/*第二种设想是在 process 方法中�?第三个参数外侧添�?try catch
		�?是那样�?话，跟java 7�?匿名类有些相似?���?�且，又会增加耦合度�?
		�?后，使用现在�?��第三种方式来捕获异常。可能会觉得麻烦?��跟之前�?两种方法没�?么区别?�?
		�?是第三种方式，�?�觉得有些像AOP?���?�且这�?�对结构�?入侵要�?*/
		process (someNumbers, key, wrapperLambda((k ,v) -> System.out.println(k/v)));
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> wrapper) {
		return (k ,v) -> {
			try {
				wrapper.accept(k, v);
			} catch (ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda");
			}
		};
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		// Exception�?捕捉�?第�?种设想是在下面代码块�?外侧追�?try catch 来捕捉异常
		// �?是?��这只是个抽象的process�?方法，不�?�确定实现类中出现�?异常?��所以在这里捕捉?��不合�?
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
	}
}

