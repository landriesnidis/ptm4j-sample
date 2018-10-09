package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.option.base.OptionHandler;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class MenuSettingsExample extends TextMenu{
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("菜单的基本设置");
		setAllowShowSerialNumber(true);
		setTextContent("简单展示菜单配置的功能：");
		
		addTextOption("序号开关", null);
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext) {
				setAllowShowSerialNumber(!isAllowShowSerialNumber());
				showMenu(sceneContext, dataTag);
				return false;
			}
		});
		
		addTextOption("无效消息接收开关", null);
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext) {
				setAllowReveiceText(!isAllowReveiceText());
				if(isAllowReveiceText()){
					showMessage("无效消息接收已开启，请随意发送信息吧。", sceneContext, dataTag);
				}else{
					showMessage("无效消息接收已关闭。", sceneContext, dataTag);
				}
				return true;
			}
		});
		
		addBackOption("返回");
	}
	
	@Override
	public boolean onTextReveived(String text, ISceneContext sceneContext, Object dataTag) {
		showMessage(String.format("接收到消息：%s", text), sceneContext, dataTag);
		return super.onTextReveived(text, sceneContext, dataTag);
	}
}
