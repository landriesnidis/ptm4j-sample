package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.scritp.Luaj;
import pers.landriesnidis.ptm4j.menu.scritp.exception.MenuScriptException;
 
public class RootMenu extends TextMenu{
	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("功能演示");
		setTextContent("以下是PyramidTextMenu v1.3.0 中包含的功能演示：");
		setAllowShowSerialNumber(true);
		
		try {
			addTextLine("\n·-·-·基础功能演示·-·-·");
			addMenuOption("常见的选项类型", BasicFunctionExample.class);
			addMenuOption("选项附加代码段", OptionHandlerExample.class);
			addMenuOption("菜单的基本设置", MenuSettingsExample.class);
			
			addTextLine("\n·-·-·进阶功能演示·-·-·");
			addMenuOption("菜单的生命周期", LifeCycleExample.class);
			addMenuOption("用脚本动态开发", Luaj.createTextMenuFromScriptFile("./script/SimpleScript.lua"));
			
			addTextLine("\n·-·-·功能特性演示·-·-·");
			addTextOption("资源独占与共享", "该部分示例尚未完成.");
			addTextOption("菜单层级去环形", "该部分示例尚未完成.");
		} catch (MenuScriptException e) {
			e.printStackTrace();
		}
	}
}