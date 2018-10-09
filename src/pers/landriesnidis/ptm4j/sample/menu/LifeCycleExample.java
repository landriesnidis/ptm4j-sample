package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;

public class LifeCycleExample extends TextMenu{

	@Override
	public void onCreate() {
		super.onCreate();

		setTitle("菜单的生命周期");
		setTextContent("生命周期包含以下6部分，选择下列选项查阅相关信息。");
		setAllowShowSerialNumber(true);
		
		addTextLine();
		addTextOption("onCreate()", "onCreate()方法：\n当菜单被实例化的时候会被执行，但此时由于还未被加载入任何场景中所以不会获得会话环境，也因此onCreate()触发时无法输出任何信息，仅做初始化操作。");
		addTextOption("onLoad(LoadEvent e)", "onLoad(LoadEvent e)方法：\n当菜单被加载入场景时会被执行。");
		addTextOption("onStart(StartEvent e)", "onStart(StartEvent e)方法：\n当菜单正式启动时会被执行，这里可以接收到来自上一级菜单的字符串类型的参数数组。");
		addTextOption("onStop(StopEvent e)", "onStop(StopEvent e)方法：\n当菜单跳转向另一个菜单时会被触发。");
		addTextOption("onBack(BackEvent e)", "onBack(BackEvent e)方法：\n当从下一级菜单返回该菜单时会被执行，这里可以接收到来自下一级菜单的字符串类型的参数数组。");
		addTextOption("onUnload()", "onUnload()方法：\n当菜单被从场景中移除时会被执行，此处不会接收到事件参数。注意：如果菜单在多个场景间共享，则该方法也会被执行多次。");
		
		addTextLine("\n选择下方提供的选项以触发事件：");
		addArgsMenuOption("菜单跳转演示", MenuTurnsExample.class);
		addTextLine();
		addBackOption("返回");
	}
	
	@Override
	public void onLoad(LoadEvent e) {
		super.onLoad(e);
		showMessage("触发onLoad()方法.", e.getSceneContext(), null);
	}
	
	@Override
	public void onStart(StartEvent e) {
		super.onStart(e);
		showMessage("触发onStart()方法.", e.getSceneContext(), null);
	}
	
	@Override
	public void onStop(StopEvent e) {
		super.onStop(e);
		showMessage("触发onStop()方法.", e.getSceneContext(), null);
	}
	
	@Override
	public void onBack(BackEvent e) {
		super.onBack(e);
		StringBuilder sb = new StringBuilder("触发onBack()方法.");
		if(e.getArgs()!=null && e.getArgs().length>1){
			sb.append("接收到了返回参数：");
			for(String str:e.getArgs()){
				sb.append(str);
				sb.append(" ");
			}
		}
		showMessage(sb.toString(), e.getSceneContext(), null);
	}

	@Override
	public void onUnload() {
		super.onUnload();
	}
}
