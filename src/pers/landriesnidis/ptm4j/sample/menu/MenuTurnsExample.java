package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;

public class MenuTurnsExample extends TextMenu{

	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("菜单跳转演示");
		setAllowShowSerialNumber(true);
		setTextContent("当前菜单可接受上一级菜单跳转时的传递的参数。同时，菜单选项中的返回类型选项也可以携带参数返回至上一级菜单。");
		
		addBackOption("返回");
	}
	
	@Override
	public void onStart(StartEvent e) {
		super.onStart(e);
		
		StringBuilder sb = new StringBuilder("您当前的跳转类型为：");
		switch(e.getActionType()){
		case MENU:
			sb.append("无参跳转");
			break;
		case MENU_ARGS:
			sb.append("有参跳转\n参数个数为：");
			sb.append(e.getArgs().length);
			if(e.getArgs().length>1){
				sb.append("\n参数为：");
				for(String str:e.getArgs()){
					sb.append(str);
					sb.append(" ");
				}
			}
			break;
		default:
			
			break;		
		}
		showMessage(sb.toString(), e.getSceneContext(), null);
	}
}
