package pers.landriesnidis.ptm4j.sample;

import java.util.Scanner;

import pers.landriesnidis.ptm4j.menu.context.IMenuContext;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;
import pers.landriesnidis.ptm4j.scene.io.SceneReader;

public class Main {
	public static void main(String[] args) {
		
		MyScene robot = new MyScene(new SceneReader() {
			@Override
			public void output(String text, IMenuContext menuContext, ISceneContext context, Object dataTag) {
				System.out.println(text);
			}
		});
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			try {
				String text = scanner.nextLine();
				robot.input(text,null);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		scanner.close();
	}
}
