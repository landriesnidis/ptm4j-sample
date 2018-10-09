package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;

public class BasicFunctionExample extends TextMenu{

	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("基础功能演示");
		setAllowShowSerialNumber(true);
		setTextContent("下面将演示PyramidTextMenu中几种常见的选项类型：");
		
		addTextLine();
		addTextOption("简单文本选项", "简单文本选项可设置返回文本或不设置返回文本。无返回文本的简单文本选项通常用于附加动作接口执行一段特定代码，具体的使用方法会在后续示例展示。简单文本选项执行后用户仍然处于当前的菜单中（由附加动作导致跳转的情况除外）。");
		
		addTextLine();
		addMenuOption("无参菜单跳转选项", MenuTurnsExample.class);
		
		addTextLine();
		addArgsMenuOption("有参菜单跳转选项", MenuTurnsExample.class);
		addTextOption("关于“有参菜单跳转选项”的说明","使用有参菜单跳转选项携带参数时以空格为分割符，可接受多个参数。");
		
		addTextLine();
		addReloadOption("重新加载选项");
		addTextOption("关于“重新加载选项”的说明","重新加载选项会创建一个与当前菜单类型相同的新实例，可接受多个参数。");
		
		addTextLine("\n·-·-·自定义文本的分割线·-·-·");
		addBackOption("通用返回选项");
		
		addBackRootOption("根目录返回选项");
	}
	
	@Override
	public void onBack(BackEvent e) {
		super.onBack(e);
		
		if(e.getArgs()!=null && e.getActionType()==ActionType.BACK && e.getArgs().length>1){
			StringBuilder sb = new StringBuilder("接收到了返回参数：");
			for(String str:e.getArgs()){
				sb.append(str);
				sb.append(" ");
			}
			showMessage(sb.toString(), e.getSceneContext(), null);
		}
	}
}
