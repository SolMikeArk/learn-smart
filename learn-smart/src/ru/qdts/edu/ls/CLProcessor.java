package ru.qdts.edu.ls;

import java.util.Scanner;

public class CLProcessor extends Thread {
	private boolean stop = false;

	public void run() {
		mainMenu();
	}

	public void finish() {
		stop = true;
	}

	private int mainMenu() {

		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("""
						Выберите действие:
						[1] Вывести список курсов в каталоге
						[2] Просмотр курсов
						[3] Назначение рейтинга
						[Q] Выход
						""");

				switch (sc.next()) {
				case "1" -> {
					System.out.println("Выбран список курсов");
					return 1;
				}
				case "2" -> {
					System.out.println("Выбран просмотр курсов");
					return 2;
				}
				case "3" -> {
					System.out.println("Выбрано назначение рейтинга");
					return 3;
				}
				case "Q", "q" -> {
					return 0;
				}
				default -> System.out.println("Недопустимое значение, введите 1, 2, 3 или Q для завершения");
				}
			} while (true);

		}
	}
}
