package Ppasseng;

import java.util.Random;

public class ControllerClass {
	ViewClass _View;
	ModelClass _Model;

	public ControllerClass() {
		_View = new ViewClass();
	}

	void run() {
		int randnum;
		String str;
		Random random = new Random();

		randnum = random.nextInt(3) + 1;
		str = Integer.toString(randnum);

		_View.framefirst = new Frame_First();
		_View.music = new Music("intromusic" + str, true);
		_View.music.start();

	}

	public static void main(String args[]) {

		ControllerClass manager = new ControllerClass();
		manager.run();
	}
}
