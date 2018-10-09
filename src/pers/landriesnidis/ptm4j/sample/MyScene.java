package pers.landriesnidis.ptm4j.sample;

import pers.landriesnidis.ptm4j.sample.menu.RootMenu;
import pers.landriesnidis.ptm4j.scene.Scene;
import pers.landriesnidis.ptm4j.scene.io.SceneReader;

public class MyScene extends Scene {

	public MyScene(SceneReader reader) {
		super(reader);
		RootMenu rm = new RootMenu();
		setRootMenu(rm);
	}
}